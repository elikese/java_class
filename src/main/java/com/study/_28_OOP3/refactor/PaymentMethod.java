package com.study._28_OOP3.refactor;

public interface PaymentMethod {
    /*
     * 결제 처리 메서드
     * - 모든 결제 수단이 구현해야 하는 핵심 기능
     * - 결제 성공시 true, 실패시 false 반환
     */
    boolean pay(int amount);

    /*
     * 결제 수단 이름 반환
     * - 로그, 영수증 등에서 사용
     */
    String getPaymentName();
}
