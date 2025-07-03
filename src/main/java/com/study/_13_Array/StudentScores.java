package com.study._13_Array;

public class StudentScores {
    public static void main(String[] args) {
        // 학생 점수 배열
        int[] scores = {85, 90, 78, 92, 88, 76, 95, 82, 89, 91};

        /*
        // [요구사항]
        // 1. 모든 학생 점수의 총합(totalSum)을 구하여 출력하세요.
        // 2. 전체 점수의 평균(average)을 구하여 출력하세요.
        //    (평균은 소수점까지 계산되도록 하세요)
        // 3. 평균 이상인 학생 수(overAvgScore)를 구하여 출력하세요.
        //    (평균 이상인 학생이 몇 명인지 세면 됩니다)
        // 4. 최고 점수(maxScore)를 찾아 출력하세요.
        // 5. 최저 점수(minScore)를 찾아 출력하세요.
         */

        // 1. 전체 합계 계산
        int totalSum = 0;
        for (int score : scores) {
            totalSum += score;
        }
        System.out.println("전체 점수 합: " + totalSum);

        // 2. 평균 계산
        double average = (double) totalSum / scores.length;
        System.out.println("평균점수: " + average);

        // 3. 평균 이상 학생 수 계산
        int overAvgScore = 0;
        for (int score : scores) {
            if (score >= average) {
                overAvgScore++;
            }
        }
        System.out.println("평균 이상 학생: " + overAvgScore + "명");

        // 4. 최고 점수 찾기
        int maxScore = scores[0];  // 첫 번째 점수를 최고 점수로 초기화
        for (int i = 1; i < scores.length; i++) {  // 1번 인덱스부터 비교
            if (scores[i] > maxScore) {            // 현재 점수가 최고 점수보다 크면
                maxScore = scores[i];              // 최고 점수 업데이트
            }
        }
        System.out.println("최고 점수: " + maxScore + "점");

        // 5. 최저 점수 찾기
        int minScore = scores[0];  // 첫 번째 점수를 최저 점수로 초기화
        for (int i = 1; i < scores.length; i++) {  // 1번 인덱스부터 비교
            if (scores[i] < minScore) {            // 현재 점수가 최저 점수보다 작으면
                minScore = scores[i];              // 최저 점수 업데이트
            }
        }
        System.out.println("최저 점수: " + minScore + "점");



    }
}
