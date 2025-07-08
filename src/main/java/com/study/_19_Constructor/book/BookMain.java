package com.study._19_Constructor.book;

public class BookMain {
    public static void main(String[] args) {

        /*
        1. Book 클래스에는 아래 세 개의 필드를 정의하세요.
       - 제목(title): 문자열
       - 저자(author): 문자열
       - 가격(price): 정수형(int)

        2. 생성자 3개를 정의해 주세요
       - 기본 생성자: 모든 필드를 기본값으로 초기화 (빈 문자열, 0)
       - 제목과 저자만 받는 생성자
       - 제목, 저자, 가격을 모두 받는 생성자

        3. 'displayInfo()' 메서드를 정의하여 다음 형식으로 출력되도록 정의해 주세요

       - 예시 출력: '제목: 자바의정석, 저자: 남궁성, 가격: 30000원'

        4. BookMain에서
        기본생성자, 제목/저자만 받는 생성자, 제목/저자/가격 모두 받는 생성자를
        각각 호출하여 3개의 Book 객체를 만들어 주세요(필드값은 자유롭게 넣어주세요)
        각각 의 객체가 displayInfo를 호출해주세요
         */




        // 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        // 제목과 저자만을 매개변수로 받는 생성자
        Book book2 = new Book("Hello Java", "자바");
        book2.displayInfo();

        // 모든 필드를 매개변수로 받는 생성자
        Book book3 = new Book("자바의정석", "남궁성", 30000);
        book3.displayInfo();
    }
}
