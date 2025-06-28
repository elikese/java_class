package com.study._03_Operator;

public class GradeCalculator {
    public static void main(String[] args) {
        // 학생 점수
        int mathScore = 85;
        int englishScore = 92;
        int scienceScore = 78;

        /*
        1.  총점과 평균을 계산하여 출력
        2.  평균점수 기준
            90점 이상	A학점
            80~89점	B학점
            70~79점	C학점
            70점 미만	D학점
            해당하는 학점 등급에 true를 출력하고, 나머지는 false로 출력합니다.

            최종출력:
            === 성적표 ===
            수학: 85점
            영어: 92점
            과학: 78점
            총점: 255점
            평균: 85.0점
            A학점 해당: false
            B학점 해당: true
            C학점 해당: false
            D학점 해당: false
         */



        // 총점과 평균 계산
        int totalScore = mathScore + englishScore + scienceScore;
        double average = totalScore / 3.0;  // 실수 나눗셈을 위해 3.0 사용

        // 학점 판정 조건 확인 (90이상 A, 80이상 B, 70이상 C)
        boolean isGradeA = average >= 90;
        boolean isGradeB = average >= 80 && average < 90;
        boolean isGradeC = average >= 70 && average < 80;
        boolean isGradeD = average < 70;

        System.out.println("=== 성적표 ===");
        System.out.println("수학: " + mathScore + "점");
        System.out.println("영어: " + englishScore + "점");
        System.out.println("과학: " + scienceScore + "점");
        System.out.println("총점: " + totalScore + "점");
        System.out.println("평균: " + average + "점");

        // 학점 결과 출력 (각 조건별로)
        System.out.println("A학점 해당: " + isGradeA);
        System.out.println("B학점 해당: " + isGradeB);
        System.out.println("C학점 해당: " + isGradeC);
        System.out.println("D학점 해당: " + isGradeD);
    }

}
