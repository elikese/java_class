package com.study._06_If;

public class If {
    public static void main(String[] args) {
        /*
        if (조건/논리연산) {
            // if문의 조건식은 boolean
            // 조건연산 결과가 참(true)일 때 실행되는 코드
            // 여러 줄 작성 가능
        }
        */

        int height = 130;

        if (height >= 120) {
            System.out.println("탑승 가능");
            System.out.println("탑승함");
        }

        // 키가 120이상 탑승가능, 성인은 탑승불가능
        boolean isAdult = false;
        if (height >= 120 && !isAdult) {
            System.out.println("탑승 가능");
        }


    }
}
