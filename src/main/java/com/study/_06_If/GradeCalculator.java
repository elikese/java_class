package com.study._06_If;

public class GradeCalculator {
    public static void main(String[] args) {

        /*
        학생의 점수를 기반으로 성적 등급을 판정하고, 장학금 대상 여부를 출력하는 프로그램을 작성하세요.

        1. 점수에 따라 **등급(grade)**을 판정합니다:
        점수 범위	등급
        90 이상	A
        80~89	B
        70~79	C
        60~69	D
        60 미만	F

        2. A 또는 B 등급이면 장학금 대상입니다.

        최종출력
        점수: 87
        등급: B
        장학금 대상입니다!
         */
        int score = 87;
        String grade;

        // 성적에 따른 등급 부여
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("점수: " + score);
        System.out.println("등급: " + grade);

        // 추가: 장학금 대상 확인
        if (grade.equals("A") || grade.equals("B")) {
            System.out.println("장학금 대상입니다!");
        } else {
            System.out.println("장학금 대상이 아닙니다.");
        }
    }
}
