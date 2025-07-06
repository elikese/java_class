package com.study._15_Method;

public class StudentScore {

    public static int calculateTotal(int korean, int english, int math) {
        return korean + english + math;
    }

    public static double calculateAverage(int totalScore) {
        return (double) totalScore / 3;  // 3.0으로 나누어야 소수점 계산됨
    }

    public static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void printStudentInfo(String name, int korean, int english, int math) {
        System.out.println("===== " + name + " 학생 =====");
        System.out.println("국어: " + korean + "점");
        System.out.println("영어: " + english + "점");
        System.out.println("수학: " + math + "점");

        // 다른 메서드들을 활용해서 계산
        int total = calculateTotal(korean, english, math);
        double average = calculateAverage(total);
        String grade = getGrade(average);

        System.out.println("총점: " + total + "점");
        System.out.println("평균: " + average + "점");
        System.out.printf("평균: %.2f점\n", average); // 반올림
        System.out.println("등급: " + grade);
        System.out.println();
    }



    public static void main(String[] args) {
        System.out.println("=== 학생 성적 관리 시스템 ===");

        // 학생별 성적 처리
        printStudentInfo("김철수", 85, 90, 78);
        printStudentInfo("이영희", 95, 88, 92);
        printStudentInfo("박민수", 65, 70, 55);
        printStudentInfo("정수빈", 100, 95, 98);
        printStudentInfo("최영미", 45, 55, 40);
    }
}
