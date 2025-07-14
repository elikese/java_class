package com.study._27_Interface;

public class Main {
    public static void main(String[] args) {

        /*
        인터페이스 : 자바에서 구현할 수 있는 최상위 추상 레벨
        1. 필드가 없음(상수는 가능)
        => 상태가 존재하지 않음
        2. 메서드 시그니처(함수명, 반환타입, 매개변수)만 정의(모든 메서드가 추상메서드)
        => "어떤 기능을 가진다"라는 명세만 정의
        추상 클래스 : is - a 관계를 가진다 Archer is a GameCharacter
        인터페이스: can - do 관계를 가진다.
        3. Method Area에만 정보가 존재
            - 객체 생성 불가능.
            - 생성자 없음
        4. 다중 상속이 가능
        => 다중상속시 발생하는문제(어떤 부모의 필드/생성자)를 가져와야하나?가 없음

        클래스 : 구현체
        추상클래스 : 구현체 ~ 추상체(중간지대)
        인터페이스 : 추상체

        그럼에도 추상클래스가 계속해서 쓰이는 이유
        => 공통 상태(필드)
        */

        Dog dog = new Dog();
        Bird bird = new Bird();
        Duck duck = new Duck();

        // 다형성(같은 메서드, 다른 동작)
        Animal[] animals = {dog, bird, duck};
        for (Animal animal : animals) {
            animal.sound(); // 각각 다른 소리
        }

        AnimalManager animalManager = new AnimalManager();

        animalManager.testSwimming(duck);
        // animalManager는 duck을 모르지만, Swimmable 인터페이스가 중매하여 작동
        animalManager.testFlying(bird);
        animalManager.testFlying(duck);
        animalManager.makeSound(dog);

        for (Animal animal : animals) {
            // (사이드)캐스팅: 같은 계층의 다른타입으로 변환
            if(animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }

            if(animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
        }

    }
}
