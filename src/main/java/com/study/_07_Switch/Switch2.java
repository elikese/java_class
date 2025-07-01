package com.study._07_Switch;

public class Switch2 {
    public static void main(String[] args) {
        // Java 14부터 도입된 새로운 switch문
        String grade = "VVIP";

        // 표현식(대입연산자로 연산결과가 직접 대입 됨)
        // 장점:
        // 1. break 불필요
        // 2. 값을 바로 대입
        // 3. 더 간결한 문법
        int coupon = switch (grade) {
            case "NORMAL" -> 1000;
            case "VIP" -> 2000;
            case "VVIP" -> 3000;
            default -> 500;
        };

        System.out.println("발급받은 쿠폰: " + coupon);
    }
}
