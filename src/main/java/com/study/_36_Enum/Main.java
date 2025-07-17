package com.study._36_Enum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 모든 ENUM 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));

        // String -> Enum
        Grade goldInstance = Grade.valueOf("GOLD");
        System.out.println(goldInstance == Grade.GOLD);

        // Enum -> String
        String name = Grade.GOLD.name();
        System.out.println(name);

        int price = 10000;

        int basic = Grade.BASIC.discount(price);
        int gold = Grade.BASIC.discount(price);
        int diamond = Grade.BASIC.discount(price);

        System.out.println("BASIC 등급의 할인 금액: " + basic);
        System.out.println("GOLD 등급의 할인 금액: " + gold);
        System.out.println("DIAMOND 등급의 할인 금액: " + diamond);

        // 미리 선언해둔 상수 말고, Enum으로 바꿀 경우
        // 특히 DB에서 가져온 데이터(String일 경우가 많음)
        /*
        public class User {
            private String grade;
        }

        Grade userGrade = Grade.valueOf(user.getGrade());
        // 여기서 user.getGrade()가 Enum에 없는 인스턴스 이름이면 에러발생
        */

    }

    public static int discount(Grade grade, int price) {
        int discountPercent = 0;

        if (grade == Grade.BASIC) {
            discountPercent = Grade.BASIC.getDiscountRate();
        } else if (grade == Grade.GOLD) {
            discountPercent = Grade.GOLD.getDiscountRate();
        } else if (grade == Grade.DIAMOND) {
            discountPercent = Grade.DIAMOND.getDiscountRate();
        } else {
            System.out.println("할인X");
            return 0;
        }

        return price * discountPercent / 100;
    }
}
