package com.oddcc.leetcode.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class Question {
    private String title;
    private String titleSlug;
    private String status;
    private String frontendQuestionId;
    private String level;

    public Question(Map<String, Object> question) {
        setFrontendQuestionId((String) question.get("frontendQuestionId"));
        setLevel((String) question.get("difficulty"));
        setStatus((String) question.get("status"));
        setTitle((String) question.get("title"));
        setTitleSlug((String) question.get("titleSlug"));
    }
}
