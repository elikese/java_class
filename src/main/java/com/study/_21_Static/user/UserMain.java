package com.study._21_Static.user;

public class UserMain {
    public static void main(String[] args) {

        /*
        static 메서드 특징
        - 인스턴스 상태(this)와 무관함
        - 객체 생성없이 바로 호출 가능

        => static 메서드는 주로 유틸성 함수로 자주 쓰인다.
         */

        User user = new User("김철수", "991011-1234567");

        User.makeMaskingToUser(user);

        System.out.println("user의 이름: " + user.getName());
        System.out.println("user의 주민번호: " + user.getPersonalNumber());

    }
}
