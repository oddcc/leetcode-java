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
        Question tarQuestion = new Question();
        tarQuestion.setFrontendQuestionId((String) question.get("frontendQuestionId"));
        tarQuestion.setLevel((String) question.get("difficulty"));
        tarQuestion.setStatus((String) question.get("status"));
        tarQuestion.setTitle((String) question.get("title"));
        tarQuestion.setTitleSlug((String) question.get("titleSlug"));
    }
}
