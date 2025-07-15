package com.study._28_OOP3.layer.abstraction;

public interface QuestionRepository {
    void save(Question question);
    Question[] findAll();
}
