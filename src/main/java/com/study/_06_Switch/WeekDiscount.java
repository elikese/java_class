package com.study._06_Switch;

public class WeekDiscount {
    public static void main(String[] args) {
        String dayOfWeek = "금요일";
        int basePrice = 10000;
        int discountRate;
        String eventMessage;

        // 요일별 할인율 결정
        switch (dayOfWeek) {
            case "월요일":
                discountRate = 10;
                eventMessage = "월요일 블루데이 할인!";
                break;
            case "화요일":
            case "수요일":
            case "목요일":
                discountRate = 5;
                eventMessage = "평일 할인 혜택!";
                break;
            case "금요일":
                discountRate = 15;
                eventMessage = "불금 특별 할인!";
                break;
            case "토요일":
            case "일요일":
                discountRate = 20;
                eventMessage = "주말 대박 할인!";
                break;
            default:
                discountRate = 0;
                eventMessage = "할인 없음";
                System.out.println("올바른 요일을 입력해주세요.");
        }

        // 할인된 가격 계산
        int discountAmount = basePrice * discountRate / 100;
        int finalPrice = basePrice - discountAmount;

        System.out.println("=== 할인 정보 ===");
        System.out.println("오늘: " + dayOfWeek);
        System.out.println("이벤트: " + eventMessage);
        System.out.println("정가: " + basePrice + "원");
        System.out.println("할인율: " + discountRate + "%");
        System.out.println("할인금액: " + discountAmount + "원");
        System.out.println("최종가격: " + finalPrice + "원");
    }
}
