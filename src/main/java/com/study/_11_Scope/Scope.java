package com.study._11_Scope;

public class Scope {
    public static void main(String[] args) {
        // 스코프 = 변수의 생존 범위
        // 마치 사람이 살 수 있는 지역과 같음
        // 그 지역을 벗어나면 더 이상 존재하지 않음

        int m = 10; // m 생존 시작 - main 메서드 전체에서 사용 가능

        if (true) {
            int x = 20; // x 생존 시작 - if 블록 안에서만 사용 가능
            System.out.println("if m = " + m); // 외부 변수 접근 가능
            System.out.println("if x = " + x); // 내부 변수 접근 가능
        } // x 생존 종료 - 여기서 x는 사라짐!

        // System.out.println("main x = " + x); // 오류! x는 이미 사라졌음
        System.out.println("main m = " + m); // m은 여전히 사용 가능

        // for 문
        for (int i = 0; i < 2; i++) { // i는 for문 안에서만 사용
            System.out.println("for i = " + i);
        } // i 생존 종료

        for (int i = 0; i < 2; i++) { // 새로운 i 변수 (위의 i와 다름!)
            System.out.println("for2 i = " + i);
        } // 이 i도 생존 종료
    }
}
