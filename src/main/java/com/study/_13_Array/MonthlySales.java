package com.study._13_Array;

public class MonthlySales {
    public static void main(String[] args) {
        // 월별 매출 (단위: 만원)
        int[] monthlySales = {1200, 1350, 1100, 1500, 1800, 2100, 2300, 2200, 1900, 1600, 1400, 1650};
        String[] months = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};

        // 1. 최고 매출과 해당 월 찾기
        int maxSales = monthlySales[0];  // 첫 번째 매출을 최고 매출로 초기화
        int maxIndex = 0; // 최고 매출 월의 인덱스를 0으로 초기화
        for (int i = 1; i < monthlySales.length; i++) {  // 1번 인덱스부터 비교 시작
            if (monthlySales[i] > maxSales) {            // 현재 매출이 최고 매출보다 크면
                maxSales = monthlySales[i];              // 최고 매출 업데이트
                maxIndex = i;                            // 최고 매출 월 인덱스 업데이트
            }
        }
        System.out.println("최고 매출: " + months[maxIndex] + " " + maxSales + "만원");

        // 2. 최저 매출과 해당 월 찾기
        int minSales = monthlySales[0];  // 첫 번째 매출을 최저 매출로 초기화
        int minIndex = 0;                // 최저 매출 월의 인덱스를 0으로 초기화
        for (int i = 1; i < monthlySales.length; i++) {  // 1번 인덱스부터 비교 시작
            if (monthlySales[i] < minSales) {            // 현재 매출이 최저 매출보다 작으면
                minSales = monthlySales[i];              // 최저 매출 업데이트
                minIndex = i;                            // 최저 매출 월 인덱스 업데이트
            }
        }
        System.out.println("최저 매출: " + months[minIndex] + " " + minSales + "만원");

        // 3. 연간 평균 매출 계산
        int total = 0;                   // 총 매출 합계를 저장할 변수
        for (int sales : monthlySales) { // 향상된 for문으로 모든 매출 순회
            total += sales;              // 각 월의 매출을 총합에 더함
        }
        double average = (double) total / monthlySales.length;
        System.out.println("연간 평균: " + average + "만원");

        // 4. 평균 이상 매출을 기록한 달 출력
        String overAvgMonths = "";  // 평균 이상 매출 월들을 저장할 문자열
        for (int i = 0; i < monthlySales.length; i++) {  // 모든 월을 순회
            if (monthlySales[i] >= average) {            // 해당 월 매출이 평균 이상이면
                if (overAvgMonths.length() != 0) {     // 이미 추가된 월이 있으면
                    overAvgMonths += ", ";          // 쉼표와 공백 추가
                }
                overAvgMonths += months[i];         // 해당 월 이름 추가
            }
        }
        System.out.println("평균 이상 매출 월: " + overAvgMonths);
    }
}
