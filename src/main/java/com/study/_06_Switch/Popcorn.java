package com.study._06_Switch;

public class Popcorn {
    public static void main(String[] args) {
        String size = "Large";
        int basePrice = 3000;  // 기본 Small 가격
        int finalPrice;
        String description;

        // 사이즈별 가격 및 설명 결정
        switch (size) {
            case "Small":
            case "S":
                finalPrice = basePrice;
                description = "혼자 보기 딱 좋은 사이즈";
                break;
            case "Medium":
            case "M":
                finalPrice = basePrice + 1000;
                description = "커플이 나눠먹기 좋은 사이즈";
                break;
            case "Large":
            case "L":
                finalPrice = basePrice + 2000;
                description = "가족용 대용량 사이즈";
                break;
            case "Jumbo":
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
