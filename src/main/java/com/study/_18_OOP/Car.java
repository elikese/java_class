package com.study._18_OOP;

public class Car {
    int speed;
    boolean engineOn;
    // boolean -> 초기화안하고 선언만 했을때(기본값:false)

    void engineStart() {
        engineOn = true;
        System.out.println("자동차 시동을 켭니다");
    }

    void engineStop() {
        engineOn = false;
        speed = 0; // 시동 끄면 속도도 0
        System.out.println("자동차 시동을 끕니다");
    }

    void accelerate() {
        if (engineOn) {
            speed += 10;
            System.out.println("자동차 속도:" + speed + "km/h");
        } else {
            System.out.println("시동을 먼저 켜주세요!");
        }
    }

    void brake() {
        if (speed > 0) {
            speed -= 10;
            System.out.println("자동차 속도:" + speed + "km/h");
        } else {
            System.out.println("이미 정지 상태입니다");
        }
    }

    void showStatus() {
        System.out.println("자동차 상태 확인");
        if (engineOn) {
            System.out.println("자동차 시동 ON, 속도:" + speed + "km/h");
        } else {
            System.out.println("자동차 시동 OFF");
        }
    }

}
