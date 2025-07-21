package com.study._39_Collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain1 {
    /*
     * [필기] List 인터페이스 - 다형성과 추상화
     *
     * 1. List 인터페이스란?
     *    - ArrayList, LinkedList의 공통 기능을 정의한 인터페이스
     *    - 순서가 있고 중복을 허용하는 컬렉션의 표준 규약
     *    - Collection 인터페이스를 상속받음
     *
     * 2. 다형성 활용 이유
     *    - 구현체를 바꿔도 코드 변경 최소화
     *    - 메서드 매개변수로 List 타입 사용 가능
     *    - 런타임에 구현체 결정 가능
     *
     * 3. List 인터페이스 주요 메서드
     *    - add(): 요소 추가
     *    - get(): 인덱스로 조회
     *    - set(): 인덱스 위치 수정
     *    - remove(): 요소 제거
     *    - size(): 크기 반환
     *    - contains(): 포함 여부 확인
     */

    /**
     * [필기] 다형성 활용 - List 타입으로 모든 구현체 처리
     * 이 메서드가 ArrayList, LinkedList 구분 없이 동작함을 보여주는 코드
     */
    public static void printListInfo(List<String> list) {
        System.out.println("리스트 타입: " + list.getClass().getSimpleName()); // 실제 구현체 확인
        System.out.println("크기: " + list.size());
        System.out.println("내용: " + list);
    }


    public static void main(String[] args) {
        System.out.println("=== List 인터페이스와 다형성 ===");

        // 다형성 - 인터페이스 타입으로 선언하여 구현체 교체 가능성을 보여줌
        List<String> arrayList = new ArrayList<>();    // ArrayList 구현체
        List<String> linkedList = new LinkedList<>();  // LinkedList 구현체

        // 같은 인터페이스 메서드 사용 - 구현체가 달라도 사용법은 동일함을 보여줌
        arrayList.add("ArrayList 데이터");
        linkedList.add("LinkedList 데이터");

        // 같은 메서드로 서로 다른 구현체 처리 - 다형성의 장점을 보여줌
        printListInfo(arrayList);   // ArrayList 전달
        printListInfo(linkedList);  // LinkedList 전달

        System.out.println();
        System.out.println("--- List 주요 메서드 활용 ---");

        // List 인터페이스의 핵심 메서드들을 보여주는 코드
        List<Integer> numbers = new ArrayList<>();

        // 추가와 조회
        numbers.add(10);                    // 끝에 추가
        numbers.add(20);
        numbers.add(1, 15);                 // 인덱스 1에 삽입
        System.out.println("추가 후: " + numbers);
        System.out.println("인덱스 1: " + numbers.get(1));        // 인덱스로 조회
        System.out.println("20의 위치: " + numbers.indexOf(20));   // 값으로 인덱스 찾기

        // 수정과 제거
        numbers.set(0, 100);                // 인덱스 0을 100으로 변경
        numbers.remove(Integer.valueOf(20)); // 값 20 제거
        System.out.println("수정/제거 후: " + numbers);

        System.out.println();
        System.out.println("--- 정리 ---");
        System.out.println("List 인터페이스 사용의 장점:");
        System.out.println("1. 구현체 교체 용이성 - ArrayList ↔ LinkedList");
        System.out.println("2. 코드의 유연성 - 하나의 메서드로 모든 List 처리");
        System.out.println("3. 다형성 활용 - 인터페이스에 의존하므로 변경에 강함");
    }
}
