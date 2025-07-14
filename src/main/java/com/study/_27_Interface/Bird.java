package com.study._27_Interface;

public class Bird implements Animal, Flyable{

    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void move() {
        System.out.println("참새가 움직입니다");
    }

    @Override
    public void fly() {
        System.out.println("참새가 날아갑니다");
    }
}
