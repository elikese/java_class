package com.study._27_Interface;

public class AnimalManager {

    // 인터페이스 타입으로 매개변수를 받는다.
    // 결합도 : 클래스간의 의존성 척도
    // 결합도가 높다 -> 구체적인 클래스에 의존 -> 유연하지 못하다
    // 결합도가 낮다 -> 인터페이스 / 추상체에 의존 -> 유연하다
    // AnimalManager는 Bird, Dog, Duck의 존재에 대해 몰라도 상관이 없다.
    // -> 구체적인 클래스를 몰라도 작동 가능. -> 결합도가 낮음


    public void makeSound(Animal animal) {
        animal.sound();
    }

//    public void makeSound(Dog dog) {
//        dog.sound();
//    } // dog, duck, bird 다 코드를 추가해야 함.
    /*
    SOLID
    DIP(dependency inversion principle) : 의존성 역전 원칙
    - 추상체는 구체적인것(구현체)에 의존하면 안된다. 구체적인 것(구현체)이 추상체에 의존해야 한다.
    1. 유연한 설계
        (확장성이 높다: 새로운 동물을 추가해도, AnimalManager는 추가 코드 없음
        변경에 대해 안정적: Dog의 내부 구현이 바뀌어도 AnimalManager는 영향이 없다.
    2. 테스트가 용이
     */

    // 의존성 방향 [Dog] -> [Animal] <- [AnimalManager]
    // 구현체 모두 추상체를 의존하는 구조!

    public void testFlying(Flyable flyable) {
        flyable.fly();
    }

    public void testSwimming(Swimmable swimmable) {
        swimmable.swim();
    }
}
