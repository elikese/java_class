package com.study._03_Operator;

public class Operator2 {
    public static void main(String[] args) {
        int a = 1;
        // 전위 증감: 먼저 증가하고 나서 사용
        int b = ++a; // a를 먼저 2로 증가시키고, 그 값을 b에 대입
        System.out.println("a = " + a);  // 2
        System.out.println("b = " + b);  // 2


        a = 1;
        // 전위 감소: 먼저 감소하고 나서 사용
        int c = --a;  // a를 먼저 0으로 감소시키고, 그 값을 c에 대입
        System.out.println("a = " + a);  // 1
        System.out.println("c = " + c);  // 1

        a = 1;
        // 후위 증감: 먼저 사용하고 나서 증가
        b = a++;  // a의 현재 값(1)을 b에 대입하고, 그 다음에 a를 2로 증가
        System.out.println("a = " + a);  // 2
        System.out.println("b = " + b);  // 1


        a = 1;
        // 후위 감소: 먼저 사용하고 나서 감소
        c = a--;  // a의 현재 값(1)을 c에 대입하고, 그 다음에 a를 0으로 감소
        System.out.println("a = " + a);  // 0
        System.out.println("c = " + c);  // 1

        // 단독 사용시(대입없이 혼자 코드 한줄 차지할때)에는 결과가 같음
        ++a;  // a를 1 증가
        a++;  // a를 1 증가 (결과 동일)
    }
}
