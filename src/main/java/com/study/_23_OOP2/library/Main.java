package com.study._23_OOP2.library;

public class Main {
    public static void main(String[] args) {
        // TODO: 1단계 - 객체 생성
        System.out.println("=== 1단계: 객체 생성 ===");
        Book b1 = new Book("자바의 정석", "김정석");
        Book b2 = new Book("클린 코드", "김깨끗");
        Book b3 = new Book("이펙티브 자바", "김효과");
        Book b4 = new Book("신데렐라", "김렐라");

        Library library1 = new Library("도서관1");
        Library library2 = new Library("도서관2");

        Service service = new Service();

        // TODO: 2단계 - 책 등록
        System.out.println("\n=== 2단계: 책 등록 ===");
        service.register(b1, library1);   // 자바의 정석 → 중앙도서관
        service.register(b2, library1);   // 클린 코드 → 중앙도서관
        service.register(b3, library2);   // 이펙티브 자바 → IT전문도서관
        service.register(b4, library2);   // 스프링 부트 → IT전문도서관

        // TODO: 3단계 - 도서관별 책 목록 확인
        System.out.println("\n=== 3단계: 도서관 → 책 방향 확인 ===");
        service.printAllBooks(library1);
        System.out.println();
        service.printAllBooks(library2);

        // TODO: 4단계 - 책별 도서관 정보 확인
        System.out.println("\n=== 책 → 도서관 방향 확인 ===");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();
        b4.printInfo();

        // TODO: 5단계 - 도서관 정보 확인
        System.out.println("\n=== 도서관 정보 ===");
        service.printLibraryInfo(library1);
        System.out.println();
        service.printLibraryInfo(library2);

    }
}
