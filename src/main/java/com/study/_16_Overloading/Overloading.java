package com.study._16_Overloading;

public class Overloading {
    public static int getPower(int number) {
        return number * number;
    }

    public static int getPower(double doubleNum) {
        int number = (int) doubleNum;
        return number * number;
    }

    public static int getPower(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    public static void printInfo(String name) {
        System.out.println("이름은 " + name);
    }

    public static void printInfo(String name, int age) {
        System.out.println("이름은 " + name + ", 나이는" + age);
    }

    public static void printInfo(String name, int age, String email) {
        System.out.println("이름은 " + name + ", 나이는" + age + ", 이메일은 " + email);
    }

    public static void add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a+b));
    }

    public static void add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a+b));
    }


    public static void main(String[] args) {
        //메소드 오버로딩
        //같은 이름의 메소드를 여러 개 선언
        //매개변수(파라미터)의 타입이 달라야한다 또는 갯수가 달라야한다.
        //컴파일러가 메서드를 인식하는 방법 -> 메서드 시그니처(이름 + 매개변수 타입 목록)

        System.out.println(getPower(3));
        System.out.println(getPower(2.3));
        System.out.println(getPower(2, 4));

        //문제
        //메소드 이름 printInfo()
        //문자열 이름만 전달 => 이름을 출력
        //문자열 이름, 정수 나이 전달 => 이름 나이 출력
        //문자열 이름, 정수 나이, 문자열 이메일 => 이름 나이 이메일 출력

        printInfo("홍길동");
        printInfo("홍길동", 33);
        printInfo("홍길동", 33, "java@naver.com");

        //메소드 이름 add()
        //int와 int 덧셈
        //double과 double 덧셈
        //문자열숫자와 문자열숫자 덧셈
        add(3, 4);
        add(1.2, 3.4);
    }
}
