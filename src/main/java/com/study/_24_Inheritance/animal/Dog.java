package com.study._24_Inheritance.animal;

public class Dog extends Animal{
    private String breed;

    // 기본 생성자
    public Dog() {
        super();  // Animal의 기본 생성자 호출
        this.breed = "믹스";
    }

    // 매개변수 생성자
    public Dog(String name, int age, String breed) {
        super(name, age);  // Animal의 매개변수 생성자 호출
        this.breed = breed;
    }

    public void eatWithTail() {
        super.eat();  // 부모의 eat() 호출
        System.out.println("꼬리를 흔들며 맛있게 먹습니다!");
    }

    public void showDetailInfo() {
        super.showInfo();  // 부모의 showInfo 호출
        System.out.println("견종: " + breed);
        System.out.println("동물 종류: 개");
    }

    public void bark() {
        System.out.println(name + "가 멍멍 짖습니다!");
    }

}
