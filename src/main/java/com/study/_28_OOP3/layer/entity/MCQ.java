package com.study._28_OOP3.layer.entity;

import com.study._28_OOP3.layer.abstraction.Question;

public class MCQ implements Question {

    private String content;
    private String[] choices;
    private int correctIndex;

    public MCQ(String content, String[] choices, int correctIndex) {
        this.content = content;
        this.choices = choices;
        this.correctIndex = correctIndex;
    }

    @Override
    public String getContent() {
        return null;
    }
}
