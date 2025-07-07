package com.study._17_Class;

public class ClassMain2 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "현대";
        car1.model = "소나타";
        car1.year = 2020;

        Car car2 = new Car();
        car2.brand = "현대";
        car2.model = "아반떼";
        car2.year = 2022;

        Car car3 = new Car();
        car3.brand = "테슬라";
        car3.model = "모델S";
        car3.year = 2024;

        Car[] cars = {car1, car2, car3};

        for (Car car : cars) {
            System.out.println(car.brand + "-" + car.model + "-" + car.year + "년식");
        }

        // 클래스 -> 개발자가 직접 정의하는 커스텀 참조자료형이다!
    }
}
