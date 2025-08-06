package com.study._18_OOP;

public class OOPMain2 {
    public static void main(String[] args) {
        Car car = new Car();

        // 진짜 자동차 운전하는 것처럼!
        car.engineStart();
        car.accelerate();
        car.accelerate();
        car.brake();
        car.showStatus();
        car.engineStop();

        /*
        객체의 속성과 기능
            // 세상의 모든 것을 속성(데이터) + 기능(메서드)으로 추상화

        // 자동차 객체:
            // 속성: 속도, 시동상태
            // 기능: 시동걸기(), 가속하기(), 브레이크()

        // 게임 캐릭터 객체:
            // 속성: 레벨, 경험치, HP, 아이템
            // 기능: 이동하기(), 공격하기(), 아이템사용()

        1. 캡슐화 (Encapsulation)
            // 데이터(속성)와 기능(메서드)를 하나의 캡슐에 담기
            // Car 안에 speed, engineOn + engineStart(), accelerate() 등이 모두 포함

        2. 추상화 (Abstraction)
            // 복잡한 내부 구현을 숨기고 간단한 인터페이스만 제공
            // car.engineStart() → 내부에서 어떻게 시동이 걸리는지 몰라도 됨!
            // 여러 객체의 공통속성 및 동작을 상위클래스로 일반화시키는 것(-> 상속과 이어짐)

        3. 상속
            // 기본캐릭터(상위) -> 전직캐릭터(전사), 전직캐릭터(도적)...

        4. 다형성
            // 기본캐릭터.attack() -> 몽둥이를 휘두른다
            // 전사.attack() -> 양손검을 휘두른다
            // 도적.attack() -> 뒤에서 찌른다
            // 같은 attack 메서드인데 다른 동작을 한다 -> 다형성
         */

    }
}
