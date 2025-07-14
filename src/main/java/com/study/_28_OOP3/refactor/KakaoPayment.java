package com.study._28_OOP3.refactor;

public class KakaoPayment implements PaymentMethod{
    private String phoneNumber;

    public KakaoPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("=== 카카오페이 결제 처리 ===");
        System.out.println("휴대폰 번호: " + phoneNumber);
        System.out.println("카카오 서버 연결 중...");
        System.out.println("QR 코드 생성");

        // 실제로는 카카오 API 호출
        if (amount > 0) {
            System.out.println(amount + "원 카카오페이 결제 완료");
            return true;
        } else {
            System.out.println("카카오페이 결제 실패");
            return false;
        }
    }

    @Override
    public String getPaymentName() {
        return "카카오페이";
    }
}
