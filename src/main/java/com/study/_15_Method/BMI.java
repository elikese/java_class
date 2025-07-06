package com.study._15_Method;

public class BMI {
    /*
     * 구현해야 할 메서드들:
     * - calculateBMI(double height, double weight): BMI 계산 (double 반환)
     * - getBMIStatus(double bmi): BMI 상태 판정 (String 반환)
     * - printHealthInfo(String name, double height, double weight): 건강 정보 출력
     *
     * BMI 계산 공식:
     * BMI = 몸무게(kg) / (키(m) * 키(m))
     *
     * BMI 상태 기준:
     * 18.5 미만: "저체중"
     * 18.5~24.9: "정상체중"
     * 25.0~29.9: "과체중"
     * 30.0 이상: "비만"
     */



    public static double calculateBMI(double height, double weight) {
        double heightInMeters = height / 100.0;  // cm를 m로 변환
        return weight / (heightInMeters * heightInMeters);
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "저체중";
        } else if (bmi < 25.0) {
            return "정상체중";
        } else if (bmi < 30.0) {
            return "과체중";
        } else {
            return "비만";
        }
    }

    public static void printHealthInfo(String name, double height, double weight) {
        System.out.println("===== " + name + " 건강 정보 =====");
        System.out.println("키: " + height + "cm");
        System.out.println("몸무게: " + weight + "kg");

        // 다른 메서드들을 활용해서 계산
        double bmi = calculateBMI(height, weight);
        String status = getBMIStatus(bmi);

        System.out.printf("BMI: %.1f%n", bmi);
        System.out.println("상태: " + status);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== BMI 계산 시스템 ===");

        // 다양한 사람들의 BMI 계산
        printHealthInfo("김철수", 175.0, 70.0);
        printHealthInfo("이영희", 160.0, 50.0);
        printHealthInfo("박민수", 180.0, 85.0);
        printHealthInfo("정수빈", 165.0, 55.0);
        printHealthInfo("최영미", 170.0, 90.0);
    }

}
