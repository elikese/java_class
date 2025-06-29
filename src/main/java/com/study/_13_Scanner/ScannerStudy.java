package com.study._13_Scanner;

import java.util.Scanner;

public class ScannerStudy {
    public static void main(String[] args) {
        // Scanner 객체 생성 (지금은 외우고 사용)
        Scanner scanner = new Scanner(System.in);

        //         다양한 타입의 입력 받기
//        scanner.nextLine();    // 문자열 (한 줄 전체, 공백 포함)
//        scanner.next();        // 문자열 (공백 제외, 단어 하나만)
//        scanner.nextInt();     // 정수
//        scanner.nextDouble();  // 실수


        // 문자열 입력받기
        System.out.print("문자열을 입력하세요>> ");
        String str = scanner.nextLine();  // 한 줄 전체(엔터키 기준)를 읽음
        System.out.println("입력한 문자열: " + str);

        // 정수 입력받기
        System.out.print("정수를 입력하세요>> ");
        int intValue = scanner.nextInt();  // 정수만 읽음
        System.out.println("입력한 정수: " + intValue);

        int age;
        String name;
        //두개 입력받고 출력
        System.out.print("나이를 입력해주세요>> ");
        age = scanner.nextInt();
        scanner.nextLine(); // 엔터키 입력 처리

        System.out.print("이름을 입력해주세요>> ");
        name = scanner.nextLine();

        System.out.println("나이는 " + age + " 이름은 " + name);

    }


}
