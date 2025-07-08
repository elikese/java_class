package com.study._18_OOP;

public class OOPMain {
    public static void main(String[] args) {
        /*
        절차 지향 프로그래밍
        메뉴얼 순서대로 진행(자동차 예시)
        시동을 켠다 -> 기어를 넣는다 -> 엑셀을 밟는다

        실행순서 중심, "어떻게?"

        객체 지향 프로그래밍
        자동차에게 출발하라고 명령한다.(내부 과정은 실행 코드에 없음)

        객체간 상호작용 중심 "무엇이?"
         */
        
        // 절차지향 코드

        int speed = 0;
        boolean engineOn = false;

        // 자동차 시동 켜기
        engineOn = true;
        System.out.println("자동차 시동을 켭니다");

        // 속도 증가
        speed += 10;
        System.out.println("자동차 속도:" + speed + "km/h");

        // 속도 증가
        speed += 10;
        System.out.println("자동차 속도:" + speed + "km/h");

        // 속도 감소
        speed -= 10;
        System.out.println("자동차 속도:" + speed + "km/h");

        // 상태 확인
        System.out.println("자동차 상태 확인");
        if (engineOn) {
            System.out.println("자동차 시동 ON, 속도:" + speed + "km/h");
        } else {
            System.out.println("자동차 시동 OFF");
        }

        // 자동차 시동 끄기
        engineOn = false;
        System.out.println("자동차 시동을 끕니다");
    }
}
