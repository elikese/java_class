package com.study._13_Array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        int[] nums = {8, 4, 5, 1, 7, 10, 6, 2, 9, 3};
        int[] nums2 = {8, 4, 5, 1, 7, 10, 6};
        System.out.println(Arrays.toString(nums)); // 값을 한번에 출력

        int[] copy = Arrays.copyOf(nums, nums.length); // 복사
        System.out.println(Arrays.toString(copy));

        System.out.println("값이 같나? " + Arrays.equals(nums, copy)); // 값비교

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // 오름차순 정렬

    }
}
