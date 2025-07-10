package com.study._22_Final;

public class ConstantMain {
    public static void main(String[] args) {
        System.out.println("게임명: " + Constant.GAME_NAME);
        System.out.println("게임 모드: " + Constant.BATTLE_MODE);

        System.out.println("최대 플레이어 수: " + Constant.MAX_PLAYERS);

        int playerLevel = 18;
        int tempPlayerLevel = playerLevel;

        if(++tempPlayerLevel > Constant.MAX_LEVEL) {
            System.out.println("최대 레벨을 이미 도달하였습니다");

        } else {
            playerLevel = ++tempPlayerLevel;
        }

        int price = 100000;
        double totalPrice = 0.0;

        if (price >= 50000) {
            double discountPrice = price * 0.1;
            totalPrice = price - discountPrice;
        }
        // 매직넘버: 나중에 코드를 봤을 때 "이 숫자는 뭐더라?"라고 궁금해지면 그게 매직넘버입니다.

        if (price >= Constant.DISCOUNT_THRESHOLD) {
            double discountPrice = price * Constant.DISCOUNT_RATE;
            totalPrice = price - discountPrice;
        }

    }
}
