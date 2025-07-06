package com.study._14_MultiArray;

public class Inventory {
    public static void main(String[] args) {
        // 상품 ID에 해당하는 이름 배열
        String[] productNames = {"사과", "바나나", "오렌지", "포도"};

        // {id, 재고, 가격}
        int[][] inventory = {
                {0, 50, 1000},
                {1, 30, 1500},
                {2, 25, 2000},
                {3, 40, 3000}
        };

        // 1. 재고 출력
        System.out.println("=== 재고 현황 ===");
        System.out.println("상품명\t재고\t가격");
        for (int i = 0; i < inventory.length; i++) {
            int id = inventory[i][0];
            int stock = inventory[i][1];
            int price = inventory[i][2];
            System.out.println(productNames[id] + "\t" + stock + "개\t" + price + "원");
        }

        // 2. 총 재고 가치 계산
        int total = 0;
        for (int[] item : inventory) {
            int quantity = item[1];
            int price = item[2];
            total += quantity * price;
        }
        System.out.println("\n총 재고 가치: " + total + "원");

        // 3. 특정 상품 찾기 (예: 바나나)
        String targetName = "바나나";
        int targetId = -1;
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equals(targetName)) {
                targetId = i;
                break;
            }
        }

        for (int[] item : inventory) {
            if (item[0] == targetId) {
                System.out.println("\n[상품 찾기: " + targetName + "]");
                System.out.println("- 재고: " + item[1] + "개");
                System.out.println("- 가격: " + item[2] + "원");
                break;
            }
        }

        // 4. 재고 부족 상품 찾기 (35개 미만)
        System.out.println("\n[재고 부족 상품 찾기 - 35개 미만]");
        boolean hasLow = false;
        for (int[] item : inventory) {
            if (item[1] < 35) {
                System.out.println("- " + productNames[item[0]] + ": " + item[1] + "개");
                hasLow = true;
            }
        }
        if (!hasLow) {
            System.out.println("재고 부족 상품이 없습니다.");
        }

    }
}
