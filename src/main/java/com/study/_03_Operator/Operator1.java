package com.study._03_Operator;

public class Operator1 {
    public static void main(String[] args) {
        /*
        연산자는 계산을 수행하는 기호
        // 3 + 4    // +가 연산자, 3과 4가 피연산자
        // a - b    // -가 연산자, a와 b가 피연산자

        종류
        산술연산자: 사칙연산 (+, -,  *, /, %)
        비교연산자: 같냐,크냐,작냐(==, !=, <, <=, >, >=)
        증감연산자: 1씩 증가하거나 감소하거나(++, --)
        논리연산자: 논리끼리 연산(not:!, and:&&, or:||)
        대입연산자: 값저장(=. +=. -=, *=, /=, %=)

        */

        // 변수 초기화
        int a = 5;
        int b = 2;

        // 덧셈
        int sum = a + b;
        System.out.println("a + b = " + sum);     // 7

        // 문자열 덧셈
        // 문자열 + 문자열
        String result1 = "hello " + "world";
        System.out.println(result1);  // hello world

        // 문자열 + 숫자 = 문자열 (숫자가 문자로 변환됨)
        String result2 = "a + b = " + 10;
        System.out.println(result2);  // a + b = 10

        // 혼합 계산 - 왼쪽부터 차례대로 계산!
        int one = 1;
        int two = 2;
        System.out.println("one + two = " + one + two);     // a + b = 12 (1과 2가 문자로 이어붙음)
        System.out.println("one + two = " + (one + two));   // a + b = 3 (괄호로 먼저 계산)

        int x = 10;
        int y = 20;

        // 숫자 계산 후 문자열 연결
        System.out.println(x + y + " = 합계");        // 30 = 합계

        // 문자열 연결 후 숫자 이어붙이기
        System.out.println("합계 = " + x + y);        // 합계 = 1020

        // 올바른 계산을 위해 괄호 사용
        System.out.println("합계 = " + (x + y));      // 합계 = 30

        // 뺄셈
        int diff = a - b;
        System.out.println("a - b = " + diff);   // 3

        // 곱셈
        int multi = a * b;
        System.out.println("a * b = " + multi);  // 10

        // 나눗셈
        int div = a / b;
        System.out.println("a / b = " + div);    // 2 (5÷2=2.5이지만 정수부분만)

        // 나머지
        int mod = a % b;
        System.out.println("a % b = " + mod);    // 1 (5÷2=2...1)
        // 배수판별 할때, 짝수(2로 나눴을때 나머지 0)
        // 3의 배수냐(3으로 나눴을때 나머지0)
        // 10시 + 30시간 -> 10 + (30%24)

    }

}
