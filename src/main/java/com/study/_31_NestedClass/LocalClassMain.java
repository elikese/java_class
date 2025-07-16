package com.study._31_NestedClass;

public class LocalClassMain {
    // 지역 클래스
    /*
     * - 메서드 내부에서 정의됨
     * - 해당 메서드에서만 사용 가능
     * - 바깥 클래스 멤버 + 지역 변수 접근 가능
     */
    public static void main(String[] args) {

    }

    public static void printTotal(int a, int b) {

        // 여기에! 메서드 안에 클래스를 하나 정의할 거예요
        // 이걸 지역 클래스(Local Class)라고 부릅니다
        class Calculator {
            int add(int x, int y) {
                return x + y;
            }
        }

        // 지역 클래스는 이 메서드 안에서만 쓸 수 있어요
        Calculator calc = new Calculator();
        int result = calc.add(a, b);
        System.out.println("합계: " + result);
    }

    // 왜 쓸까? 이제 안씀
    // 자바에서는 메서드가 클래스없이 단독으로 존재 할 수 없음(너무 OOP스러워서)
    // 메서드안에 메서드를 정의해서 쓰고 싶다!(OOP가 아니라 FP의 특징)
    // 못쓰니까 지역클래스라는 임시움막을 만들어서 어떻게든 써보려고 온몸비틀기를 한 것.
    
    // 람다가 탄생하고나서 -> 사실상 안쓰이는 문법


}
