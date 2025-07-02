package com.study._09_While;

public class DoWhile {
    public static void main(String[] args) {
        /*
        do {
            // 실행되는 코드
        } while (조건식);

        // 최소 한번은 실행되는 반복문(결과론적 설명)

        // while: 조건 확인 → 실행
        // do-while: 실행 → 조건 확인
         */

        //1~5까지 출력
        int i = 1;
        i = 10;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

    }
}
