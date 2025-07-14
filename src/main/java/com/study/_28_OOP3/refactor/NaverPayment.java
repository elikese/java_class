package com.study._28_OOP3.refactor;

public class NaverPayment implements PaymentMethod {
    /*
    1. PaymentMethod를 인터페이스를 implements 받아 주세요
    2. 필드 : String email
    3. pay() 구현
        금액이 0보다 클 때:
        "네이버 계정: " + email 출력
        amount + "원 네이버페이 결제 완료" 출력
        true 반환
        금액이 0 이하일 때:
        "네이버페이 결제 실패" 출력
        false 반환
    4. getPaymentName() 메서드 구현:
        "네이버페이" 반환
    5. GoodMain에서 테스트코드 작성해서 실행!
     */


    private String email;

    public NaverPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("=== 네이버페이 결제 처리 ===");
        if (amount > 0) {
            System.out.println("네이버 계정: " + email);
            System.out.println(amount + "원 네이버페이 결제 완료");
            return true;
        } else {
            System.out.println("네이버페이 결제 실패");
            return false;
        }
    }

    @Override
    public String getPaymentName() {
        return "네이버페이";
    }
}
