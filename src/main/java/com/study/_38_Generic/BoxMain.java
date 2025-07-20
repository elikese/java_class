package com.study._38_Generic;

public class BoxMain {
    public static void main(String[] args) {
        /*
         * [필기] 제네릭(Generic) 기초와 활용
         *
         * 1. 제네릭이란?
         *    - 클래스나 메서드에서 사용할 타입을 미리 정하지 않고, 사용할 때 결정하는 기능
         *    - <T>, <K, V> 등의 타입 매개변수를 사용
         *    - 타입 안전성과 코드 재사용성을 동시에 제공
         *
         * 2. 제네릭 클래스 만들기
         *    - class ClassName<T> { ... }
         *    - T는 Type의 약자 (관례적으로 사용)
         *    - 클래스 내부에서 T를 하나의 타입처럼 사용
         *
         * 3. 제네릭 클래스 사용하기
         *    - ClassName<구체적타입> 변수명 = new ClassName<>();
         *    - 다이아몬드 연산자 <> 활용 (타입 추론)
         *
         * 4. 용어 정리
         *    - 타입 매개변수(Type Parameter): <T>에서 T
         *    - 타입 인자(Type Argument): <String>에서 String
         */


        // String 타입 박스
        Box<String> stringBox = new Box<>();
        stringBox.set("안녕하세요");
        String str = stringBox.get(); // 캐스팅 불필요!
        System.out.println("문자열 박스: " + str);

        // Integer 타입 박스
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        Integer num = intBox.get(); // 캐스팅 불필요!
        System.out.println("정수 박스: " + num);

        /*
         * Object를 사용할 경우:
         * - 어떤 타입이든 저장할 수 있지만, 꺼낼 때마다 형변환(casting)이 필요함
         * - 잘못된 형변환 시 런타임 오류(ClassCastException)가 발생할 수 있음
         * - 즉, 타입에 대한 안전성이 보장되지 않음

         * 제네릭(Generic)을 사용할 경우:
         * - 컴파일 시점에 타입을 지정하므로, 형변환 없이 안전하게 사용할 수 있음
         * - 잘못된 타입 사용 시 컴파일 오류 발생 → 더 빠르게 오류를 발견 가능
         * - 코드의 안정성과 가독성을 높여줌
         */
    }
}
