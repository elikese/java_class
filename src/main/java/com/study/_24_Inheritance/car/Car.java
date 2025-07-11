package com.study._24_Inheritance.car;

public class Car {
    /*
     * 🏗️ 기초 설계도 역할
     * 모든 차가 공통으로 가져야 하는 기능을 정의
     */

    // 필드 (공통 속성)
    protected String brand;  // protected - 자식만 접근 가능
    private int year;

    // 기본 생성자
    public Car() {
        System.out.println("Car 생성자 호출");
        this.brand = "기본차";
    }

    // 매개변수 있는 생성자
    public Car(String brand) {
        System.out.println("Car 생성자 호출: " + brand);
        this.brand = brand;
    }

    // 공통 메서드들
    public void move() {
        System.out.println("차를 이동합니다.");
    }

    public void openDoor() {
        System.out.println("문을 엽니다.");
    }

    public void showInfo() {
        System.out.println("브랜드: " + brand);
    }

}
