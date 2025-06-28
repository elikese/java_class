package com.study._04_String;

public class Escape {
    public static void main(String[] args) {
        // 이스케이프 문자
        // \n : 줄바꿈 (new line) - 엔터키와 같은 효과
        // \t : 탭 (tab) - 스페이스바 4칸 효과
        // \\ : 백슬래시 출력
        // \" : 큰따옴표 출력
        // \' : 작은따옴표 출력

        // 여러 줄 출력하는 번거로운 방법
        System.out.println("집에");
        System.out.println("너무");
        System.out.println("가고싶어요");

        System.out.println(""); // 빈 줄

        // \n을 사용한 간편한 방법
        System.out.println("집에\n너무\n가고싶어요");


        // \t로 깔끔한 목록 만들기
        System.out.println("스포츠 스타들:");
        System.out.println("\t손흥민");      // 탭으로 들여쓰기
        System.out.println("\t페이커");
        System.out.println("\t방탄소년단");
        System.out.println("\t블랙핑크");

        // 파일 경로 출력하기 - Windows 스타일
        System.out.println("C:\\Program Files\\Java");
    }
}
