package com.oddcc.leetcode.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.HttpEntities;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private Config config;

    private String outputFile;

    private HttpClient client;

    private HttpContext httpContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(args.length + " args: " + String.join(",", args));
        prepare(args);
        updateQuestionsInfo();
    }

    private void prepare(String[] args) throws IOException {
        if (config.getAccount() == null || config.getAccount().isEmpty()) {
            throw new RuntimeException("account is empty");
        }
        if (config.getPassword() == null || config.getPassword().isEmpty()) {
            throw new RuntimeException("password is empty");
        }
        if (args.length > 0) {
            outputFile = args[0];
        }
        CookieStore cookieStore = new BasicCookieStore();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
        client = HttpClientBuilder
                .create()
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy(3, TimeValue.ofSeconds(3)))
                .build();
        login();
    }

    private void updateQuestionsInfo() throws IOException, InterruptedException {
        List<Map<String, Object>> questions = queryQuestions();
        log.info("{} questions found", questions.size());
        List<Question> tarQuestions = new ArrayList<>();
        for (Map<String, Object> question : questions) {
            tarQuestions.add(new Question(question));
        }
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(getOutputFile());
        if (file.exists()) {
            file.delete();
        }
        mapper.writeValue(new File(getOutputFile()), tarQuestions);
    }

    private String getOutputFile() {
        if (outputFile == null || outputFile.isEmpty()) {
            return "all.json";
        }
        return outputFile;
    }

    private List<Map<String, Object>> queryQuestions() throws IOException, InterruptedException {
        List<Map<String, Object>> questionList = new ArrayList<>();

        int skip = 0;
        Boolean hasMore = true;

        while (hasMore) {
            ClassicHttpRequest request = ClassicRequestBuilder
                    .post("https://leetcode.cn/graphql/")
                    .addHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
                    .setEntity(HttpEntities.create(getQueryTemplate().replace("${{skip}}", String.valueOf(skip))))
                    .build();

            String resJson = client.execute(request, httpContext, response -> {
                final int status = response.getCode();
                if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                    final HttpEntity entity = response.getEntity();
                    try {
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } catch (final ParseException ex) {
                        throw new ClientProtocolException(ex);
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            });

            log.info("fetching questions, from: {}, to: {}", skip + 1, skip + 100);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> dataMap = objectMapper.readValue(resJson, Map.class);
            Map<String, Object> data = (Map<String, Object>) dataMap.get("data");
            Map<String, Object> problemsetQuestionList = (Map<String, Object>) data.get("problemsetQuestionList");
            hasMore = (Boolean) problemsetQuestionList.get("hasMore");
            List<Map<String, Object>> questions = (List<Map<String, Object>>) problemsetQuestionList.get("questions");
            questionList.addAll(questions);
            log.info("{} AC questions fetched", questions.stream().filter(q -> Objects.equals(q.get("status"), "AC")).count());
            skip += 100;
            Thread.sleep(10000);
        }

        return questionList;
    }

    private String queryTemplate;

    private String getQueryTemplate() throws IOException {
        if (queryTemplate == null || queryTemplate.isEmpty()) {
            ClassPathResource resource = new ClassPathResource("query-template.txt");
            InputStream inputStream = resource.getInputStream();
            queryTemplate = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        }
        return queryTemplate;
    }

    private void login() throws IOException {
        ClassicHttpRequest httpPost = ClassicRequestBuilder
                .post("https://leetcode.cn/accounts/login/")
                .addHeader("Referer", "https://leetcode.cn/accounts/login/")
                .addHeader("x-requested-with", "XMLHttpRequest")
                .build();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("csrfmiddlewaretoken", ""));
        params.add(new BasicNameValuePair("login", config.getAccount()));
        params.add(new BasicNameValuePair("password", config.getPassword()));
        params.add(new BasicNameValuePair("next", "/problems"));
        httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));


        CloseableHttpResponse response = (CloseableHttpResponse) client.execute(httpPost, httpContext);
        StringBuilder sb = new StringBuilder();
        new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().forEach(line -> sb.append(line).append("\n"));
        String loginResBody = sb.toString();
        if (loginResBody.contains("\"errors\": []")) {
            log.info("login success");
        }

        ClassicHttpRequest verify = ClassicRequestBuilder
                .get("https://leetcode.cn/points/api/")
                .build();
        HttpResponse verifyRes = client.execute(verify, httpContext);
        if (verifyRes.getCode() != 200) {
            throw new RuntimeException("verify login failed");
        }
        log.info("verify login response: {}", verifyRes.getCode());
    }
}
