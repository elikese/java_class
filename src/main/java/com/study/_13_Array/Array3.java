package com.study._13_Array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        // ========== 기본 자료형 배열 (int, double, boolean 등) ==========
        System.out.println("--- 기본 자료형 배열 ---");
        int[] original = {1, 2, 3, 4, 5};

        // 얕은 복사: 참조만 복사 (같은 메모리 주소를 가리킴)
        int[] shallowCopy = original; // 위험! 같은 배열을 가리킴

        // 깊은 복사: 새로운 배열을 만들어서 값을 복사
        int[] deepCopy = Arrays.copyOf(original, original.length);

        System.out.println("원본: " + Arrays.toString(original));
        System.out.println("얕은복사: " + Arrays.toString(shallowCopy));
        System.out.println("깊은복사: " + Arrays.toString(deepCopy));

        // 원본 배열 수정
        original[0] = 999;

        System.out.println("\n원본 배열 수정 후:");
        System.out.println("원본: " + Arrays.toString(original));
        System.out.println("얕은복사: " + Arrays.toString(shallowCopy)); // 함께 변경됨!
        System.out.println("깊은복사: " + Arrays.toString(deepCopy));   // 변경되지 않음


        System.out.println("=".repeat(50));

        int[] nums = {8, 4, 5, 1, 7, 10, 6, 2, 9, 3};
        System.out.println(Arrays.toString(nums)); // 값을 한번에 출력

        // 오름차순 정렬
        // 원본을 건드립니다.
        Arrays.sort(nums);
        System.out.println("오름차순 정렬: " + Arrays.toString(nums));
    }
}
