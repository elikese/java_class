package com.study._20_Access.bottle;

public class WaterBottleMain {
    public static void main(String[] args) {
        /*
         * 1. WaterBottle 클래스 생성
         *    - private int currentWater 필드 선언 (현재 물의 양)
         *    - public 생성자: WaterBottle(int currentWater) → 초기 물의 양을 설정
         *
         * 2. 메서드 구현(모든 메서드는 public으로 구현)
         *    - void fill(int amount)
         *      → 0보다 큰 양만 허용, 총량은 1000ml를 넘지 않아야 함
         *      → 유효하면 currentWater에 더하고, "물을 채웠습니다" 메시지 출력
         *      → 조건 위반 시, 경고 메시지 출력
         *
         *    - void drink(int amount)
         *      → 0보다 큰 양만 허용, 현재 물의 양보다 많은 양은 마실 수 없음
         *      → 유효하면 currentWater에서 차감하고, "물을 마셨습니다" 메시지 출력
         *      → 조건 위반 시, 경고 메시지 출력
         *
         *    - int getCurrentWater()
         *      → 현재 물의 양을 반환
         *
         * 3. 아래의 흐름이 정상적으로 실행되도록 구현
         *
         */

        WaterBottle waterBottle = new WaterBottle(0);

        waterBottle.fill(500);
        waterBottle.drink(200);
        waterBottle.drink(400);
        waterBottle.fill(800);
        waterBottle.drink(1200);

        System.out.println(waterBottle.getCurrentWater());
    }
}
