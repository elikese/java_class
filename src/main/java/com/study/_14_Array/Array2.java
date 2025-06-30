package com.study._14_Array;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        //배열 순회(반복문)

        String[] names = {"일길동", "이길동", "삼길동", "사길동", "오길동"};
//        names = new String[]{"일길동", "이길동", "삼길동", "사길동", "오길동", "육길동"};

        //반복문 for문을 통해 배열 순회
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i]);
        }
        /*
         * 문제점:
         * - 배열에 이름을 추가하면?
         * - for문의 조건도 함께 수정해야 함 (5 → 6)
         * - 실수하기 쉽고 유지보수가 어려움
         */

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }


        // enhanced for (for-each) 향상된 for문
        // 가독성좋음, 직관적
        // 인덱스 접근이 안되는 단점
        for (String name : names) {
            System.out.println(name);
        }
    }
}
