package com.study._20_Access.bottle;

public class WaterBottle {
    private int currentWater;

    public WaterBottle (int currentWater) {
        this.currentWater = currentWater;
    }

    public void fill(int amount) {
        if(amount > 0 && currentWater + amount <= 1000) {
            currentWater += amount;
            System.out.println(amount + "의 양만큼 물병에 물을 채웠습니다. 현재 물의 양: " + currentWater);
        } else {
            System.out.println("0이상의 물을 채우지 않거나 물병의 양을 초과할 수 없습니다. 현재 물의 양: " + currentWater);
        }
    }

    public void drink(int amount) {
        if(amount > 0 && amount <= currentWater) {
            currentWater -= amount;
            System.out.println(amount + "의 양만큼 물병에 물을 마셨습니다. 현재 물의 양: " + currentWater);
        } else {
            System.out.println("0이하의 물을 마시거나 현재 물병의 양을 초과하여 마실 수 없습니다. 현재 물의 양: " + currentWater);
        }
    }

    public int getCurrentWater() {
        return currentWater;
    }
}
