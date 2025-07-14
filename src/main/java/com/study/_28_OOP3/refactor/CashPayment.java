package com.study._28_OOP3.refactor;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(int amount) {
        System.out.println("=== 현금 결제 처리 ===");
        System.out.println("현금 " + amount + "원 수령");
        System.out.println("현금 영수증 발행");
        System.out.println(amount + "원 현금 결제 완료");
        return true;
    }

    @Override
    public String getPaymentName() {
        return "현금";
    }
}
