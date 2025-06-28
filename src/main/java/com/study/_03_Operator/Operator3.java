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

        // 올바른 방법
        System.out.println(str1.equals(str2));     // true
        System.out.println(str3.equals(str1));  // true
        System.out.println("hello".equals(str1));  // true

        // 마치 두 편지의 내용을 비교하는 것처럼
        // 겉모습(==)이 아니라 내용(.equals())을 비교해야 함!
    }
}
