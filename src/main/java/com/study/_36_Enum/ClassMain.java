package com.study._36_Enum;

public class ClassMain {
    
    public static int discount(ClassGrade classGrade, int price) {
        int discountPercent = 0;

        if (classGrade == ClassGrade.BASIC) {
            discountPercent = ClassGrade.BASIC.getDiscountRate();
        } else if (classGrade == ClassGrade.GOLD) {
            discountPercent = 20;
        } else if (classGrade == ClassGrade.DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인X");
            return 0;
        }

        return price * discountPercent / 100;
    }
    
    public static void main(String[] args) {
        int price = 10000;


        // 타입 안전성 확보 : 중복되는 클래스는 존재하지 않으니까
        int basic = discount(ClassGrade.BASIC, price);
        int gold = discount(ClassGrade.GOLD, price);
        int diamond = discount(ClassGrade.DIAMOND, price);

        System.out.println("BASIC 등급의 할인 금액: " + basic);
        System.out.println("GOLD 등급의 할인 금액: " + gold);
        System.out.println("DIAMOND 등급의 할인 금액: " + diamond);

        // 컴파일 오류 발생 (타입 안전성)
        // int invalid = discountService.discount("INVALID", price);

        // 인스턴스 생성 불가 (컴파일 오류)
        // ClassGrade myGrade = new ClassGrade();
    }
    
    
}
