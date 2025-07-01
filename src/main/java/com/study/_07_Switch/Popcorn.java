package com.study._07_Switch;

import java.util.Scanner;

public class Popcorn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매하실 팝콘 사이즈를 입력하세요 >>");
        String size = scanner.nextLine();
        int basePrice = 3000;  // 기본 Small 가격
        int finalPrice;
        String description;

        // 사이즈별 가격 및 설명 결정
        switch (size) {
            case "SMALL":
            case "S":
                finalPrice = basePrice;
                description = "혼자 보기 딱 좋은 사이즈";
                break;
            case "MEDIUM":
            case "M":
                finalPrice = basePrice + 1000;
                description = "커플이 나눠먹기 좋은 사이즈";
                break;
            case "LARGE":
            case "L":
                finalPrice = basePrice + 2000;
                description = "가족용 대용량 사이즈";
                break;
            case "JUMBO":
            case "XL":
                finalPrice = basePrice + 3500;
                description = "무제한 리필 가능한 초대형";
                break;
            default:
                finalPrice = basePrice;
                description = "기본 사이즈로 처리";
                System.out.println("잘못된 사이즈입니다. Small로 처리합니다.");
                size = "Small";
        }

        System.out.println("=== 팝콘 주문 정보 ===");
        System.out.println("사이즈: " + size);
        System.out.println("설명: " + description);
        System.out.println("가격: " + finalPrice + "원");

    }
}
