package com.study._24_Inheritance.car;

import com.study._24_Inheritance.car.ElectricCar;
import com.study._24_Inheritance.car.GasCar;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 상속과 JVM 메모리 구조 ===");

        /*
         * ElectricCar tesla = new ElectricCar("테슬라");
         *
         * JVM 메모리 동작:
         *
         * 1. Method Area (메서드 영역)
         *    - Car.class 로딩: Car의 메서드 정보, 필드 정의 저장
         *    - ElectricCar.class 로딩: ElectricCar 메서드, super_class 참조 정보
         *    - 각 클래스의 정의 정보가 독립적으로 저장됨
         *
         * 2. Heap (힙 영역) - 핵심!
         *    자식 클래스를 인스턴스화하면, 부모+자식 필드가 모두 포함된
         *    **하나의 객체**가 생성됨
         *
         *    물리적 메모리 구조: [brand(Car) | batteryLevel(ElectricCar)]
         *    → 하나의 연속된 메모리 블록
         *    → 논리적으로는 부모-자식 구조 포함
         *
         * 3. Stack (스택 영역)
         *    - tesla 변수: ElectricCar 타입 참조
         *    - 힙 영역의 객체 주소값 저장
         */

        ElectricCar tesla = new ElectricCar("테슬라");

        /*
         * 메서드 호출과 JVM 동작:
         *
         * tesla.move() 호출 시:
         * 1. Stack의 tesla에서 힙 객체 주소 확인
         * 2. 힙 객체의 실제 타입 확인 (ElectricCar)
         * 3. Method Area에서 ElectricCar.move() 찾아서 실행
         *    (@Override로 재정의되어 있으므로 Car.move()는 실행 안됨)
         *
         * 이것이 바로 "동적 디스패치" - 실제 객체 타입 기준으로 메서드 선택
         */
        System.out.println("--- move() 호출 ---");
        tesla.move();        // ElectricCar의 오버라이딩된 메서드 실행

        /*
         * tesla.openDoor() 호출 시:
         * 1. ElectricCar에서 openDoor() 메서드 탐색
         * 2. 없으면 부모 클래스인 Car에서 탐색
         * 3. Car.openDoor() 찾아서 실행
         *
         * 메서드 탐색 순서: 자식 → 부모 (상속 체인을 따라 올라감)
         */
        System.out.println("--- openDoor() 호출 ---");
        tesla.openDoor();    // Car에서 상속받은 메서드 실행

        /*
         * super 키워드의 JVM 동작:
         *
         * tesla.moveWithInfo() 호출 시:
         * 1. ElectricCar.moveWithInfo() 실행 시작
         * 2. super.move() 만나면 JVM이 특별한 동작:
         *    - 현재 객체(tesla)는 그대로 사용
         *    - 하지만 메서드 탐색을 Car 클래스부터 시작
         *    - Car.move() 강제 호출 (ElectricCar.move() 무시)
         * 3. 나머지 코드 계속 실행
         */
        System.out.println("--- super 키워드 테스트 ---");
        tesla.moveWithInfo();

        System.out.println();

        /*
         * 생성자 호출과 메모리:
         *
         * new ElectricCar("아이오닉") 실행 과정:
         * 1. Heap에 객체를 위한 메모리 공간 할당 (Car + ElectricCar 크기)
         * 2. Car 생성자 먼저 호출 (super() 때문에)
         *    - brand 필드 초기화
         * 3. ElectricCar 생성자 호출
         *    - batteryLevel 필드 초기화
         * 4. 완성된 객체 주소를 Stack의 변수에 저장
         *
         * 결과: Heap에 [brand="아이오닉" | batteryLevel=100] 구조의 객체 생성
         */
        System.out.println("=== 생성자 호출 순서와 메모리 할당 ===");
        ElectricCar ionic = new ElectricCar("아이오닉");

        System.out.println();

    }

}
