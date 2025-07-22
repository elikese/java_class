package com.study._39_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMain {
    public static void main(String[] args) {
        /*
         * [필기] Collections 유틸리티 클래스
         *
         * 1. Collections란?
         *    - 컬렉션을 위한 유틸리티 메서드를 제공하는 클래스
         *    - 모든 메서드가 static 메서드 (인스턴스 생성 불필요)
         *    - Arrays 클래스와 비슷한 역할 (배열 vs 컬렉션)
         *
         * 2. 사용 시 주의사항
         *    - 대부분 List를 대상으로 함 (순서가 있는 컬렉션)
         *    - 원본 컬렉션을 직접 수정함 (immutable 아님)
         *    - null 값 처리에 주의
         */

        // 정렬 테스트용 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        System.out.println("원본 리스트: " + numbers);

        // sort() - 오름차순 정렬
        Collections.sort(numbers);
        System.out.println("정렬 후: " + numbers);

        // reverse() - 순서 뒤집기 (내림차순 효과)
        Collections.reverse(numbers);
        System.out.println("뒤집기 후: " + numbers);

        // shuffle() - 랜덤 섞기
        Collections.shuffle(numbers);
        System.out.println("섞기 후: " + numbers); // 실행할 때마다 다름

        System.out.println();
        System.out.println("--- 2단계: 검색 관련 메서드 ---");

        // 검색을 위해 다시 정렬
        Collections.sort(numbers);
        System.out.println("정렬된 리스트: " + numbers);

        // max(), min() - 최대값, 최소값 찾기
        Integer max = Collections.max(numbers);
        Integer min = Collections.min(numbers);
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);

        System.out.println("--- 3단계: 컬렉션 조작 메서드 ---");

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");

        // addAll() - 여러 요소를 한 번에 추가
        Collections.addAll(fruits, "cherry", "date", "elderberry");
        System.out.println("addAll 후: " + fruits);

        // frequency() - 특정 요소의 등장 횟수
        fruits.add("apple"); // 중복 추가
        int appleCount = Collections.frequency(fruits, "apple");
        System.out.println("apple 등장 횟수: " + appleCount);
    }
}
