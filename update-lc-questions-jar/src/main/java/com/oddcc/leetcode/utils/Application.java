package com.oddcc.leetcode.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.HttpEntities;
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
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private Config config;

    private String outputFile;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(args.length + " args: " + String.join(",", args));
        prepare(args);
        updateQuestionsInfo();
    }

    private void prepare(String[] args) {
        if (args.length > 0) {
            outputFile = args[0];
        }
    }

    private void updateQuestionsInfo() throws IOException, InterruptedException {
        List<Map<String, Object>> questions = queryQuestions();
        log.info("{} questions found", questions.size());
        List<Question> tarQuestions = new ArrayList<>();
        for (Map<String, Object> question : questions) {
            Question tarQuestion = new Question();
            tarQuestion.setFrontendQuestionId((String) question.get("frontendQuestionId"));
            tarQuestion.setLevel((String) question.get("difficulty"));
            tarQuestion.setStatus((String) question.get("status"));
            tarQuestion.setTitle((String) question.get("title"));
            tarQuestion.setTitleSlug((String) question.get("titleSlug"));
            tarQuestions.add(tarQuestion);
        }
        ObjectMapper mapper = new ObjectMapper();
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
        final HttpClientResponseHandler<String> responseHandler = response -> {
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
        };

        int skip = 0;
        Boolean hasMore = true;

        while (hasMore) {
            String json = Request.post("https://leetcode-cn.com/graphql/")
                    .addHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .addHeader(HttpHeaders.COOKIE, getCookie())
                    .addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
                    .body(HttpEntities.create(getQueryTemplate().replace("${skip}", String.valueOf(skip))))
                    .execute()
                    .handleResponse(responseHandler);

            log.info("fetching questions, skip: {}", skip);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> dataMap = objectMapper.readValue(json, Map.class);
            Map<String, Object> data = (Map<String, Object>) dataMap.get("data");
            Map<String, Object> problemsetQuestionList = (Map<String, Object>) data.get("problemsetQuestionList");
            hasMore = (Boolean) problemsetQuestionList.get("hasMore");
            List<Map<String, Object>> questions = (List<Map<String, Object>>) problemsetQuestionList.get("questions");
            questionList.addAll(questions);
            skip += 100;
            Thread.sleep(3000);
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

    private String cookie;

    // TODO from leetcode account and password get cookie
    private String getCookie() {
        if (cookie == null || cookie.isEmpty()) {
            log.info("Cookie is empty, please set COOKIE environment variable");
            cookie = System.getenv("COOKIE");
        }
        return cookie;
    }
}
