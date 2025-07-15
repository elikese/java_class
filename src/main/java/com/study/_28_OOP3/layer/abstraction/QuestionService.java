package com.study._28_OOP3.layer.abstraction;

import java.util.Scanner;

public interface QuestionService {
    void registerQuestion(Scanner scanner);
    Question[] getAllQuestions();
}
