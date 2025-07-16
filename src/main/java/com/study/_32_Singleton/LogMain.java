package com.study._32_Singleton;

public class LogMain {
    public static void main(String[] args) {
        // LogManager의 인스턴스를 가져옴
        LogManager logger1 = LogManager.getInstance();
        logger1.log("처음 로그입니다.");

        // 또 가져와도 같은 객체
        LogManager logger2 = LogManager.getInstance();
        logger2.log("두 번째 로그입니다.");

        // 객체가 같은지 확인해봅시다
        System.out.println(logger1 == logger2);
        // true
    }
}
