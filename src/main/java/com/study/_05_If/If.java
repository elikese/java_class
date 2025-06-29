package com.study._05_If;

public class If {
    public static void main(String[] args) {
        /*
        if (조건식) {
            // if문의 조건식은 반드시 boolean 결과를 가져야 함
            // 조건이 참(true)일 때 실행되는 코드
            // 여러 줄 작성 가능
        }
        */

        int height = 130;

        if (height >= 120) {
            System.out.println("탑승 가능");
            System.out.println("탑승함");
        }

        //키가 120이상이고 어른이 아니면 탑승 가능
        boolean isAdult = false;
        if (height >= 120 && !isAdult) {
            System.out.println("탑승 가능");
        }

        //키가 120이상이거나 어른이면 탑승 가능
        if (height >= 120 || isAdult) {
            System.out.println("탑승 가능");
        }

    }
}
