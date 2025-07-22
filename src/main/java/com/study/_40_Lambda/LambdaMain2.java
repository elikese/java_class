package com.study._40_Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaMain2 {
    public static void main(String[] args) {
        /*
         * 표준 함수형 인터페이스
         *
         * 문제:
         * - 매번 Calculator 같은 커스텀 인터페이스를 만들기 번거로움
         * - 비슷한 역할의 인터페이스들이 중복으로 만들어짐
         *
         * 해결책:
         * - 자바 8부터 자주 쓰이는 패턴들을 인터페이스로 미리 제공
         * - 개발자는 바로 가져다 쓰면 됨
         *
         * 4대 핵심 인터페이스 (기억하세요!):
         * 1. Function<T, R>  : T를 받아서 R을 반환 (변환기)
         * 2. Consumer<T>     : T를 받아서 소비 (출력, 저장 등)
         * 3. Supplier<T>     : 매개변수 없이 T를 생성 (공급자)
         * 4. Predicate<T>    : T를 받아서 boolean 반환 (조건 검사)
         */

        /*
         * Function<T, R>의 시그니처: R apply(T t)
         * - 입력: T 타입 1개
         * - 출력: R 타입 1개
         * - 용도: 데이터 변환, 매핑, 계산 등
         */

        Function<String, Integer> stringLength = str -> str.length();
        Function<Integer, String> intToString = num -> "숫자: " + num;
        Function<String, String> toUpperCase = str -> str.toUpperCase();

        System.out.println("문자열 길이: " + stringLength.apply("Hello Lambda"));
        System.out.println("숫자를 문자열로: " + intToString.apply(42));
        System.out.println("대문자 변환: " + toUpperCase.apply("lambda"));

        // Function 체이닝 - andThen으로 연결 가능
        Function<String, String> stringProcessor = toUpperCase.andThen(s -> s + "!");
        System.out.println("체이닝 결과: " + stringProcessor.apply("lambda"));


        /*
         * Consumer<T>의 시그니처: void accept(T t)
         * - 입력: T 타입 1개
         * - 출력: 없음 (void)
         * - 용도: 출력, 저장, 전송 등 "소비" 작업
         */

        Consumer<String> printer = msg -> System.out.println("[출력] " + msg);
        Consumer<Integer> numberProcessor = num -> {
            System.out.println("처리 중인 숫자: " + num);
            System.out.println("제곱값: " + (num * num));
        };

        printer.accept("Hello Consumer!");
        numberProcessor.accept(7);

        /*
         * Supplier<T>의 시그니처: T get()
         * - 입력: 없음
         * - 출력: T 타입 1개
         * - 용도: 객체 생성, 값 생성
         */

        Supplier<String> anyWord = () -> "아무말";
        Supplier<Integer> anyNum = () -> 10;
        Supplier<Person> anyPerson = () -> new Person("김자바");


        System.out.println(anyWord.get());
        System.out.println(anyNum.get());
        System.out.println(anyPerson.get());


        /*
         * Predicate<T>의 시그니처: boolean test(T t)
         * - 입력: T 타입 1개
         * - 출력: boolean
         * - 용도: 조건 검사, 필터링, 유효성 검증 등
         */
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<String> isLongString = str -> str.length() > 5;

        System.out.println("8은 짝수? " + isEven.test(8));
        System.out.println("7은 짝수? " + isEven.test(7));
        System.out.println("Lambda는 5이상? " + isLongString.test("Lambda"));

    }
}
