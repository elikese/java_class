package com.study._39_Collections.list;

import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        /**
         * [필기] LinkedList - 노드 연결 구조의 리스트
         *
         * 1. LinkedList vs ArrayList 차이점
         *    - ArrayList: 내부에 배열 사용, 인덱스로 직접 접근 O(1)
         *    - LinkedList: 노드들을 연결, 순차 접근 필요 O(n)
         *
         * 2. 비유로 이해하기 (비상연락망)
         *    - ArrayList: 아파트 호수부 (호수 알면 바로 찾아감)
         *    - LinkedList: 비상연락망 (반장→부반장→학생1→학생2 순서대로 연결)
         *    - 중간에 새 학생 추가? 앞뒤 사람 연락처만 바꾸면 됨
         *
         * 3. LinkedList 내부 구조
         *    - 이중 연결 리스트 (Doubly Linked List
         *    - 각 노드: 데이터 + 이전노드참조 + 다음노드참조
         *    - 첫 번째(first)와 마지막(last) 노드 참조 유지
         *
         * 4. 시간 복잡도
         *    - 맨 앞/뒤 추가/삭제: O(1)
         *    - 중간 위치 추가/삭제: O(n) - 해당 위치까지 이동
         *    - 인덱스 접근: O(n)
         *
         * 5. LinkedList 전용 메서드
         *    - addFirst(), addLast()
         *    - removeFirst(), removeLast()
         *    - getFirst(), getLast()
         */

        System.out.println("=== LinkedList 기본 사용법 ===");

        LinkedList<String> list = new LinkedList<>();

        // 기본 추가 메서드
        list.add("B");              // 끝에 추가
        list.addFirst("A");         // 맨 앞에 추가
        list.addLast("C");          // 맨 뒤에 추가 (add와 동일)
        list.add(1, "A-B사이");     // 인덱스 1에 삽입

        System.out.println("리스트: " + list);

        /**
         * [필기] LinkedList 전용 메서드들
         *
         * ArrayList에는 없고 LinkedList에만 있는 메서드들:
         * - addFirst(E e): 맨 앞에 추가
         * - addLast(E e): 맨 뒤에 추가 (add와 동일하지만 의미가 명확)
         * - removeFirst(): 맨 앞 요소 제거 후 반환
         * - removeLast(): 맨 뒤 요소 제거 후 반환
         * - getFirst(): 맨 앞 요소 반환 (제거하지 않음)
         * - getLast(): 맨 뒤 요소 반환 (제거하지 않음)
         *
         * 이 메서드들은 모두 O(1) 시간복잡도를 가짐
         */

        // 조회 메서드
        System.out.println("첫 번째: " + list.getFirst());
        System.out.println("마지막: " + list.getLast());
        System.out.println("인덱스 2: " + list.get(2));

        // 제거 메서드
        String removed = list.removeFirst();
        System.out.println("맨 앞 제거: " + removed);
        System.out.println("제거 후: " + list);

        removed = list.removeLast();
        System.out.println("맨 뒤 제거: " + removed);
        System.out.println("제거 후: " + list);

        System.out.println();
        System.out.println("=== Queue로 활용 (FIFO) ===");

        LinkedList<String> queue = new LinkedList<>();

        // 데이터 추가 (뒤쪽에)
        queue.addLast("작업1");
        queue.addLast("작업2");
        queue.addLast("작업3");

        /**
         * [필기] Queue 패턴 구현
         *
         * Queue는 FIFO(First In First Out) 구조
         * - 데이터 추가: addLast() 사용
         * - 데이터 제거: removeFirst() 사용
         *
         * LinkedList가 Queue로 적합한 이유:
         * - addLast()와 removeFirst() 모두 O(1)
         * - ArrayList로 Queue 구현시 removeFirst()가 O(n)
         */

        // 데이터 처리 (앞쪽에서)
        while (!queue.isEmpty()) {
            String task = queue.removeFirst();
            System.out.println("처리: " + task + ", 남은 작업: " + queue);
        }

        System.out.println();
        System.out.println("=== Stack으로 활용 (LIFO) ===");

        LinkedList<String> stack = new LinkedList<>();

        // 데이터 추가 (맨 앞에)
        stack.addFirst("접시1");
        stack.addFirst("접시2");
        stack.addFirst("접시3");

        /**
         * [필기] Stack 패턴 구현
         *
         * Stack은 LIFO(Last In First Out) 구조
         * - 데이터 추가: addFirst() 사용
         * - 데이터 제거: removeFirst() 사용
         *
         * 실제로는 Stack 클래스나 ArrayDeque 사용 권장
         */

        // 데이터 제거 (맨 앞에서)
        while (!stack.isEmpty()) {
            String plate = stack.removeFirst();
            System.out.println("제거: " + plate + ", 남은 접시: " + stack);
        }
    }
}
