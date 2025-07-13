package com.study._24_Inheritance.animal;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이", 3, "푸들");
        dog.eatWithTail();
        dog.bark();
        dog.showDetailInfo();

        System.out.println();

        Cat cat = new Cat("나비", 2, "검은색");
        cat.eat();
        cat.sleep();
        cat.meow();
        cat.showInfo();
    }
}
