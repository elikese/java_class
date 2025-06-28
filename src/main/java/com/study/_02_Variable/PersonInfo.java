package com.study._02_Variable;

public class PersonInfo {
    public static void main(String[] args) {
        // 개인정보를 적절한 타입으로 저장
        String fullName = "김자바";
        int birthYear = 2000;
        double height = 175.8;
        char bloodType = 'A';
        boolean isStudent = true;

        // 정보 출력
        System.out.println("=== 개인정보 ===");
        System.out.println("이름: " + fullName);
        System.out.println("태어난 연도: " + birthYear);
        System.out.println("키: " + height + "cm");
        System.out.println("혈액형: " + bloodType + "형");
        System.out.println("학생 여부: " + isStudent);
    }
}
