package com.study._27_Interface;

public class Dog implements Animal, Swimmable{

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("강아지가 움직입니다");
    }

    @Override
    public void swim() {
        System.out.println("강아지가 수영합니다");
    }

}
