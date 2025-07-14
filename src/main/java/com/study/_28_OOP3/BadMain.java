package com.study._28_OOP3;

public class BadMain {
    // 다형성
    // 같은 메서드이지만, 다른 동작
    // 인터페이스를 이식받으면서, 추상메서드를 상속받으면서
    // -> 강제로 다형성이 구현(컴파일 에러가 발생하니까)
    // 인터페이스를 도입한다
    // 강제로 다형성을 구현하겠다.
    // 부가적으로 강제로 추상체를 의존하는 설계를 하겠다.
    
    // 구체적인 구현체 코드
    public static void processPayment(String paymentType, int amount) {
        if (paymentType.equals("CARD")) {
            System.out.println("카드 결제 처리 중...");
            System.out.println(amount + "원 카드 결제 완료");

        } else if (paymentType.equals("CASH")) {
            System.out.println("현금 결제 처리 중...");
            System.out.println("현금 영수증 발행");
            System.out.println(amount + "원 현금 결제 완료");

        } else if (paymentType.equals("KAKAO_PAY")) {
            System.out.println("카카오페이 결제 처리 중...");
            System.out.println("카카오 서버 연결");
            System.out.println(amount + "원 카카오페이 결제 완료");

        } else {
            System.out.println("지원하지 않는 결제 수단입니다");
        }
    }
    
    public static void main(String[] args) {
        processPayment("CARD", 20000);
    }
}
