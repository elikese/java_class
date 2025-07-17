package com.study._36_Enum;

public class ClassGrade {
    /*
    컴파일 시점 타입 검증 불가: 잘못된 값도 컴파일 성공, 런타임에서만 문제 발견
    -> null을 전달해도 사실상 컴파일은 됨.
    상수 그룹화 어려움: 서로 다른 도메인의 상수가 섞여서 잘못 사용될 수 있음
    네임스페이스 부족: 같은 이름의 상수들을 도메인별로 구분하기 어려움
    -> PRIVATE_KEY는 생각보다 많은 도메인에서 사용함(클라우드, db...)
    -> STATUS 같은경우 중복된 이름의 다른 도메인이 많음

    문자열 대신 객체를 그냥 상수처럼 쓰면 어떨까
     */
    private int discountRate;

    public static final ClassGrade BASIC = new ClassGrade(10);
    public static final ClassGrade GOLD = new ClassGrade(20);
    public static final ClassGrade DIAMOND = new ClassGrade(30);

    // private 생성자: 외부에서 임의로 인스턴스 생성 방지
    private ClassGrade(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    /*
    타입 안전성: 정해진 객체만 사용 가능, 컴파일 시점 검증
    데이터 일관성: 사전 정의된 인스턴스만 사용하므로 일관성 보장
    제한된 인스턴스: private 생성자로 외부 생성 방지
    */
}
