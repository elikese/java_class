package com.study._40_Lambda;

public class Person {
    private String name;

    // 기본 생성자
    public Person() {
        this.name = "홍길동";
    }

    // 이름을 받는 생성자
    public Person(String name) {
        this.name = name;
    }

    // 정적 메서드 (greeting)
    public static String greeting() {
        return "안녕하세요!";
    }

    // 인스턴스 메서드
    public String getName() {
        return name;
    }

    // 출력용 toString() 오버라이드
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
