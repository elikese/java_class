package com.study._02_Variable;

public class Variable {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");

        // 변수 쓰는 이유
        // "hello" -> "world!" 변경 -> 노가다

        String greeting; // 변수 선언(빈 박스 만들기)
        greeting = "hello"; // 변수 초기화(빈 박스에 데이터 넣기)
        System.out.println(greeting); // 변수에 저장된 값을 꺼내서 사용
        greeting = "world!"; // 변수 재할당(데이터 바꾸기)
        System.out.println(greeting);

        String academy = "korea IT"; // 한번에 변수 선언 및 초기화

        String city, name; // 여러개 한번에 선언
        city = "부산"; // 초기화
        name = "박화목"; // 초기화
        String dogGreeting = "멍멍", catGreeting = "야옹"; // 한번에 여러변수 선언 및 초기화

        /*
         명명법
            1. 필수규칙
                int 1num;        // 숫자로 시작 불가
                int my num;      // 공백 불가
                int class;       // 자바 예약어 사용 불가
                int if;          // 자바 예약어 사용 불가
            2. 관례
                파스칼 표기법 => LastName => 클래스명, 파일명
                ex) public class Student
                카멜 표기법 => lastName => 변수명, 메소드명
                ex) String studentName

                패키지명: 모두 소문자 (나중에 배움)
                상수명: 모두 대문자 (나중에 배움)
            3. 매너
                의미기 명확한 변수명을 사용하자(길어도 상관없음)
                ex) numberOfItemsCurrentlyInShoppingCart: 현재 쇼핑카트에 담긴 물품들 갯수
                bad ex) a, b, c
                물론 학습중에는 의미가 불명확해도 알아보기만해도 상관없음
                프로젝트(협업)할때는 반드시! 의미가 명확한 변수명 사용 권장
         */

    }
}
