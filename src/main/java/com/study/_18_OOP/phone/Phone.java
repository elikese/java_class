package com.study._18_OOP.phone;

public class Phone {
    /**
     * 연습 문제: 휴대폰(Phone) 클래스를 완성하세요!
     *
     * 요구사항:
     * 1. 속성(필드):
     *    - battery (int) : 배터리 잔량 (0~100)
     *    - powerStatus (boolean) : 전원 상태 - true: 전원켜진상태 / false: 전원꺼진상태
     *
     *
     * 2. 기능(메서드):
     *    - turnOn() : 전원 켜기 (배터리가 10% 이상일 때만 가능)
     *    - turnOff() : 전원 끄기
     *    - call() : 전화걸기 (전원이 켜져있고 배터리가 5% 이상일 때만 가능, 통화시 배터리 5% 소모)
     *    - charge() : 충전하기 (배터리 20% 충전, 최대 100%)
     *    - checkStatus() : 상태 확인 (전원상태와 배터리 잔량 출력)
     */
    // 속성(필드) 선언
    int battery;
    boolean powerStatus;

    // 전원 켜기
    void turnOn() {
        if (battery >= 10) {
            powerStatus = true;
            System.out.println("휴대폰 전원을 켭니다.");
        } else {
            System.out.println("배터리가 부족합니다. (최소 10% 필요)");
        }
    }

    // 전원 끄기
    void turnOff() {
        powerStatus = false;
        System.out.println("휴대폰 전원을 끕니다.");
    }

    // 전화걸기
    void call() {
        if (powerStatus && battery >= 5) {
            battery -= 5;
            System.out.println("전화를 겁니다. 배터리: " + battery + "%");
        } else if (!powerStatus) {
            System.out.println("전원을 먼저 켜주세요!");
        } else {
            System.out.println("배터리가 부족합니다. (최소 5% 필요)");
        }
    }

    // 충전하기
    void charge() {
        battery += 20;
        if (battery > 100) {
            battery = 100;
        }
        System.out.println("배터리를 20% 충전했습니다. 현재 배터리: " + battery + "%");
    }

    // 상태 확인
    void checkStatus() {
        System.out.print("휴대폰 상태: ");
        if (powerStatus) {
            System.out.println("전원 ON, 배터리: " + battery + "%");
        } else {
            System.out.println("전원 OFF, 배터리: " + battery + "%");
        }
    }



}
