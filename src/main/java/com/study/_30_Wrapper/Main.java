package com.study._30_Wrapper;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 사용자 점수 처리 시스템 ===");

        // 사용자가 입력한 점수들 (문자열로 받았다고 가정)
        String[] scoreInputs = {"85", "92", "78", "96", "88"};

        // 이 문자열들을 모두 Integer배열로 변환 후, 최고점과 최저점을 적절한 Integer 메서드를 사용해 구하시오

        // TODO: 문자열 배열을 Integer 배열로 변환
        Integer[] scores = new Integer[scoreInputs.length];

        // 힌트: for문을 사용해서 각 문자열을 Integer.valueOf()로 변환
        for (int i = 0; i < scoreInputs.length; i++) {
            scores[i] = Integer.valueOf(scoreInputs[i]);
        }

        // TODO: 최고점과 최저점 찾기
        Integer maxScore = scores[0];
        Integer minScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            // 힌트: Integer.max()와 Integer.min() 사용
            maxScore = Integer.max(maxScore, scores[i]);
            minScore = Integer.min(minScore, scores[i]);
        }

        // 결과 출력
        System.out.println("입력된 점수들: ");
        for (Integer score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        System.out.println("최고점: " + maxScore);
        System.out.println("최저점: " + minScore);

        /*
         * 예상 출력:
         * 입력된 점수들:
         * 85 92 78 96 88
         * 최고점: 96
         * 최저점: 78
         */
    }
}
