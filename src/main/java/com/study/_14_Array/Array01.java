package com.study._14_Array;

public class Array01 {
    public static void main(String[] args) {
        /*
         * 배열이란?
         * - 같은 자료형의 여러 데이터를 한 번에 관리할 수 있는 저장 공간
         * - 연속된 공간이라서 loop시 속도면에 유리 함
         * - 각 공간마다 고유한 번호(인덱스)가 있어서 정확히 찾아갈 수 있음
         */


        // ========== 배열 없이 학생 점수 관리 ==========
        // 변수 5개를 각각 선언 - 번거롭고 관리하기 어려움
        int student1 = 90;
        int student2 = 80;
        int student3 = 70;
        int student4 = 60;
        int student5 = 50;

        System.out.println("학생1 점수: " + student1);
        System.out.println("학생2 점수: " + student2);
        System.out.println("학생3 점수: " + student3);
        System.out.println("학생4 점수: " + student4);
        System.out.println("학생5 점수: " + student5);


        // ========== 배열로 학생 점수 관리 ==========
        /*
         * 배열 선언과 생성
         * int[] students → int형 배열을 담을 변수 선언
         * new int[5] → 실제로 5개의 방을 가진 배열을 메모리에 생성
         */
        int[] students = new int[5];  // 5개 요소를 가진 배열 생성

        // 배열에 값 저장 - 인덱스는 0부터 시작!
        students[0] = 90;  // 0번 방에 90 저장
        students[1] = 80;  // 1번 방에 80 저장
        students[2] = 70;  // 2번 방에 70 저장
        students[3] = 60;  // 3번 방에 60 저장
        students[4] = 50;  // 4번 방에 50 저장

        System.out.println("학생1 점수: " + students[0]);
        System.out.println("학생2 점수: " + students[1]);
        System.out.println("학생3 점수: " + students[2]);
        System.out.println("학생4 점수: " + students[3]);
        System.out.println("학생5 점수: " + students[4]);


        // ========== 배열의 편리한 초기화 방법 ==========
        /*
         * 배열 생성과 동시에 값 초기화
         * 방법1: new int[]{값1, 값2, 값3, ...}
         * 방법2: {값1, 값2, 값3, ...} (선언과 동시에만 가능)
         */
        int[] scores = new int[]{90, 80, 70, 60, 50};
        // 또는 더 간단하게:
        int[] simpleScores = {95, 85, 75, 65, 55}; // 이걸 가장 많이 사용

        System.out.println("\n=== 초기화된 배열 출력 ===");
        System.out.println("첫 번째 학생 점수: " + scores[0]);
        System.out.println("마지막 학생 점수: " + scores[4]);


        // 배열명.length → 배열의 크기를 알려줌
        System.out.println("\n=== 배열 정보 ===");
        System.out.println("students 배열의 크기: " + students.length);
        System.out.println("scores 배열의 크기: " + scores.length);


    }
}
