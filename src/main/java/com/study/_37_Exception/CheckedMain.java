package com.study._37_Exception;

public class CheckedMain {

    // 체크 예외를 던지는 메서드 (throws 필수)
    static void checkAge(int age) throws MyCheckedException {
        if (age < 18) {
            throw new MyCheckedException("나이가 18세 미만입니다: " + age);
        }
        System.out.println("나이 확인 완료: " + age);
    }

    public static void main(String[] args) {
        // === 체크 예외 기본 사용 ===
        System.out.println("=== 체크 예외 기본 사용 ===");

        // 방법 1: try-catch로 처리
        try {
            checkAge(15);
        } catch (MyCheckedException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        // === 정상 케이스 ===
        System.out.println("\n=== 정상 케이스 ===");

        try {
            checkAge(25);
            System.out.println("나이 검증 통과");
        } catch (MyCheckedException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        /*
         * 1. IOException              : 파일이나 네트워크 입출력 실패
         * 2. FileNotFoundException    : 존재하지 않는 파일을 열 때
         * 3. SQLException             : 데이터베이스 작업 실패
         */
    }
}
