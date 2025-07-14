package com.study._28_OOP3.refactor;

public class CardPayment implements PaymentMethod{
    private String cardNumber;
    private String cardName; // 소유자 이름

    public CardPayment(String cardNumber, String cardName) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("카드 소유자: " + cardName);
        System.out.println("카드 번호: " + cardNumber);
        System.out.println("은행 승인 요청 중...");

        // 실제로는 은행 API 호출
        if (amount > 0 && amount <= 1000000) {
            System.out.println(amount + "원 카드 결제 승인됨");
            return true;
        } else {
            System.out.println("카드 결제 실패: 유효하지 않은 금액");
            return false;
        }
    }

    @Override
    public String getPaymentName() {
        return "신용카드";
    }
}
