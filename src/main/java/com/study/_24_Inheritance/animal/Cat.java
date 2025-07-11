package com.study._24_Inheritance.animal;

public class Cat {
    /*
        Cat 클래스 만들기 (Animal 상속 + 메서드 오버라이딩)
         * -------------------------------------------
         * 필드:
         *   - private String color  // 털색
         *
         * 생성자:
         *   - 기본 생성자: super() 사용 + color = "회색"
         *   - 매개변수 생성자(String name, int age, String color):
         *       → super(name, age)로 부모 초기화
         *       → color 초기화
         *
         * 메서드 (모두 오버라이딩):
         *   - sleep(): "고양이가 동그랗게 말려서 잠을 잡니다."
         *   - eat(): "고양이가 우아하게 생선을 먹습니다."
         *   - showInfo():
         *       → "이름: ~, 나이: ~살"
         *       → "털색: ~"
         *       → "동물 종류: 고양이"
         *
         * 고유 메서드:
         *   - void meow()
         *       → "{name}가 야옹 웁니다!" 출력

     */
}
