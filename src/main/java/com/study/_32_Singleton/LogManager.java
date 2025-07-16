package com.study._32_Singleton;

public class LogManager {
    // 싱글톤(singleton)
    // 애플리케이션 전체에서 단 하나의 인스턴스를 공유하도록 하는 패턴
    // 자원을 공유해야할때 => 설정파일
    // 객체를 여러 번 만들 필요가 없고, 한 번만 만들고 재사용하는 경우

    /*
    1. private static instance	외부와 공유할 단 하나의 객체 저장용 변수
    2. private 생성자	외부에서 직접 생성(new) 못하게 차단
    3. public static getInstance()	객체를 만들고, 같은 객체를 반환하는 유일한 접근 방법
     */


    // 인스턴스 변수를 담아둘 static 필드(전역에서 공유)
    private static LogManager instance;

    private LogManager () {} //생성자를 private으로 막아서 외부에서 new 금지

    // 외부에서는 getInstance()로만 LogManger의 객체를 생성/사용 가능
    public static LogManager getInstance() {
        if (instance == null) { // 필드의 인스턴스가 존재하는지 확인
            instance = new LogManager(); // 없다면 최초 1회 객체 생성
        }
        return instance; // 있다면 필드의 인스턴스를 반환
    }

    public void log(String message) {
        System.out.println("LOG :" + message);
    }

    // 참고: 스프링 프레임워크에서는 객체(빈)를 싱글톤으로 많이 관리함.
    // 여러 요청마다 new로 생성되면 메모리부담
    // 주로 기능적인 서비스 클래스 하나를 돌려쓰게 됨! -> 템플릿화 시켜버린게 스프링
}
