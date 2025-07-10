package com.study._23_OOP2.library;

public class Book {
/*
**필드 (모두 private)**:
   - String title: 책 제목
   - String author: 저자
   - Library library: 소속 도서관 (처음엔 null)

**생성자**:
   - Book(String title, String author)
   - library는 생성자에서 받지 않음 (나중에 등록 과정에서 설정)

**메서드**:
   - void setLibrary(Library library): 도서관 설정
   - String getTitle(): 제목 반환
   - String getAuthor(): 저자 반환
   - Library getLibrary(): 소속 도서관 반환
   - void printInfo(): "제목: 자바의정석, 저자: 남궁성, 도서관: 중앙도서관" 형태로 출력
     (도서관이 null이면 "없음" 출력)
 */
    // TODO: private 필드들 선언 (제목, 저자, 소속 도서관)
    private String title;
    private String author;
    private Library library;  // 연관관계: 한 책은 하나의 도서관에 소속

    // TODO: 생성자 작성 (제목과 저자만 받기)
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // TODO: 도서관 설정 메서드
    public void setLibrary(Library library) {
        this.library = library;
    }

    // TODO: getter 메서드들
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Library getLibrary() {
        return library;
    }

    // TODO: 책 정보 출력 메서드
    public void printInfo() {
        System.out.println("제목: " + title + ", 저자: " + author +
                ", 도서관: " + (library != null ? library.getName() : "없음"));
    }
}
