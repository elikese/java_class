package com.study._04_String;

public class _02_PersonalNumber {
    public static void main(String[] args) {
        String id = "990226-1234567";

        // 앞 6자리만 추출하기 (생년월일)
        System.out.println("=== 주민번호 앞자리 추출 ===");

        // 방법 1: 직접 자리수 지정
        System.out.println("방법1: " + id.substring(0, 6));

        // 방법 2: '-' 위치를 찾아서 계산
        int dashIndex = id.indexOf("-");
        System.out.println("방법2: " + id.substring(0, dashIndex));

        // 추가 정보 추출
        String birthDate = id.substring(0, dashIndex);
        String gender = id.substring(dashIndex + 1, dashIndex + 2);

        System.out.println("생년월일: " + birthDate);
        System.out.println("성별코드: " + gender);
    }
}
