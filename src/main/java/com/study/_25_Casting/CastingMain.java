package com.study._25_Casting;

import com.study._24_Inheritance.car.Car;
import com.study._24_Inheritance.car.ElectricCar;
import com.study._24_Inheritance.car.GasCar;

public class CastingMain {
    public static void main(String[] args) {
        /*
         * 캐스팅이란?
         * - 타입을 변경하는 것
         * - 업캐스팅: 자식 → 부모 타입으로 변경
         * - 다운캐스팅: 부모 → 자식 타입으로 변경
         */

        System.out.println("=== 1. 업캐스팅 (자식 → 부모) ===");

        /*
         * 업캐스팅 (Upcasting)
         * - 자식 타입을 부모 타입으로 변경
         * - 항상 안전함, 캐스팅 코드 생략 가능
         *
         * JVM 메모리: Heap에 [brand(Car) | batteryLevel(ElectricCar)] 전체 객체 생성
         * 업캐스팅 = 참조 타입만 Car로 제한, 실제 객체는 그대로
         */
        Car car1 = new ElectricCar("아이오닉");  // 자동 업캐스팅
        Car car2 = new GasCar("소나타");

        car1.move();      // JVM이 실제 객체(ElectricCar) 기준으로 메서드 선택
        // car1.charge();    // 컴파일 오류! Car 타입에는 charge() 없음

        System.out.println("\n=== 2. 다운캐스팅 (부모 → 자식) ===");

        /*
         * 다운캐스팅이 필요한 상황:
         * Car 타입으로 참조하고 있지만, 전기차 고유 기능을 사용하고 싶을 때
         */
        Car polyCar = new ElectricCar("EV6");
        // polyCar.charge();  // 불가능!

        /*
         * 다운캐스팅 해결책:
         * - 명시적으로 타입 지정 필요
         * - (자식타입) 부모변수
         *
         * JVM 동작: 런타임에 실제 객체가 ElectricCar인지 검사 후 캐스팅
         */
        ElectricCar downCar = (ElectricCar) polyCar;  // 다운캐스팅
        downCar.charge();  // 이제 가능!

        // 일시적 다운캐스팅
        ((ElectricCar) polyCar).charge();

        System.out.println("\n=== 3. 다운캐스팅의 위험성 ===");

        /*
         * 잘못된 다운캐스팅 - ClassCastException!
         *
         * JVM 메모리 검사:
         * 1. parentCar = new GasCar() → Heap에 [brand(Car) | fuelLevel(GasCar)]
         * 2. (ElectricCar) parentCar 시도
         * 3. JVM: "GasCar 객체를 ElectricCar로 캐스팅? ElectricCar 부분이 없는데?"
         * 4. ClassCastException 발생
         */
        Car parentCar = new GasCar("아반떼");

        try {
            ElectricCar wrongCast = (ElectricCar) parentCar;  // 런타임 오류!
        } catch (ClassCastException e) {
            System.out.println("오류: GasCar를 ElectricCar로 캐스팅 불가!");
        }

        System.out.println("\n=== 4. instanceof - 안전한 다운캐스팅 ===");

        /*
         * instanceof 연산자
         * - 객체가 특정 타입인지 확인
         * - JVM이 실제 객체 타입을 검사해서 true/false 반환
         * - 상속 관계도 고려: 자식 객체는 부모 타입에도 true
         */
        Car[] cars = {
                new ElectricCar("테슬라"),
                new GasCar("제네시스")
        };

        for (Car car : cars) {
            car.move();  // 공통 기능

            /*
             * JVM의 instanceof 검사 과정:
             * 1. car 변수가 참조하는 실제 객체 타입 확인
             * 2. 해당 타입이 ElectricCar이거나 ElectricCar의 자식인가?
             * 3. true면 안전하게 다운캐스팅 가능
             */
            if (car instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) car;  // 안전한 다운캐스팅
                ec.charge();
            } else if (car instanceof GasCar) {
                GasCar gc = (GasCar) car;
                gc.fillGas();
            }
        }

        System.out.println("\n=== 5. instanceof 동작 원리 ===");

        Car tesla = new ElectricCar("모델S");

        /*
         * JVM의 instanceof 판단 기준:
         * "왼쪽 객체가 오른쪽 타입에 대입 가능한가?"
         */
        System.out.println("tesla instanceof ElectricCar: " + (tesla instanceof ElectricCar));  // true
        System.out.println("tesla instanceof Car: " + (tesla instanceof Car));                // true (상속관계)
        System.out.println("tesla instanceof GasCar: " + (tesla instanceof GasCar));          // false


    }

}
