package com.study._04_String;

public class _01_Email {
    public static void main(String[] args) {
        String email = "student@naver.com";

        System.out.println("=== 이메일 분석 ===");
        System.out.println("전체 이메일: " + email);

        // @ 위치 찾기
        int atIndex = email.indexOf("@");

        // 사용자명과 도메인 분리
        String username = email.substring(0, atIndex);

        // 도메인 이름 찾기
        String remain = email.substring(atIndex + 1);
        int dotIndex = remain.indexOf(".");
        String domain = remain.substring(0, dotIndex);

        System.out.println("사용자명: " + username);
        System.out.println("도메인: " + domain);

        // 도메인 분석
        boolean isNaver = domain.contains("naver");
        boolean isGmail = domain.contains("gmail");

        System.out.println("네이버 이메일: " + isNaver);
        System.out.println("지메일: " + isGmail);

        // 이메일 유효성 간단 체크
        boolean hasAt = email.contains("@");
        boolean hasDot = email.contains(".");
        boolean isValid = hasAt && hasDot && email.length() > 5;

        System.out.println("유효한 이메일 형식: " + isValid);
    }
}
