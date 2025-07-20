package com.study._39_Collections.list;

import java.util.ArrayList;

public class ArrayListMain {
    /*
     * [필기] ArrayList - 자바의 동적 배열
     *
     * 1. ArrayList vs 배열 차이점
     *    - 배열: 크기 고정, int[] arr = new int[5];
     *    - ArrayList: 크기 동적, ArrayList<Integer> list = new ArrayList<>();
     *
     * 2. ArrayList 내부 구조
     *    - 내부적으로 배열(Object[])을 사용
     *    - 기본 용량: 10
     *    - 용량 초과시: 기존 크기의 1.5배로 확장 (10→15→22→33...)
     *    - System.arraycopy()로 기존 데이터를 새 배열에 복사
     *
     * 3. 주요 메서드
     *    - add(): 추가
     *    - get(): 조회
     *    - set(): 수정
     *    - remove(): 제거
     *    - size(): 크기
     *    - contains(): 포함 여부
     */
    public static void main(String[] args) {
        System.out.println("=== ArrayList vs 배열 비교 ===");

        // 1. 배열 - 크기 고정
        String[] arrayFruits = new String[3];  // 크기 3으로 고정
        arrayFruits[0] = "사과";
        arrayFruits[1] = "바나나";
        arrayFruits[2] = "오렌지";
        // arrayFruits[3] = "포도";  // 에러! 크기 초과 불가능

        System.out.println("배열 길이: " + arrayFruits.length);

        // 2. ArrayList - 크기 동적
        ArrayList<String> listFruits = new ArrayList<>();  // 크기 제한 없음
        listFruits.add("사과");
        listFruits.add("바나나");
        listFruits.add("오렌지");
        listFruits.add("포도");    // 자동 확장!
        listFruits.add("딸기");    // 계속 추가 가능

        System.out.println("ArrayList 크기: " + listFruits.size());
        System.out.println("ArrayList 내용: " + listFruits);

        System.out.println();
        System.out.println("=== ArrayList 주요 메서드 ===");

        ArrayList<String> fruits = new ArrayList<>();

        // add() - 추가
        fruits.add("사과");           // 끝에 추가
        fruits.add("바나나");
        fruits.add(1, "포도");       // 인덱스 1에 삽입
        System.out.println("add 후: " + fruits);

        // get() - 조회 (인덱스 접근)
        System.out.println("인덱스 0: " + fruits.get(0));
        System.out.println("인덱스 2: " + fruits.get(2));

        // set() - 수정
        fruits.set(1, "키위");       // 인덱스 1을 키위로 변경
        System.out.println("set 후: " + fruits);

        // contains() - 포함 여부
        System.out.println("사과 포함? " + fruits.contains("사과"));
        System.out.println("망고 포함? " + fruits.contains("망고"));

        // remove() - 제거
        fruits.remove(0);            // 인덱스 0 제거
        fruits.remove("바나나");     // 값으로 제거
        System.out.println("remove 후: " + fruits);

        // size() - 크기
        System.out.println("크기: " + fruits.size());

    }

}
