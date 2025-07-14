package com.study._28_OOP3.refactor;

public class PaymentProcessor {
    /*
     * 역할: 결제방법을 받아서 결제 시켜주는 중매 역할
     * 핵심: PaymentMethod 인터페이스에만 의존
     * - 구체적인 결제 수단을 몰라도 됨
     * - 새로운 결제 수단이 추가되어도 코드 변경 불필요
     */

    public boolean processPayment(PaymentMethod paymentMethod, int amount) {
        System.out.println("\n=== 결제 시작 ===");
        System.out.println("결제 수단: " + paymentMethod.getPaymentName());
        System.out.println("결제 금액: " + amount + "원");

        // 다형성! 실제 구현체의 pay() 메서드가 호출됨
        boolean success = paymentMethod.pay(amount);

        if (success) {
            System.out.println("결제가 성공적으로 완료되었습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }

        System.out.println("=== 결제 종료 ===\n");
        return success;
    }

}
