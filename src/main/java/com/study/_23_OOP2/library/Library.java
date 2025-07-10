package com.study._23_OOP2.library;

public class Library {
    /*
 **필드 (모두 private)**:
   - String name: 도서관 이름
   - Book[] books: 책들을 저장할 배열
   - int bookCount: 현재 보유 책 수
   - static final int MAX_BOOKS = 20: 최대 보유 가능 책 수

 **생성자**:
   - Library(String name)
   - books 배열을 MAX_BOOKS 크기로 초기화
   - bookCount를 0으로 초기화

 **메서드**:
   - void addBook(Book book): 책을 배열에 추가
     * 배열이 가득 찬 경우: "도서관 서가가 가득 참니다..." 메시지 출력 후 return
     * 정상 경우: books[bookCount] 위치에 book 저장, bookCount 증가
     * 중요: book.setLibrary()는 호출하지 않음 (Service에서 처리)
   - String getName(): 도서관 이름 반환
   - int getBookCount(): 현재 보유 책 수 반환
   - Book getBook(int index): 특정 인덱스의 책 반환
     */
    // TODO: private 필드들 선언
    private String name;
    private Book[] books;
    private int bookCount;
    private static final int MAX_BOOKS = 20;  // 최대 20권

    // TODO: 생성자 작성
    public Library(String name) {
        this.name = name;
        this.books = new Book[MAX_BOOKS];
        this.bookCount = 0;
    }

    // TODO: 책 추가 메서드 (배열 크기 체크하기)
    public void addBook(Book book) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("도서관 서가가 가득 참니다. 더 이상 책을 보관할 수 없습니다.");
            return;
        }

        books[bookCount] = book;
        bookCount++;
    }

    // TODO: getter 메서드들
    public String getName() {
        return name;
    }

    public int getBookCount() {
        return bookCount;
    }

    public Book getBook(int index) {
        return books[index];
    }
}
