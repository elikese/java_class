package com.study._39_Collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    /*
     * [필기] HashSet - 해시 기반 Set 구현체
     *
     * 1. HashSet이란?
     *    - Set 인터페이스를 해시 테이블로 구현한 클래스
     *    - 중복을 허용하지 않는 데이터 집합
     *    - 순서를 보장하지 않음
     *    - null 값 하나까지 허용
     *
     * 2. 해시(Hash) 동작 원리
     *    - 해시 함수: 객체 → 해시 코드(정수) 변환
     *    - 해시 인덱스: 해시 코드 % 배열 크기 = 저장 위치
     *    - 해시 충돌: 서로 다른 객체가 같은 인덱스를 가지는 현상
     *    - 충돌 해결: 체이닝(연결 리스트) 방식 사용
     *
     * 3. HashSet의 성능 (평균)
     *    - 추가(add): O(1)
     *    - 검색(contains): O(1)
     *    - 삭제(remove): O(1)
     *    - 최악의 경우(모든 해시가 충돌): O(n)
     *
     * 4. hashCode()와 equals()
     *    - 두 메서드가 모두 올바르게 구현되어야 함
     *    - hashCode()가 같으면 equals() 비교 수행
     *    - equals()가 true면 같은 객체로 판단하여 중복 제거
     *
     * 5. 사용 시기
     *    - 중복 제거가 필요할 때
     *    - 빠른 검색이 필요할 때
     *    - 순서가 중요하지 않을 때
     */

    public static void main(String[] args) {
        System.out.println("=== HashSet 기본 사용법 ===");

        // Set 인터페이스로 선언 - 다형성 활용 (업캐스팅)
        Set<String> set = new HashSet<>();

        System.out.println("--- 1단계: 기본 추가와 중복 제거 ---");

        // 데이터 추가 - 중복 제거 기능을 보여줌
        set.add("apple");
        set.add("banana");
        set.add("apple");     // 중복 - 추가되지 않음
        set.add("cherry");
        set.add("apple");     // 또 중복 - 추가되지 않음

        System.out.println("Set 내용: " + set); // 중복이 제거되어 출력
        System.out.println("크기: " + set.size()); // 3개만 저장됨

        System.out.println();
        System.out.println("--- 2단계: 검색과 제거 ---");

        // contains() - O(1) 빠른 검색을 보여줌
        System.out.println("apple 포함? " + set.contains("apple"));
        System.out.println("grape 포함? " + set.contains("grape"));

        // remove() - O(1) 빠른 제거를 보여줌
        boolean removed = set.remove("banana");
        System.out.println("banana 제거 성공? " + removed);
        System.out.println("제거 후: " + set);

        System.out.println();
        System.out.println("--- 3단계: 순서 보장 안됨 확인 ---");

        // 입력 순서와 출력 순서가 다를 수 있음을 보여줌
        Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        System.out.println("입력 순서: 3, 1, 4, 2, 5");
        System.out.println("저장 순서: " + numbers); // 순서가 다를 수 있음

        System.out.println();
        System.out.println("--- 4단계: Set 연산 활용 ---");

        // 두 집합을 만들어서 집합 연산을 보여줌
        Set<String> fruits1 = new HashSet<>();
        fruits1.add("apple");
        fruits1.add("banana");
        fruits1.add("cherry");

        Set<String> fruits2 = new HashSet<>();
        fruits2.add("banana");
        fruits2.add("cherry");
        fruits2.add("grape");

        // 합집합 (Union) - addAll 사용
        Set<String> union = new HashSet<>(fruits1);
        union.addAll(fruits2); // fruits2의 모든 요소 추가
        System.out.println("fruits1: " + fruits1);
        System.out.println("fruits2: " + fruits2);
        System.out.println("합집합: " + union);

        // 교집합 (Intersection) - retainAll 사용
        Set<String> intersection = new HashSet<>(fruits1);
        intersection.retainAll(fruits2); // 공통 요소만 남김
        System.out.println("교집합: " + intersection);

        // 차집합 (Difference) - removeAll 사용
        Set<String> difference = new HashSet<>(fruits1);
        difference.removeAll(fruits2); // fruits2에 있는 요소 제거
        System.out.println("차집합: " + difference);

        System.out.println();
        System.out.println("--- 5단계: 실용 예제 - 중복 단어 제거 ---");

        // 문장에서 중복 단어 제거하는 예제
        String text = "java is good java is powerful java is fun";
        String[] words = text.split(" "); // 공백으로 단어 분리

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word); // 중복은 자동으로 제거됨
        }

        System.out.println("원본 문장: " + text);
        System.out.println("전체 단어 수: " + words.length);
        System.out.println("고유 단어: " + uniqueWords);
        System.out.println("고유 단어 수: " + uniqueWords.size());
    }
}
