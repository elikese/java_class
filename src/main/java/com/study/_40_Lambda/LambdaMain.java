package com.study._40_Lambda;

public class LambdaMain {
    public static void main(String[] args) {
        /*
         *
         *
         * 문제 상황:
         * - 메서드를 객체처럼 다루고 싶다!(FP)
         *
         * - 하지만, 자바는 메서드만 따로 존재 할 수 없음
         * - 간단한 기능도 클래스나 익명클래스 필요 → 코드 장황
         *
         * 진화 과정:
         * 익명클래스 → 함수형 인터페이스 → 람다 → 메서드 참조
         */

        // 익명클래스로 구현
        System.out.println("--- 익명클래스 시절 ---");

        Calculator add = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;  // 핵심 로직은 이 한 줄뿐!
            }
        };

        Calculator multi = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;  // 역시 핵심은 한 줄
            }
        };

        System.out.println("익명클래스 덧셈: " + add.calculate(10, 5));
        System.out.println("익명클래스 곱셈: " + multi.calculate(10, 5));

        /*
         * 문제점 분석:
         * - 실제 로직: a + b (3글자)
         * - 필요한 문법적 코드: new Calculator() { @Override ... } (수십 글자)
         * - 핵심보다 부수적인 코드가 압도적으로 많음!
         */

        /*

         * 기본 형태: (매개변수1, 매개변수2...) -> 실행부
         *
         * 구성요소:
         * - (매개변수목록): 함수형 인터페이스 메서드의 매개변수
         * - ->: 람다 연산자 (화살표 연산자)
         * - 실행부: 메서드의 구현 내용
         *
         * 생략 규칙들:
         * 1. 타입 추론: (int a, int b) → (a, b)
         * 2. 단일 표현식: { return a + b; } → a + b
         * 3. 단일 매개변수: (x) → x (괄호 생략)

         */

        // 람다로 동일한 기능을 간결하게 구현
        Calculator lambdaAdd = (int a, int b) -> {
            return a + b;
        };

        Calculator lambdaMulti = (int a, int b) -> {
            return a * b;
        };

        // 람다 문법 최적화 적용
        Calculator lambdaAdd2 = (a, b) -> a + b;     // 타입 추론 + 단일 표현식
        Calculator lambdaMulti2 = (a, b) -> a * b;   // 타입 추론 + 단일 표현식

        /*
         * [필기] 람다의 본질 이해
         *
         * 람다는 익명 함수가 아니라 "익명 객체"!
         * - 함수형 인터페이스를 구현한 익명 클래스의 인스턴스
         * - 컴파일러가 람다를 익명 클래스로 변환해줌
         * - 메모리에는 여전히 객체로 존재
         *
         * 따라서:
         * - 변수에 저장 가능: Calculator calc = (a, b) -> a + b;
         * - 메서드에 전달 가능: method(람다)
         * - 메서드에서 반환 가능: return 람다;
         */

        // 람다는 변수에 저장하고 재사용가능(객체니까)
        Calculator reusableCalculator = (a, b) -> a + b;
        System.out.println("재사용 가능한 람다: " + reusableCalculator.calculate(3, 7));
        System.out.println("같은 람다 다시 사용: " + reusableCalculator.calculate(20, 30));

        // default 사용
        Calculator doubled = reusableCalculator.doubleResult();
        System.out.println(doubled.calculate(3,4));

        Calculator chained = reusableCalculator.nestedCalc((a,b) -> a * b);
        int result = chained.calculate(3, 7); // (3+7) * 7
        System.out.println(result);

    }
}
