package com.study._15_Method;

public class Method {

    // public(접근 제어자): 다른 클래스에서도 호출 가능 (나중에)
    // static: 객체 생성 없이 호출 가능 (나중에)
    // void -> 리턴 없음
    public static void greeting() { // 매개변수 없음, 리턴 없음
        System.out.println("hello");
    }

    public static void main(String[] args) {
        /*
         * 1. 코드 중복 제거 → 한 번만 작성하면 됨
         * 2. 유지보수 편리 → 메서드 하나만 수정하면 모든 곳에 적용
         * 3. 가독성 향상 → 의미 있는 이름으로 기능을 표현
         * 4. 재사용성 → 필요할 때마다 호출 가능
         *
         * 주의 사항) 함수 정의와 호출을 헷갈리지 말자
         */


        System.out.println("함수 호출 전");
        greeting();
        System.out.println("함수 호출 후");
    }
}
