package com.study._37_Exception;

public class ExceptionMain {

    static void method1() {
        System.out.println("method1에서 method2 호출");
        method2(); // 예외를 받아서 그대로 전파
    }

    static void method2() {
        System.out.println("method2에서 예외 발생");
        // 예외 전파란?
        // 이 위치에서 예외가 발생하지만, method2 안에서는 처리하지 않음
        // 따라서 method1 → main 순서로 호출한 쪽으로 예외가 계속 전달됨
        throw new RuntimeException("method2에서 발생한 예외");
    }

    public static void main(String[] args) {
        /*
         * 예외 처리의 핵심 목적:
         * 1. 프로그램 비정상 종료 방지
         * 2. 정상 흐름과 예외 흐름 분리
         * 3. 오류 상황에 대한 적절한 대응
         * 4. 사용자에게 의미있는 오류 메시지 제공
         */

        /*
         * 자바 예외 계층:
         * Object
         *   └─ Throwable (예외의 최상위 클래스)
         *       ├─ Error (시스템 레벨 오류, 복구 불가)
         *       └─ Exception (애플리케이션 레벨 예외)
         *           ├─ Checked Exception (컴파일 시점 검사)
         *           └─ RuntimeException (Unchecked Exception)
         *
         */

        /* 용어 정리:
         * - 예외 발생(생성): throw
         * - 예외 처리(소멸): catch
         * - 예외 전파: throws
         *
         * Error vs Exception:
         * - Error: 시스템에 비정상적인 상황, 개발자가 처리할 수 없음
         *   예) OutOfMemoryError, StackOverflowError
         * - Exception: 개발자가 처리할 수 있는 예외 상황
         *   예) 파일 없음, 네트워크 오류, 잘못된 입력값
         */

        try {
            throw new Exception("예외 메시지");
            // System.out.println("이 코드는 실행되지 않음"); // 도달 불가능한 코드

            /*
             * [예외 처리의 동작 원리]
             *
             * 1. throw 문이 실행되면
             *    → 예외 객체가 생성되고
             *    → 현재 메서드 실행이 즉시 중단됨
             *
             * 2. JVM은 현재 메서드 내부에서 try-catch 블록을 탐색함
             *    → 있다면: 해당 catch 블록으로 흐름이 이동하여 예외 처리
             *    → 없다면: 호출한 메서드로 예외를 전파 (메서드 호출 스택을 거슬러 올라감)
             *
             * 3. 이 과정을 catch 가능한 위치가 나올 때까지 반복
             *    → 끝까지 아무도 예외를 catch하지 않으면
             *       → JVM이 예외 정보를 출력하고 프로그램을 종료시킴
             */

        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        // === 예외 기본 규칙: 예외 전파 ===
        System.out.println("\n=== 예외 기본 규칙: 예외 전파 ===");

        try {
            System.out.println("main에서 method1 호출");
            method1();
            System.out.println("예외발생시 이 코드는 실행 x");
        } catch (RuntimeException ex) {
            System.out.println("main에서 예외 처리: " + ex.getMessage());
        } finally {
            System.out.println("예외 여부랑 상관없이 출력");
        }

        /*
         * finally 블록
         * - 예외 발생 여부와 상관없이 항상 실행되는 영역
         * - 주로 자원 정리 코드 작성 (파일 닫기, DB 연결 종료 등)
         * - 예외가 발생하든 안 하든 마지막에 꼭 실행되어야 하는 작업에 사용
         */


    }

}
