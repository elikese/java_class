package com.study._41_StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        /*
         * [필기] Stream API 기초 개념
         *
         * Stream이란?
         * - 자바 8부터 도입된 데이터 처리 도구
         * - 컬렉션, 배열 등의 데이터를 함수형으로 처리
         * - "데이터가 물 흐르듯 흘러간다"는 개념
         *
         * 핵심 특징:
         * 1. 원본 데이터를 변경하지 않음 (불변성)
         * 2. 일회성 (한 번 사용하면 재사용 불가)
         * 3. 지연 연산 (필요할 때만 실행)
         * 4. 파이프라인 구조 (연속적인 연산 체이닝)
         */

        System.out.println("=== Stream API 기초 학습 ===");

        /*
         * [필기] 지연 연산 (Lazy Evaluation) - 핵심 개념
         *
         * 전통적인 방식 vs Stream 방식:
         * - 전통적: 각 단계마다 전체 데이터를 처리
         *   filter 전체 → map 전체 → collect
         *
         * - Stream: 최종 연산이 호출될 때까지 실행을 미룸
         *   각 요소별로 filter → map → collect 파이프라인 통과
         *
         * 장점:
         * 1. 메모리 효율성: 필요한 만큼만 처리
         * 2. 성능 최적화: 불필요한 연산 생략
         * 3. 무한 스트림 처리 가능
         *
         * numbers라는 리스트는 이미 메모리에 있습니다. 그러나 스트림은 전체 리스트를 다시 별도의 메모리에 복사하지 않습니다.
         * 하나씩만 데이터를 꺼내서 filter와 map을 적용합니다.
         * 즉, 필요한 데이터가 나오는 순간 그 즉시 처리를 멈추고, 이후 데이터는 아예 검사도 안 합니다.
         * → 첫 번째 조건 만족하는 요소 1개만 찾으면 나머지는 처리하지 않음!
         */

        System.out.println("--- 지연 연산 개념 확인 ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("원본 데이터: " + numbers);
        System.out.println("Stream은 최종 연산이 호출될 때까지 실행되지 않습니다!");

        // 지연 연산 확인 예제
        System.out.println("\n지연 연산 확인:");
        System.out.println("1. 중간 연산만 정의 (실행되지 않음)");
        numbers.stream()
                .filter(n -> {
                    System.out.println("filter 실행: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("map 실행: " + n);
                    return n * 10;
                });
        System.out.println("→ 아무것도 출력되지 않음! (최종 연산이 없어서)");

        System.out.println("\n2. 최종 연산 추가 (이제 실행됨)");
        numbers.stream()
                .filter(n -> {
                    System.out.println("filter 실행: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("map 실행: " + n);
                    return n * 10;
                })
                .findFirst(); // 최종 연산
        System.out.println("→ 첫 번째 조건 만족(2)까지만 실행됨!");

        System.out.println("\n=== 스트림 생성 방법들 ===");

        /*
         * [필기] 스트림 생성의 주요 방법들
         *
         * 1. 컬렉션.stream() - List, Set 등에서 생성
         * 2. Arrays.stream(배열) - 배열에서 생성
         * 3. Stream.of(값들) - 직접 값들로 생성
         * 4. Stream.empty() - 빈 스트림 생성
         */

        // 1. 컬렉션에서 생성
        System.out.println("--- 1. 컬렉션에서 스트림 생성 ---");
        List<String> names = Arrays.asList("김자바", "이파이썬", "박스프링");
        names.stream()
                .forEach(name -> System.out.println("컬렉션 스트림: " + name));

        // 2. 배열에서 생성
        System.out.println("\n--- 2. 배열에서 스트림 생성 ---");
        Integer[] numberArray = {1, 2, 3, 4, 5};
        Arrays.stream(numberArray)
                .forEach(num -> System.out.println("배열 스트림: " + num));

        // 3. Stream.of()로 직접 생성
        System.out.println("\n--- 3. Stream.of()로 직접 생성 ---");
        Stream.of("사과", "바나나", "오렌지")
                .forEach(fruit -> System.out.println("직접 생성 스트림: " + fruit));
    }
}
