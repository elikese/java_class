package com.study._15_Method;

public class Return {

    // 리턴값이 존재한다면 void대신 리턴되는 data의 자료형을 적어 줌
    public static int add(int num1, int num2) {
        int result = num1 + num2;
        return result; // return이 되면 함수 종료
    }

    public static int multiply(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    public static boolean checkAdult(int age) {
        /*
         * 간단한 조건 확인 메서드
         * 메서드 이름만 봐도 기능을 알 수 있음
         */
        return age >= 20; // 20세 이상이면 true
    }


    public static void main(String[] args) {
        int addResult = add(10, 20); // addResult에 return이 대입 됨
        System.out.println(addResult);

        // return이 있는 함수의 경우,
        // 리턴되는 data가 값이라면 값, 객체라면 객체로 다룰 수 있다.
        System.out.println(add(10,20));

        int addResult2 = add(10, add(10,20));
        System.out.println(addResult2);
    }
}
