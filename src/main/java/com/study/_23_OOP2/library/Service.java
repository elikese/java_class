package com.study._23_OOP2.library;

public class Service {
    /*

   1. void register(Book book, Library library): 책을 도서관에 등록
      * book.setLibrary(library) 호출: 책이 도서관을 알게 함
      * library.addBook(book) 호출: 도서관이 책을 알게 함
      * "'신데렐라' 책이 중앙도서관에 등록되었습니다." 형태로 출력

   2. void printAllBooks(Library library): 도서관의 모든 책 출력
      * "중앙도서관의 보유 도서 목록:" 출력
      * 책이 없으면: "보유 도서가 없습니다." 출력
      * 책이 있으면: for문으로 순회하며 각 책의 printInfo() 호출

   3. void printLibraryInfo(Library library): 도서관 기본 정보 출력
      * "도서관명: 중앙도서관" 출력
      * "보유 도서 수: 5권" 출력

     */

    // TODO: 책 등록 메서드 (양방향 연관관계 설정)
    public void register(Book book, Library library) {
        book.setLibrary(library);     // 책 → 도서관
        library.addBook(book);        // 도서관 → 책
        System.out.println("'" + book.getTitle() + "' 책이 " + library.getName() + "에 등록되었습니다.");
    }

    // TODO: 도서관의 모든 책 출력 메서드
    public void printAllBooks(Library library) {
        System.out.println("[" + library.getName() + "]의 보유 도서 목록:");

        if (library.getBookCount() == 0) {
            System.out.println("보유 도서가 없습니다.");
        } else {
            for (int i = 0; i < library.getBookCount(); i++) {
                Book book = library.getBook(i);
                book.printInfo();
            }
        }
    }

    // TODO: 도서관 정보 출력 메서드
    public void printLibraryInfo(Library library) {
        System.out.println("도서관명: " + library.getName());
        System.out.println("보유 도서 수: " + library.getBookCount() + "권");
    }
}
