package com.study._36_Enum;

public enum Grade {

    // 인스턴스의 이름이지만, 생성자 역할을 함
    BASIC(10), // BASIC 이란 상수 인스턴스 생성자
    GOLD(20),
    DIAMOND(30);

    private int discountRate;

    Grade(int discountPercent) {
        this.discountRate = discountRate;
    }

    // 클래스다 보니, 메서드 선언도 가능
    // 할인하는 것 까지 책임 지게 할 수 있음
    public int discount(int price) {
        return price * discountRate / 100;
    }

    public int getDiscountRate() {
        return discountRate;
    }


    /*
     * public class Grade extends Enum {
     *     public static final Grade BASIC = new Grade();
     *     public static final Grade GOLD = new Grade();
     *     public static final Grade DIAMOND = new Grade();
     *
     *     private Grade() {}
     * }
     * 컴파일러가 알아서 코드를 작성해 준다
     * 
     * enum을 사용하게 되면, Enum 클래스를 상속받음
     * -> 미리 정의된 메서드 사용가능
     *
     * 즉, enum은 Enum클래스를 상속받은
     * 상수용 인스턴스 제조 클래스(컴파일러가 알아서 코드 작성해주는)
     *
     *
     * 열거형 권장 사용 시점:
     * - 상수들이 서로 관련이 있을 때
     * - 고정된 상수 집합이 필요할 때
     * - 컴파일 시점에 모든 값을 알 수 있을 때
     *
     * 예시: 요일, 계절, 상태값, 등급, 색상 등
     *
     */

    /*
    결제 수단별 수수료 시스템을 만들어보세요.

    기본 조건:
    결제 수단은 현금, 카드, 모바일 3가지입니다
    각 결제 수단별 수수료율은 다음과 같습니다:
    현금: 0%
    카드: 2%
    모바일: 1%
    구현 요구사항:
    PaymentMethod라는 이름의 enum을 만드세요
    각 결제 수단은 수수료율과 한글 표시명을 가져야 합니다
    결제 금액을 입력받아 수수료를 계산하는 메서드를 만드세요
    결제 수단의 한글 이름을 반환하는 메서드를 만드세요

     */
}
