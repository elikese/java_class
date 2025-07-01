package com.study._07_Switch;

public class Popcorn2 {
    public static void main(String[] args) {
        String size = "Large";
        int basePrice = 3000;

        int finalPrice = switch (size) {
            case "Small", "S" -> basePrice;
            case "Medium", "M" -> basePrice + 1000;
            case "Large", "L" -> basePrice + 2000;
            case "Jumbo", "XL" -> basePrice + 3500;
            default -> {
                System.out.println("잘못된 사이즈입니다. Small로 처리합니다.");
                yield basePrice;
            }
        };

        String description = switch (size) {
            case "Small", "S" -> "혼자 보기 딱 좋은 사이즈";
            case "Medium", "M" -> "커플이 나눠먹기 좋은 사이즈";
            case "Large", "L" -> "가족용 대용량 사이즈";
            case "Jumbo", "XL" -> "무제한 리필 가능한 초대형";
            default -> "기본 사이즈로 처리";
        };

        // 사이즈 보정
        if (!(size.equals("Small") || size.equals("S") || size.equals("Medium") || size.equals("M") ||
                size.equals("Large") || size.equals("L") || size.equals("Jumbo") || size.equals("XL"))) {
            size = "Small";
        }

        System.out.println("=== 팝콘 주문 정보 ===");
        System.out.println("사이즈: " + size);
        System.out.println("설명: " + description);
        System.out.println("가격: " + finalPrice + "원");
    }
}
