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
