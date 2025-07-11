package com.study._24_Inheritance.car;

public class ElectricCar extends Car{

    /*
     * 상속은 extends 키워드로 받는다
     * 자식은 부모의 모든 public, protected로 선언된 필드를 사용할 수 있다.
     * Car의 모든 기능을 물려받고 + 전기차만의 기능 추가
     * move(), openDoor(), showInfo() 자동으로 사용 가능!
     *
     * Heap
     * 자식객체 생성시!
     * [부모필드정보 | 자식필드정보] 같이 생성 됨
     * // 1. 실제로는 구분되어 있진 않는다. -> JVM이 구분해서 읽을 뿐
     * // 2. 부모필드의 private도 메모리에 올라간다!(접근은 안됨)
     *
     * Method Area
     * --부모 클래스--
     * 부모 클래스에 정의 된 메서드 정보(시그니처)
     * 기타 부모 클래스에 대한 정보...
     *
     * --자식 클래스--
     * 자식 클래스에 정의 된 메서드 정보(시그니처)
     * 부모클래스가 누군지 기록
     * 기타 자식 클래스에 대한 정보...
     *
     */

    private int batteryLevel;

    // 기본 생성자
    /*
     * super() - 부모 생성자 호출
     *
     * 1. Heap에 객체 메모리 할당 [brand | batteryLevel]
     *
     * 2. super() 호출로 Car 생성자 먼저 실행 → brand 초기화
     * 3. 이후에 ElectricCar 생성자 실행 → batteryLevel 초기화
     *
     * 제약: 자식 생성자 첫 줄에는 반드시 super() 호출 (생략시 자동 추가)
     */
    public ElectricCar() {
        super();  // 부모의 기본 생성자 호출 (기본 생성자는 생략 가능)
        System.out.println("ElectricCar 생성자 호출");
        this.batteryLevel = 100;
    }


    // 매개변수 있는 생성자
    public ElectricCar(String brand) {
        super(brand);  // 부모의 매개변수 생성자 호출 (생략시, 기본생성자(super()) 호출됨)
        System.out.println("ElectricCar 생성자 호출: " + brand);
        this.batteryLevel = 100;
    }

    /*
     * this => 현재 Heap 객체 자신의 주소
     * super. = 부모의 메서드나 필드 호출
     * super 키워드의 메모리적 의미:
     *
     * super는 객체 참조가 아님
     * JVM에게
     * super.필드 => heap영역에서 부모 영역만 탐색해서 읽어라
     * super.메서드() => 메서드영역에서 자식클래스말고 부모클래스기준으로 찾아서 호출해라
     */
    public void moveWithInfo() {
        // 부모의 기본 move() + 추가 정보
        super.move();  // 부모의 "차를 이동합니다." 실행
        System.out.println("배터리 잔량: " + batteryLevel + "%");
    }

    public void showDetailInfo() {
        super.showInfo();  // 부모의 showInfo() 먼저 실행
        System.out.println("배터리: " + batteryLevel + "%");
        System.out.println("차종: 전기차");
    }

    // 전기차만의 고유 메서드
    public void charge() {
        System.out.println("충전합니다. 배터리: " + batteryLevel + "% → 100%");
        this.batteryLevel = 100;
    }
}
