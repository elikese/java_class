package com.study._03_Operator;

public class Operator3 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        // 결과를 변수에 저장 가능(연산결과가 boolean)
        boolean result = a == b;
        System.out.println("비교 결과: " + result);  // false

        // 문자열의 값비교는 == 대신 .equals() 사용!
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        // 잘못된 방법 (때로는 작동하지만 위험)
        System.out.println("문자열비교1: " + str1 == str2); // String pool(메모리를 캐시화해서 같은걸 바라봄) -> true
        System.out.println("문자열비교2: " + str1 == str3); // new로 만들어져서 메모리주소가 다름

        /*
        - 자료형 분류
        1. 자료형 - 원시형: int, double, long, float....
        2. 자료형 - 참조형: String, Array, 객체들

        - JVM 메모리 간단 소개
        Stack + Heap
        Stack -> 원시자료형 데이터(10,'A',3.14), 참조형 주소값(메모리주소: 0x1A2B)
        Heap -> 참조자료형 데이터("hello", "world") &
                Garbage Collector(GC)가 더 이상 참조되지 않는 객체들 참조형자료값들을 메모리에서 제거

                malloc() -> free()로 부터 해방
         */



        // 올바른 방법
        System.out.println(str1.equals(str2));     // true
        System.out.println(str3.equals(str1));  // true
        System.out.println("hello".equals(str1));  // true

        // 마치 두 편지의 내용을 비교하는 것처럼
        // 겉모습(==)이 아니라 내용(.equals())을 비교해야 함!
    }
}
