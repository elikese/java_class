package com.study._16_Overloading;

public class Overloading {
    public static void printInfo(String name) {
        System.out.println("이름은 " + name);
    }

    public static void printInfo(String name, int age) {
        System.out.println("이름은 " + name + ", 나이는" + age);
    }

    public static void printInfo(String name, int age, String email) {
        System.out.println("이름은 " + name + ", 나이는" + age + ", 이메일은 " + email);
    }

    public static void printAddNum(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a+b));
    }
    // 시그니처: Overloading class의 printAddNum 함수(1: int, 2: int)

    public static void printAddNum(int a, double b) {
        System.out.println(a + "+" + b + "=" + ((double)a+b));
    }
    // 시그니처: Overloading class의 printAddNum 함수(1: int, 2: double)

    public static void printAddNum(double a, int b) {
        System.out.println(a + "+" + b + "=" + (a+(double)b));
    }
    // 시그니처: Overloading class의 printAddNum 함수(1: double, 2: int)

    public static void printAddNum(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a+b));
    }
    // 시그니처: Overloading class의 printAddNum 함수(1: double, 2: double)

//    public static void printNum(int a) {
//        System.out.println("넘어온 값 : " + a);
//    }

    public static void printNum(double a) {
        System.out.println("넘어온 값 : " + a);
    }

    public static void main(String[] args) {
        // 메서드 오버로딩
        // 같은 이름의 메서드를 여러 개 선언
        // 매개변수(파라미터)의 타입 / 순서 / 갯수가 다르면 같은 메서드 이름을 사용 할 수 있다
        // 컴파일러가 메서드를 인식하는 기준 -> 메서드 시그니처(이름 + 매개변수 타입 목록)

        //메소드 이름 add()
        printAddNum(3, 4);
        printAddNum(1.2, 3.4);
        printAddNum(1.2,1);
        printAddNum(1,1.5);

        //문제
        //메소드 이름 printInfo()
        //문자열 이름만 전달 => 이름을 출력
        //문자열 이름, 정수 나이 전달 => 이름 나이 출력
        //문자열 이름, 정수 나이, 문자열 이메일 => 이름 나이 이메일 출력
        printInfo("홍길동");
        printInfo("홍길동", 33);
        printInfo("홍길동", 33, "java@naver.com");


        printNum(1);
        // 만약 int용 printNum 메서드가 없어면
        // printNum(1) 호출 시 → 자동으로 printNum(1.0)으로 형변환되어
        // double용 printNum 메서드가 호출됩니다!
        //
        // 1. 정확히 매칭되는 시그니처를 찾는다.
        // 없으면,
        // 2. 자동 형변환이 가능한 시그니처를 찾는다.


    }
}
