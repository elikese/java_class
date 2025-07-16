package com.study._34_Builder;

public class Main {
    public static void main(String[] args) {
        Member member = new Member.Builder()
                .age(27)
                .email("java@naver.com")
                .name("자바맨")
                .build();

        System.out.println(member.toString());

        // 빌더 방식을 이용했을때의 이점
        //1. 가독성이 높아짐
        //2. 메서드 오버로딩을 일일이 다 만들어 주지 않아도 된다.
        //3. 내가 원하는 필드만 초기화 가능하다.
        //4. 매개변수의 순서를 지키지 않아도 된다.
        // -> 필드가 8 ~ 10넘어가면 생성자 만들기가 아득해짐 -> 빌더도입

    }
}
