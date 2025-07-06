package com.study._01_Print;

public class Printf {
    public static void main(String[] args) {
        /*
        printf 사용법
        (형식지정자)
        %d(decimal) -> 정수
        %f(float) -> 실수
        %s(string) -> 문자열
        %c(character) -> 문자
         */


        int age = 25;
        double height = 172.565;
        String name = "홍길동";

        System.out.printf("이름: %s\n나이: %d살\n키: %.1fcm\n", name, age, height);
        // 각 파라미터는 순서에 맞춰서 형식지정자와 페어링된다.


    }
}
