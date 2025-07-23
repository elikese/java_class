package com.study._41_StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 문자열 Stream 처리 예제 ===");

        List<String> customerNames = Arrays.asList(
                "김자바", "이파이썬", "박자바스크립트", "최스프링", "김리액트",
                "정코틀린", "한스위프트", "김자바", "이노드", "홍길동"
        );

        System.out.println("원본 직원 목록: " + customerNames);

        // Stream을 활용한 문자열 처리
        /*
         * 요구사항: 김씨 직원들의 이름을 대문자로 변환하고 중복 제거해서
         * "님"을 붙여서 인사말 출력하기
         */

        System.out.println("--- 김씨 직원들에게 인사하기 ---");
        customerNames.stream()
                .filter(name -> name.startsWith("김"))     // Predicate<String>
                .map(String::toUpperCase)                  // Function<String,String>
                .distinct()                                // 중복 제거
                .map(name -> name + "님")                  // Function<String,String>
                .forEach(greeting -> System.out.println("안녕하세요, " + greeting)); // Consumer<String>


        List<Integer> scores = Arrays.asList(95, 87, 76, 92, 88, 79, 85, 91, 83, 77);

        /*
         * 요구사항: 점수 중에서 80점 이상인 점수들만 골라서
         * 상위 3개만 출력
         */

        System.out.println("--- 고득점자 보너스 점수 (상위 3명) ---");
        scores.stream()
                .filter(score -> score >= 80)              // Predicate<Integer>
                .sorted(Comparator.reverseOrder())      // Comparator (내림차순)
                .limit(3)                                  // 상위 3개
                .forEach(score -> {
                    System.out.println(score);
                });


    }
}
