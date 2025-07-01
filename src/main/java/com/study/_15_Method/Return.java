package com.study._15_Method;

public class Return {

    // void 가 아니라 return되는 data의 자료형을 적어 줌
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
        int addResult2 = add(10, add(10,20));
        System.out.println(addResult2);
    }
}
