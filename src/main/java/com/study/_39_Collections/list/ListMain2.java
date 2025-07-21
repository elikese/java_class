package com.study._39_Collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain2 {
    /*
     * [필기] List 변환과 호환성
     *
     * 1. List.of() vs new ArrayList()
     *    - List.of(): 불변 리스트 생성 (수정 불가)
     *    - new ArrayList(): 가변 리스트 생성 (수정 가능)
     *
     * 2. 배열과 List 변환
     *    - 배열 → List: List.of(array), Arrays.asList(array)
     *    - List → 배열: list.toArray(new Type[0])
     *
     * 3. 불변 ↔ 가변 변환
     *    - 불변 → 가변: new ArrayList<>(immutableList)
     *    - 가변 → 불변: List.copyOf(mutableList)
     */

    public static void main(String[] args) {
        System.out.println("=== List 변환과 호환성 ===");

        System.out.println("--- 1단계: 배열과 List 변환 ---");

        // 배열을 List로 변환 - List.of()는 불변 리스트 생성
        String[] array = {"A", "B", "C"};
        List<String> immutableList = List.of(array); // 불변 리스트
        System.out.println("불변 리스트: " + immutableList);
        System.out.println("불변 리스트 타입: " + immutableList.getClass().getSimpleName());

        // 불변 리스트 수정 시도해보기
        try {
            // immutableList.add("D"); // 실행하면 UnsupportedOperationException 발생
            System.out.println("불변 리스트는 수정할 수 없습니다.");
        } catch (UnsupportedOperationException e) {
            System.out.println("수정 시도 실패: " + e.getClass().getSimpleName());
        }

        System.out.println();
        System.out.println("--- 2단계: 불변 → 가변 변환 ---");

        // 불변 리스트를 가변 리스트로 변환 - 실제 작업에서 자주 사용하는 패턴
        List<String> mutableList = new ArrayList<>(immutableList); // 불변 → 가변
        mutableList.add("D"); // 가변 리스트이므로 추가 가능
        mutableList.add("E");
        System.out.println("가변 리스트로 변환 후: " + mutableList);
        System.out.println("가변 리스트 타입: " + mutableList.getClass().getSimpleName());

        System.out.println();
        System.out.println("--- 3단계: List → 배열 변환 ---");

        // List를 배열로 변환
        String[] backToArray = mutableList.toArray(new String[mutableList.size()]); // List → 배열
        System.out.println("배열로 변환: " + java.util.Arrays.toString(backToArray));
        System.out.println("배열 길이: " + backToArray.length);

        System.out.println();
        System.out.println("--- 4단계: 서로 다른 List 타입 조합 ---");

        // 서로 다른 구현체의 List들을 하나로 합치기
        List<Integer> arrayList = new ArrayList<>();      // ArrayList
        arrayList.add(1);
        arrayList.add(2);

        List<Integer> linkedList = new LinkedList<>();    // LinkedList
        linkedList.add(3);
        linkedList.add(4);

        List<Integer> immutableNumbers = List.of(5, 6);   // 불변 List

        // 모든 List를 ArrayList로 합치기 - 구현체에 관계없이 처리
        List<Integer> combined = new ArrayList<>();
        combined.addAll(arrayList);    // ArrayList 추가
        combined.addAll(linkedList);   // LinkedList 추가
        combined.addAll(immutableNumbers); // 불변 List 추가

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("불변 List: " + immutableNumbers);
        System.out.println("합친 결과: " + combined);
        System.out.println("결과 타입: " + combined.getClass().getSimpleName());

        System.out.println();
        System.out.println("--- 정리 ---");
        System.out.println("List 변환 패턴:");
        System.out.println("1. 배열 → 불변 List: List.of(array)");
        System.out.println("2. 불변 → 가변 List: new ArrayList<>(immutableList)");
        System.out.println("3. List → 배열: list.toArray(new Type[0])");
        System.out.println("4. 여러 List 합치기: addAll() 메서드 활용");
    }
}
