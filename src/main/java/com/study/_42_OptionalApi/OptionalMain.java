package com.study._42_OptionalApi;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        /*
         * [필기] Optional API 종합 학습
         *
         * 1. Optional이란?
         *    - "값이 존재할 수도 있고 존재하지 않을 수도 있는" 값을 감싸는 컨테이너 클래스
         *    - null로 인한 NullPointerException을 사전에 예방
         *    - 값이 없을 수도 있음을 명시적으로 표현하여 코드 안전성 향상
         *
         * 2. Optional 등장 배경
         *    - null 체크 로직의 복잡성과 가독성 저하 문제 해결
         *    - 메서드 반환값이 비어있을 수 있음을 타입 시스템으로 표현
         *    - 런타임 예외를 컴파일 타임에 방지할 수 있는 방법 제공
         *
         * 3. Optional 생성 방법
         *    - Optional.of(value): 값이 확실히 null이 아닐 때 사용
         *    - Optional.ofNullable(value): 값이 null일 수도 있을 때 사용
         *    - Optional.empty(): 명시적으로 빈 Optional 생성
         *
         * 4. Optional 값 처리 메서드들
         *    - 값 확인: isPresent(), isEmpty()
         *    - 값 추출: get(), orElse(), orElseGet(), orElseThrow()
         *    - 조건부 실행: ifPresent(), ifPresentOrElse()
         *    - 변환: map(), flatMap()
         *    - 필터링: filter()
         */

        System.out.println("=== 1. Optional 생성 방법 ===");

        // 1. Optional.of() - 값이 확실히 null이 아닐 때
        String nonNullValue = "Hello Optional!";
        Optional<String> opt1 = Optional.of(nonNullValue);
        System.out.println("Optional.of() 결과: " + opt1);

        // 2. Optional.ofNullable() - 값이 null일 수도 있을 때
        Optional<String> opt2 = Optional.ofNullable("Hello!");
        Optional<String> opt3 = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable(값) 결과: " + opt2);
        System.out.println("Optional.ofNullable(null) 결과: " + opt3);

        // 3. Optional.empty() - 명시적으로 빈 Optional 생성
        Optional<String> opt4 = Optional.empty();
        System.out.println("Optional.empty() 결과: " + opt4);

        /*
         * [주의사항]
         * - Optional.of(null)을 호출하면 NullPointerException 발생
         * - 값이 null일 가능성이 있다면 반드시 ofNullable() 사용
         */

        System.out.println("\n=== 2. Optional 값 확인과 추출 ===");

        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // 값 존재 여부 확인
        System.out.println("optValue.isPresent(): " + optValue.isPresent());
        System.out.println("optEmpty.isPresent(): " + optEmpty.isPresent());
        System.out.println("optEmpty.isEmpty(): " + optEmpty.isEmpty()); // Java 11+

        // orElse() - 값이 없으면 기본값 반환 (즉시 평가)
        String result1 = optValue.orElse("기본값");
        String result2 = optEmpty.orElse("기본값");
        System.out.println("optValue.orElse(): " + result1);
        System.out.println("optEmpty.orElse(): " + result2);

        // orElseGet() - 값이 없으면 Supplier 실행 (지연 평가)
        String result3 = optValue.orElseGet(() -> "지연 평가 기본값");
        String result4 = optEmpty.orElseGet(() -> "지연 평가 기본값");
        System.out.println("optValue.orElseGet(): " + result3);
        System.out.println("optEmpty.orElseGet(): " + result4);

        // orElseThrow() - 값이 없으면 예외 발생
        try {
            String result5 = optEmpty.orElseThrow(() -> new RuntimeException("값이 없습니다!"));
        } catch (RuntimeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        /*
         * [중요] get() 메서드는 피해야 할 메서드
         * - 값이 없을 때 NoSuchElementException 발생
         * - 안전한 대안: orElse(), orElseGet(), orElseThrow() 사용 권장
         */

        System.out.println("\n=== 4. Optional 체이닝 활용 ===");

        // ifPresent() - 값이 있을 때만 실행
        optValue.ifPresent(value -> System.out.println("값이 존재: " + value));
        optEmpty.ifPresent(value -> System.out.println("이 메시지는 출력되지 않음"));

        // ifPresentOrElse() - 값이 있을 때와 없을 때 각각 다른 동작 실행
        optValue.ifPresentOrElse(
                value -> System.out.println("값 처리: " + value),
                () -> System.out.println("값이 없음")
        );

        optEmpty.ifPresentOrElse(
                value -> System.out.println("값 처리: " + value),
                () -> System.out.println("값이 없음")
        );

        // map() - 값이 있으면 변환, 없으면 empty 반환
        Optional<String> mapped1 = optValue.map(s -> s.toUpperCase());
        Optional<String> mapped2 = optEmpty.map(s -> s.toUpperCase());
        System.out.println("optValue.map(toUpperCase): " + mapped1);
        System.out.println("optEmpty.map(toUpperCase): " + mapped2);

        // filter() - 조건에 맞는 값만 유지
        Optional<String> filtered1 = optValue.filter(s -> s.length() > 3);
        Optional<String> filtered2 = optValue.filter(s -> s.length() > 10);
        System.out.println("optValue.filter(길이>3): " + filtered1);
        System.out.println("optValue.filter(길이>10): " + filtered2);

        // 체이닝을 통한 복합 처리
        String chainResult = optValue
                .filter(s -> s.startsWith("H"))
                .map(String::toUpperCase)
                .orElse("조건에 맞지 않음");
        System.out.println("체이닝 결과: " + chainResult);

    }
}
