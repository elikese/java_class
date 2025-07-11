package com.study._24_Inheritance.animal;

public class Dog {
    /*
     * [2] Dog 클래스 만들기 (Animal 상속 + super 사용)
     * -------------------------------------------
     * 필드:
     *   - private String breed  // 견종
     *
     * 생성자:
     *   - 기본 생성자: super() 사용하여 부모 기본 생성자 호출,
     *                breed는 "믹스"로 초기화
     *   - 매개변수 생성자(String name, int age, String breed):
     *       → super(name, age)로 부모 초기화
     *       → breed 초기화
     *
     * 메서드:
     *   - void eatWithTail()
     *       → super.eat() 호출 후 "꼬리를 흔들며 맛있게 먹습니다!" 출력
     *
     *   - void showDetailInfo()
     *       → super.showInfo() 호출 후 견종과 "동물 종류: 개" 출력
     *
     *   - void bark()
     *       → "{name}가 멍멍 짖습니다!" 출력
     */
}
