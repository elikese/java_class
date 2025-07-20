package com.study._37_Exception;

public class UncheckedMain {

    // 언체크 예외를 던지는 메서드 (throws 선언 선택적)
    static int divide(int a, int b) {
        if (b == 0) {
            throw new MyUnCheckedException("0으로 나눌 수 없습니다");
        }
        return a / b;
    }

    // throws 선언 없이도 예외 전파
    static void callMethodNoThrows() {
        divide(5, 0); // 예외 발생하면 자동 전파
    }

    public static void main(String[] args) {

        // === 언체크 예외 기본 사용 ===
        System.out.println("=== 언체크 예외 기본 사용 ===");

        // 예외 처리는 선택적(try-catch 강제 아님)
        try {
            divide(10, 0);
        } catch (MyUnCheckedException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        // === 자동 예외 전파 ===
        System.out.println("\n=== 자동 예외 전파 ===");

        try {
            callMethodNoThrows();
        } catch (MyUnCheckedException e) {
            System.out.println("전파된 예외 처리: " + e.getMessage());
        }

        // === 정상 케이스 ===
        System.out.println("\n=== 정상 케이스 ===");

        try {
            int result = divide(10, 2);
            System.out.println("나눗셈 결과: " + result);
        } catch (MyUnCheckedException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // === 일반적인 런타임 예외들 ===
        System.out.println("\n=== 일반적인 런타임 예외들 ===");

        // NullPointerException
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("NPE 발생: null 문자열의 길이 확인 시도");
        }

        /*
         * 1. NullPointerException           : null 객체에 접근
         * 2. ArrayIndexOutOfBoundsException: 배열 인덱스 초과 접근
         * 3. ArithmeticException            : 0으로 나누기 등 수학 오류
         * 4. IllegalArgumentException       : 잘못된 인자 전달
         * 5. NumberFormatException          : 숫자 형식 변환 실패 (예: "abc" → int 변환)
         */
    }

}
