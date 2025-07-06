package com.study._15_Method;

import java.util.Arrays;

public class Parameter2 {


    public static void changeNumber(int number) {
        number += 2;
    }

    public static void changeArray(int[] arr) {
        arr[0] = 50;
    }


    public static void main(String[] args) {

        int num = 10;
        System.out.println("changeNum 호출 전: " + num);
        changeNumber(num);
        System.out.println("changeNum 호출 후: " + num);
        // 같다!
        // 자바에서 변수에 변수를 대입할때, 변수의 값(stack메모리)을 항상 복사해서 대입.
        /*
        stack
        num : 10
        number : 10 -> 12
         */


        int[] nums = {20, 30, 40};
        System.out.println("changeArray 호출 전: " + Arrays.toString(nums));
        changeArray(nums);
        System.out.println("changeArray 호출 후: " + Arrays.toString(nums));
        /*
        stack
        nums : 0x0010
        arr : 0x0010

        heap
        0x0010: array에 대한정보
        0x0014: 20 -> 50
        0x0018: 30
        0x0022: 40
         */

        // 원시자료형 -> 원본 조작 불가능
        // 참조자료형 -> 원본 조작 가능


    }
}
