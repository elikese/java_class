package com.study._07_For;

public class For {
    public static void main(String[] args) {
        //반복문 - for
        // for ( 선언; 조건; 증감 ) {
        //      반복될 코드
        // }

        //초기식 → (조건식 → 블록 → 증감식) 반복 → 조건식이 false면 종료
        for (int i = 0; i < 10; i++) {
            System.out.println("안녕" + i);
        }


        int a = 1;
        for (; a < 6; a++) {
            System.out.println(a);
        }

        System.out.println("==================================");

        //1~10까지 출력, 짝수만 출력
        //첫번째 방법, 근데 이제 if문을 곁들인
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        //두번째 방법
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }

        //10 ~ 1까지 거꾸로 출력
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        //문제 => 1~100까지 다 더한 값을 출력하시오
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
