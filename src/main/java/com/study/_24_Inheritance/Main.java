package com.study._24_Inheritance;

public class Main {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();

        // 부모의 메서드 사용
        gasCar.move();
        electricCar.move();
        
        gasCar.openDoor();
        electricCar.openDoor();

        // 자식에게만 있는 메서드 사용
        gasCar.fillGas();
        electricCar.charge();
    }
}
