package com.study._24_Inheritance.animal;

public class Cat extends Animal{
    /*
        Cat 클래스 만들기
         * -------------------------------------------
         * 1. 상속 - Animal
         * 2. 필드 - private String color
         * 3. 생성자
         * - 기본 생성자
         *   → 부모 생성자를 호출하여 Animal의 기본 생성자를 호출하세요.
         *   → color 필드는 "회색"으로 초기화합니다.
         *
         * - 매개변수 생성자(String name, int age, String color)
         *   → 부모 생성자를 호출하여 Animal 클래스의 모든 필드를 초기화합니다.
         *   → 전달받은 color 값으로 자신의 color 필드를 초기화합니다.
         *
         * 4. 메서드 오버라이딩
         * 다음 메서드들을 @Override 어노테이션을 사용해 재정의하세요.
         * - void eat()
         *   → "고양이가 우아하게 생선을 먹습니다."라는 문장을 출력합니다.
         * - void showInfo()
         *   → 아래와 같은 형식으로 고양이 정보를 출력합니다.
         *     이름: ~, 나이: ~살 털색: ~색 동물 종류: 고양이
         *
         * 5. 고양이 전용 메서드
         * - void meow()
         *   → "{name}가 야옹 웁니다!" 형식의 문장을 출력하세요.

     */

    private String color;

    // 기본 생성자
    public Cat() {
        super();  // Animal 기본 생성자 호출
        this.color = "회색";
    }

    // 매개변수 생성자
    public Cat(String name, int age, String color) {
        super(name, age);  // Animal 매개변수 생성자 호출
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("고양이가 우아하게 생선을 먹습니다.");
    }

    @Override
    public void showInfo() {
        System.out.println("이름: " + name + ", 나이: " + age + "살");
        System.out.println("털색: " + color);
        System.out.println("동물 종류: 고양이");
    }

    public void meow() {
        System.out.println(name + "가 야옹 웁니다!");
    }

}
