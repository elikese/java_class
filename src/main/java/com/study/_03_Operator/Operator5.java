package com.study._03_Operator;

public class Operator5 {
    public static void main(String[] args) {
        // 복합대입 연산자
        int a = 5;

        // 기본 방법
        a = a + 3;  // a를 3 증가시키기
        System.out.println("a = " + a);  // 8

        // 축약 방법 (복합 대입 연산자)
        a += 2;  // a = a + 2와 같음
        System.out.println("a = " + a);  // 10

        a -= 1;  // a = a - 1와 같음
        System.out.println("a = " + a);  // 9

        a *= 2;  // a = a * 2와 같음
        System.out.println("a = " + a);  // 18

        a /= 3;  // a = a / 3와 같음
        System.out.println("a = " + a);  // 6

        a %= 4;  // a = a % 4와 같음
        System.out.println("a = " + a);  // 2


        // 학교나 자격증 시험에 잘나오는 거(연산자 우선순위)
        // 1. 괄호 ()               - 가장 높음
        // 2. 단항 연산자 (++, --, !)
        // 3. 산술 연산자 (*, /, % 먼저, 그 다음 +, -)
        // 4. 비교 연산자 (<, >, <=, >=)
        // 5. 등식 연산자 (==, !=)
        // 6. 논리 연산자 (&&, ||)
        // 7. 대입 연산자 (=, +=, -=) - 가장 낮음

        // 복잡한 식의 예
        int num1 = 5;
        int num2 = 3;
        boolean result = num1 > num2 && num1 + num2 < 10;
        // 실행 순서: num1 + num2 (산술) → num1 > num2 (비교) → < 비교 → && (논리)
    }
}
