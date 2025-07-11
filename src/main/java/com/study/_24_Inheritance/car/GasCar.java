package com.study._24_Inheritance.car;

public class GasCar extends Car{
    private int fuelLevel;

    public GasCar() {
        super();
        System.out.println("GasCar 생성자 호출");
        this.fuelLevel = 50;
    }

    public GasCar(String brand) {
        super(brand);
        System.out.println("GasCar 생성자 호출: " + brand);
        this.fuelLevel = 50;
    }

    /*
     * 메서드 오버라이딩 (재정의)
     *
     * JVM 메모리 동작:
     * - Method Area에 Car.move()와 GasCar.move()가 별도로 존재
     * - 오버라이딩은 "덮어쓰기"가 아니라 각 클래스에 정의된 독립적인 메서드
     * - JVM은 실제 객체 타입(GasCar) 기준으로 메서드 선택 (동적 디스패치)
     *
     * 규칙:
     * 1. 메서드 시그니처(메서드 이름, 매개변수, 반환타입)가 부모와 완전히 동일해야 함
     * 2. @Override 어노테이션 -> 컴파일러가 검사해 줌
     */

    @Override
    public void move() {
        System.out.println("가솔린차를 힘차게 이동합니다! 🔥");
    }

    @Override
    public void showInfo() {
        System.out.println("브랜드: " + brand);  // 부모 필드 직접 접근
        System.out.println("연료: " + fuelLevel + "L");
        System.out.println("차종: 가솔린차");
    }

    // 가솔린차만의 고유 메서드
    public void fillGas() {
        System.out.println("주유합니다. 연료: " + fuelLevel + "L → 60L");
        this.fuelLevel = 60;
    }
}
