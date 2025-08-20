package com.study._28_OOP3;

import com.study._28_OOP3.refactor.*;

import java.util.Scanner;


public class GoodMain {


    private static PaymentMethod getPaymentMethod(String choice) {
        switch (choice.toUpperCase()) {
            case PaymentMethod.CARD_PAYMENT:
                return new CardPayment("9876543210123456", "김철수");
            case PaymentMethod.CASH_PAYMENT:
                return new CashPayment();
            case PaymentMethod.KAKAO_PAYMENT:
                return new KakaoPayment("010-9876-5432");
            default:
                return new CashPayment();  // 기본값은 현금
        }
    }


    public static void main(String[] args) {
        PaymentMethod card = new CardPayment("1234567890123456", "홍길동");
        PaymentMethod cash = new CashPayment();
        PaymentMethod kakao = new KakaoPayment("010-1234-5678");

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(card, 50000);
        processor.processPayment(cash, 30000);
        processor.processPayment(kakao, 25000);

        Scanner scanner = new Scanner(System.in);
        System.out.print("결제방법을 작성해 주세요 >>");
        String userChoice = scanner.nextLine();
        System.out.print("결제금액을 입력해주세요 >>");
        int userAmount = scanner.nextInt();
        PaymentMethod selectedPayment = getPaymentMethod(userChoice);
        processor.processPayment(selectedPayment, userAmount);
    }
}
