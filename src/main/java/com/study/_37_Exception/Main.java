package com.study._37_Exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 이메일 검증 프로그램 ===");
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.nextLine();


        // TODO: try-catch로 이메일 검증하기
        // 검증 조건:
        // - email이 null이면 InvalidEmailException
        // - email이 빈 문자열이면 InvalidEmailException
        // - email에 @가 없으면 InvalidEmailException
        // - 정상이면 "유효한 이메일입니다: " + email 출력

        try {
            // 이메일 검증 로직
            if (email == null) {
                throw new InvalidEmailException("이메일이 null입니다");
            }

            if (email.trim().isEmpty()) {
                throw new InvalidEmailException("이메일이 비어있습니다");
            }

            if (!email.contains("@")) {
                throw new InvalidEmailException("이메일에 @가 없습니다");
            }

            // 정상 처리
            System.out.println("유효한 이메일입니다: " + email);

        } catch (InvalidEmailException e) {
            System.out.println("오류: " + e.getMessage());
        }

        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }

}
