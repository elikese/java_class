package com.study._40_Lambda;

//람다식은 단일 메소드만 가지는 인터페이스 (=>함수형 인터페이스)
//구현해야 할 메소드가 하나만 정의된 인터페이스

//@FunctionalInterface 어노테이션을 사용하면
//컴파일 시에 컴파일러가 단일 메소드인지 확인
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);


    /*
     * 인터페이스의 default 메서드
     *
     * 인터페이스는 원래 추상 메서드만 가능. 추상화만 생각하면 기존 기능으로도 충분했음
     *
     * - 자바 8부터 함수형 지원. 람다 도입.
     * - 람다는 인터페이스를 기반으로 한 함수형 인터페이스...
     * - 인터페이스도 이젠 '일부 기능'을 직접 구현해야 할 필요가 생김
     */

    default Calculator doubleResult() {
        return (a, b) -> this.calculate(a, b) * 2;
    }

    default Calculator nestedCalc(Calculator after) {
        return (a, b) -> {
            int result1 = this.calculate(a, b);  // 첫 번째 계산

            return after.calculate(result1, b);  // 결과와 b를 두 번째 계산에 넘김
        };
    }

}
