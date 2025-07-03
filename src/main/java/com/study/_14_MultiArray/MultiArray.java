package com.study._14_MultiArray;

import java.util.Arrays;

public class MultiArray {
    public static void main(String[] args) {
        /*
         * 다차원 배열 (Multi-Dimensional Array)
         *
         * 다차원 배열이란?
         * - 1차원 배열에 차원이 더 추가된 배열
         * - 한차원이 추가 된 2차원 배열은 행(row)과 열(column)로 구성된 표 형태의 데이터 구조
         * - 한차원이 추가 된 2차원 배열은 x,y 좌표, 엑셀 표와 같은 구조
         */

        //영화관 좌석
        //A1 ~ A5
        //B1 ~ B5
        //C1 ~ C5
        String[] seatA = {"A1", "A2", "A3", "A4" ,"A5"};
        String[] seatB = {"B1", "B2", "B3", "B4" ,"B5"};
        String[] seatC = {"C1", "C2", "C3", "C4" ,"C5"};

        // 3 X 5
        // [[], [], [], []]
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4" ,"A5"},
                {"B1", "B2", "B3", "B4" ,"B5"},
                {"C1", "C2", "C3", "C4" ,"C5"}
        };

        //B3출력
        System.out.println(seats[1][2]);
        //C4출력
        System.out.println(seats[2][3]);


        System.out.println(Arrays.deepToString(seats)); // n차원 배열 String출력
    }
}
