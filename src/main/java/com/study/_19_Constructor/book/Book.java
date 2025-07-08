package com.study._19_Constructor.book;

class Book {
    String title;   // 제목
    String author;  // 저자
    int price;      // 가격

    // 기본 생성자
    Book() {
        this("", "", 0);
    }

    // 제목과 저자만 받는 생성자
    Book(String title, String author) {
        this(title, author, 0);
    }

    // 모든 정보를 받는 생성자
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 가격: " + price + "원");
    }
}
