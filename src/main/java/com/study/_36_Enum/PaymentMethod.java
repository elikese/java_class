package com.study._36_Enum;

public enum PaymentMethod {
    /*
    결제 수단별 수수료 시스템을 만들어보세요.

    기본 조건:
    결제 수단은 현금, 카드, 모바일 3가지입니다
    각 결제 수단별 수수료율은 다음과 같습니다:
    현금: 0%
    카드: 2%
    모바일: 1%
    구현 요구사항:
    PaymentMethod라는 이름의 enum을 만드세요
    각 결제 수단은 수수료율과 한글 표시명을 가져야 합니다
    결제 금액을 입력받아 수수료를 계산하는 메서드를 만드세요
    결제 수단의 한글 이름을 반환하는 메서드를 만드세요

    */

    CASH(0, "현금"),
    CARD(2, "카드"),
    MOBILE(1, "모바일");

    private final int feeRate;
    private final String displayName;

    PaymentMethod(int feeRate, String displayName) {
        this.feeRate = feeRate;
        this.displayName = displayName;
    }

    public int calculateFee(int amount) {
        return amount * feeRate / 100;
    }

    public String getDisplayName() {
        return displayName;
    }

}
