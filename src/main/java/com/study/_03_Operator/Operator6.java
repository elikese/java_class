package com.study._03_Operator;

public class Operator6 {
    public static void main(String[] args) {
        // 삼항연산자

        int x = 5;
        int y = 3;
        int max = (x > y) ? x : y;
        System.out.println(max);

        int min = (x < y) ? x : y;
        System.out.println(min);

        x = 3;
        boolean isSame = (x == y) ? true : false;
        System.out.println(isSame);

        String sameStr = (x != y) ? "다름" : "같음";
        System.out.println(sameStr);


        /* 실습
         * int height = 숫자;
         * 키가 120이상인 경우 탑승 가능하도록 하는 삼항연산자
         * 가능하면 "탑승 가능" 불가능하면 "탑승 불가능" 출력
         * */
        int height = 119;
        String result = (height >= 120) ? "탑승 가능" : "탑승 불가능";
        System.out.println(result);
    }
}
