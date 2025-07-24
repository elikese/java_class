package com.study._42_OptionalApi;

import java.util.Optional;

public class UserMain {
    public static void main(String[] args) {
        /*
         * [필기] 객체를 필드로 가지는 객체에서 null 처리하기
         *
         * 기존 방식: 매 단계마다 null 체크 필요 (복잡하고 실수하기 쉬움)
         * Optional 방식: 체이닝을 통해 안전하고 간결하게 처리
         */

        // 사용자와 주소 정보 생성
        User user1 = new User("홍길동", new Address("서울시 강남구"));
        User user2 = new User("김철수", null); // 주소가 없는 경우
        User user3 = null; // 사용자 정보가 없는 경우

        System.out.println("=== 기존 null 체크 방식 ===");

        // user1 처리 (기존 방식)
        if (user1 != null) {
            Address address1 = user1.getAddress();
            if (address1 != null) {
                String street1 = address1.getStreet();
                if (street1 != null) {
                    System.out.println("user1 거리: " + street1);
                } else {
                    System.out.println("user1 거리 정보 없음");
                }
            } else {
                System.out.println("user1 주소 정보 없음");
            }
        } else {
            System.out.println("user1 사용자 정보 없음");
        }

        System.out.println("\n=== Optional 활용 방식 ===");

        /*
         * [필기] orElse vs orElseThrow 선택 기준
         *
         * orElse() 사용 시기:
         * - 값이 없어도 기본값으로 처리 가능한 경우
         * - 사용자에게 표시할 UI 요소 (예: "정보 없음")
         * - 로직이 계속 진행되어야 하는 경우
         *
         * orElseThrow() 사용 시기:
         * - 값이 없으면 시스템 오류인 경우
         * - 비즈니스 로직상 반드시 값이 있어야 하는 경우
         * - 호출자에게 구체적인 오류 정보를 전달해야 하는 경우
         */

        // user1 처리 (Optional 방식)
        String street1 = Optional.ofNullable(user1)
                .map(u -> u.getAddress())
                .map(a -> a.getStreet())
                .orElse("정보 없음");
        System.out.println("user1 거리: " + street1);

        // user2 처리 (Optional 방식)
        String street2 = Optional.ofNullable(user2)
                .map(u -> u.getAddress())
                .map(a -> a.getStreet())
                .orElse("정보 없음");
        System.out.println("user2 거리: " + street2);

        // user3 처리 (Optional 방식)
        String street3 = Optional.ofNullable(user3)
                .map(u -> u.getAddress())
                .map(a -> a.getStreet())
                .orElse("정보 없음");
        System.out.println("user3 거리: " + street3);


        String street2Throw = Optional.ofNullable(user2)
                .map(u -> u.getAddress())
                .map(a -> a.getStreet())
                .orElseThrow(() ->
                        new UserDataException("사용자 '" + user2.getName() + "'의 거리 정보를 찾을 수 없습니다"));
    }
}
