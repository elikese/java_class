package com.study._29_Object;

public class Car {
    /*
     * TODO 1: toString() 메서드를 재정의하세요.
     * 인텔리제이가 제공하는 자동 작성을 사용하세요
     */

    /*
     * TODO 2: equals() 메서드를 재정의하세요.
     * 인텔리제이가 제공하는 자동 작성을 사용하세요
     * - 같은 Car인지 판단 기준: model과 year가 모두 같을 때
     */

    private String model;
    private String color;
    private int year;

    public Car(String model, String color, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;

        return year == car.year && model.equals(car.model);
    }

}
