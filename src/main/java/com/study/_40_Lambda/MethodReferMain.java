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
         * - 예: str -> str.length(), Math::max 등
         *
         * 해결책: 메서드 참조 (::)
         * - 람다가 단순히 메서드 호출만 할 때 더 간결하게 표현
         * - "이미 있는 메서드를 그대로 써라"는 의미
         *
         * 4가지 유형 (반드시 기억!):
         * 1. 정적 메서드 참조: 클래스명::정적메서드명
         * 2. 특정 객체의 인스턴스 메서드 참조: 객체명::메서드명
         * 3. 생성자 참조: 클래스명::new
         * 4. 임의 객체의 인스턴스 메서드 참조: 클래스명::인스턴스메서드명
         */

        System.out.println("=== 메서드 참조: 람다의 최종 진화 ===");

        // 유형 1: 정적 메서드 참조 - 가장 직관적
        System.out.println("--- 1. 정적 메서드 참조 ---");

        /*
         * 정적 메서드 참조 패턴:
         * 클래스명::정적메서드명
         *
         * 람다와 비교:
         * (a, b) -> Math.max(a, b)  →  Math::max
         * str -> Integer.parseInt(str)  →  Integer::parseInt
         */

        // 람다 방식
        Function<String, Integer> parseIntLambda = str -> Integer.parseInt(str);
        Supplier<String> greetingLambda = () -> Person.greeting();

        // 메서드 참조 방식 - 훨씬 간결!
        Function<String, Integer> parseIntMethodRef = Integer::parseInt;
        Supplier<String> greetingMethodRef = Person::greeting;

        System.out.println("람다 파싱: " + parseIntLambda.apply("42"));
        System.out.println("메서드참조 파싱: " + parseIntMethodRef.apply("42"));
        System.out.println("람다 인사: " + greetingLambda.get());
        System.out.println("메서드참조 인사: " + greetingMethodRef.get());

        // 유형 2: 특정 객체의 인스턴스 메서드 참조
        System.out.println("\n--- 2. 특정 객체의 인스턴스 메서드 참조 ---");

        /*
         * 특정 객체 메서드 참조 패턴:
         * 객체명::인스턴스메서드명
         *
         * 특징: 이미 생성된 특정 객체의 메서드를 참조
         * 람다와 비교: () -> person.getName()  →  person::getName
         */

        Person kim = new Person("김자바");
        String message = "Hello Method Reference";

        // 람다 방식
        Supplier<String> getNameLambda = () -> kim.getName();
        Supplier<String> getMessageLengthLambda = () -> String.valueOf(message.length());

        // 메서드 참조 방식
        Supplier<String> getNameMethodRef = kim::getName;
        Function<String, Boolean> containsMethodRef = message::contains;

        System.out.println("람다로 이름 가져오기: " + getNameLambda.get());
        System.out.println("메서드참조로 이름 가져오기: " + getNameMethodRef.get());
        System.out.println("문자열에 'Method' 포함? " + containsMethodRef.apply("Method"));

        // 유형 3: 생성자 참조 - 객체 생성의 간소화
        System.out.println("\n--- 3. 생성자 참조 ---");

        /*
         * 생성자 참조 패턴:
         * 클래스명::new
         *
         * 매개변수에 따라 어떤 생성자가 호출될지 자동 결정
         * 람다와 비교: () -> new Person()  →  Person::new
         */

        // 람다 방식
        Supplier<Person> personCreatorLambda = () -> new Person();
        Function<String, Person> personWithNameLambda = name -> new Person(name);

        // 메서드 참조 방식
        Supplier<Person> personCreatorMethodRef = Person::new;
        Function<String, Person> personWithNameMethodRef = Person::new;

        Person person1 = personCreatorLambda.get();
        Person person2 = personCreatorMethodRef.get();
        Person person3 = personWithNameLambda.apply("이람다");
        Person person4 = personWithNameMethodRef.apply("박메서드");

        System.out.println("람다로 생성: " + person1);
        System.out.println("메서드참조로 생성: " + person2);
        System.out.println("람다로 이름과 함께 생성: " + person3);
        System.out.println("메서드참조로 이름과 함께 생성: " + person4);

        // 유형 4: 임의 객체의 인스턴스 메서드 참조 - 가장 헷갈리는 부분!
        System.out.println("\n--- 4. 임의 객체의 인스턴스 메서드 참조 (중요!) ---");

        /*
         * [필기] 임의 객체의 인스턴스 메서드 참조 완전 분석
         *
         * 패턴: 클래스명::인스턴스메서드명
         * 핵심: 첫 번째 매개변수가 메서드를 호출할 객체가 됨!
         *
         * 혼동 주의:
         * - Person::getName (임의 객체) vs person::getName (특정 객체)
         * - 똑같이 생겼지만 완전히 다른 의미!
         *
         * 원리:
         * Person::getName  →  (Person p) -> p.getName()
         * Person::compareByName  →  (Person p1, Person p2) -> p1.compareByName(p2)
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
                new Person("김자바"),
                new Person("이파이썬"),
                new Person("박자바스크립트")
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

        /*
         * [필기] 메서드 참조 선택 가이드
         *
         * 언제 사용할까?
         * 1. 람다가 단순히 메서드 호출만 할 때
         * 2. 기존에 잘 만들어진 메서드를 재활용할 때
         * 3. 코드를 더 간결하고 읽기 쉽게 만들고 싶을 때
         *
         * 언제 사용하지 말까?
         * 1. 메서드 호출 전후에 추가 로직이 필요할 때
         * 2. 람다가 더 직관적이고 이해하기 쉬울 때
         * 3. 팀원들이 메서드 참조에 익숙하지 않을 때
         *
         * 실무 팁:
         * - 처음에는 람다로 작성하고, 나중에 메서드 참조로 리팩토링
         * - 가독성을 최우선으로 고려
         * - 너무 복잡한 메서드 참조는 피하기
         */
    }
}
