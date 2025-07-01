package com.study._07_Switch;

import java.util.Scanner;

public class WeekDiscount {
    public static void main(String[] args) {

        // 요일 할인 출력
        // scanner를 통해서 요일을 입력 받습니다
        // switch 문을 사용하여 요일마다 다른 할인율을 적용합니다
        // 월-10% , 화/수/목 - 5%, 금 - 15%, 토/일 - 20%, 그외 - 0%,

//        오늘: 월요일
//        이벤트: 월요일 할인!
//        정가: 10000원
//        할인율: 10%
//        할인금액: 1000원
//        최종가격: 9000원

        Scanner scanner = new Scanner(System.in);
        System.out.println("오늘은 무슨 요일인지 입력해주세요 >>");
        String dayOfWeek = scanner.nextLine();

        int basePrice = 10000;
        int discountRate;

        dayOfWeek = dayOfWeek.endsWith("요일") ? dayOfWeek : dayOfWeek + "요일";

        // 요일별 할인율 결정
        switch (dayOfWeek) {
            case "월요일":
                discountRate = 10;
                break;
            case "화요일":
            case "수요일":
            case "목요일":
                discountRate = 5;
                break;
            case "금요일":
                discountRate = 15;
                break;
            case "토요일":
            case "일요일":
                discountRate = 20;
                break;
            default:
                discountRate = 0;
                System.out.println("올바른 요일을 입력해주세요.");
        }

        // 할인된 가격 계산
        int discountAmount = basePrice * discountRate / 100;
        int finalPrice = basePrice - discountAmount;

        System.out.println("=== 할인 정보 ===");
        System.out.println("오늘: " + dayOfWeek);
        System.out.println("정가: " + basePrice + "원");
        System.out.println("할인율: " + discountRate + "%");
        System.out.println("할인금액: " + discountAmount + "원");
        System.out.println("최종가격: " + finalPrice + "원");

        scanner.close();
    }
}
