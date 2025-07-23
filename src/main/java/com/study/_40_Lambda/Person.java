package com.study._40_Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    private int age;

    // 정적 메서드 (greeting)
    public static String greeting() {
        return "안녕하세요!";
    }

}
