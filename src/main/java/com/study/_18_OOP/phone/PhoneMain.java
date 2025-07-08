package com.study._18_OOP.phone;

public class PhoneMain {
    public static void main(String[] args) {
        /**
         * 연습 문제: 휴대폰(Phone) 클래스를 완성하세요!
         *
         * 요구사항:
         * 1. 속성(필드):
         *    - battery (int) : 배터리 잔량 (0~100)
         *    - powerStatus (boolean) : 전원 상태
         *
         * 2. 기능(메서드):
         *    - turnOn() : 전원 켜기 (배터리가 10% 이상일 때만 가능)
         *    - turnOff() : 전원 끄기
         *    - call() : 전화걸기 (전원이 켜져있고 배터리가 5% 이상일 때만 가능, 통화시 배터리 5% 소모)
         *    - charge() : 충전하기 (배터리 20% 충전, 최대 100%)
         *    - checkStatus() : 상태 확인 (전원상태와 배터리 잔량 출력)
         */


        // Phone 테스트
        
        // 1. 객체생성
        // --- 2~6 요구사항은 모두 메서드로 동작
        // 2. 배터리 부족 상태에서 전원 켜기
        // 3. 충전 2번하고 전원 켜기
        // 4. 전화 걸기
        // 5. 상태 확인
        // 6. 전원 끄기

        Phone myPhone = new Phone();

        // 초기 상태 확인
        myPhone.checkStatus();

        // 배터리 부족 상태에서 전원 켜기 시도
        myPhone.turnOn();

        // 충전 후 전원 켜기
        myPhone.charge();
        myPhone.charge();
        myPhone.turnOn();

        // 전화걸기
        myPhone.call();
        myPhone.call();

        // 상태 확인
        myPhone.checkStatus();

        // 전원 끄기
        myPhone.turnOff();
        myPhone.checkStatus();
    }
}
