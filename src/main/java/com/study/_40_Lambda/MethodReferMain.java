package com.study._40_Lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferMain {
    public static void main(String[] args) {
        /*
         * 메서드 참조(Method Reference)의 탄생 배경
         *
         * 람다도 충분히 간결하지만, 한 가지 아쉬운 점:
         * - 기존에 만들어진 메서드를 단순히 호출하기만 하는 람다들
         * - 예: str -> str.length()
         *
         * 해결책: 메서드 참조 (::)
         * - 람다가 단순히 메서드 호출만 할 때 더 간결하게 표현
         * - "이미 있는 메서드를 그대로 써라"는 의미
         *
         */

        System.out.println("=== 메서드 참조: 람다의 최종 진화 ===");

        // 유형 1: 정적 메서드 참조 - 가장 직관적
        System.out.println("--- 1. 정적 메서드 참조 ---");

        /*
         * 정적 메서드 참조 패턴:
         * 클래스명::정적메서드명
         *
         * 람다와 비교:
         * str -> Integer.parseInt(str)  →  Integer::parseInt
         */

        // 람다 방식
        Function<String, Integer> parseIntLambda = str -> Integer.parseInt(str);
        Supplier<String> greetingLambda = () -> Person.greeting();

        // 메서드 참조 방식 - 훨씬 간결!
        Function<String, Integer> parseIntMethodRef = Integer::parseInt;
        Supplier<String> greetingMethodRef = Person::greeting;

        System.out.println("람다 파싱: " + parseIntLambda.apply("100"));
        System.out.println("메서드참조 파싱: " + parseIntMethodRef.apply("100"));
        System.out.println("람다 인사: " + greetingLambda.get());
        System.out.println("메서드참조 인사: " + greetingMethodRef.get());

        // 유형 2: 임의 객체의 인스턴스 메서드 참조
        System.out.println("\n--- 4. 임의 객체의 인스턴스 메서드 참조 (중요!) ---");

        /*
         * [필기] 임의 객체의 인스턴스 메서드 참조 완전 분석
         *
         * 패턴: 클래스명::인스턴스메서드명
         * 핵심: 첫 번째 매개변수가 메서드를 호출할 객체가 됨!
         *
         * 원리:
         * Person::getName  →  (Person p) -> p.getName()
         */

        // 람다 방식: 첫 번째 매개변수가 메서드 호출 객체
        Function<String, Integer> stringLengthLambda = str -> str.length();
        Function<String, String> toUpperLambda = str -> str.toUpperCase();

        // 메서드 참조 방식: 클래스명::인스턴스메서드명
        Function<String, Integer> stringLengthMethodRef = String::length;
        Function<String, String> toUpperMethodRef = String::toUpperCase;

        System.out.println("람다로 문자열 길이: " + stringLengthLambda.apply("Lambda"));
        System.out.println("메서드참조로 문자열 길이: " + stringLengthMethodRef.apply("Lambda"));
        System.out.println("람다로 대문자: " + toUpperLambda.apply("method reference"));
        System.out.println("메서드참조로 대문자: " + toUpperMethodRef.apply("method reference"));

        // Person 클래스의 메서드들로 더 복잡한 예시
        Person[] people = {
                new Person("김자바", 20),
                new Person("이파이썬", 20),
                new Person("박자바스크립트", 20)
        };

        // 람다 방식
        Function<Person, String> getPersonNameLambda = person -> person.getName();

        // 메서드 참조 방식
        Function<Person, String> getPersonNameMethodRef = Person::getName;

        System.out.println("\n사람들의 이름 추출:");
        for (Person p : people) {
            System.out.println("람다: " + getPersonNameLambda.apply(p));
            System.out.println("메서드참조: " + getPersonNameMethodRef.apply(p));
        }
    }
}
