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

        String[][] seats2 = new String[][] {
                seatA,
                seatB,
                seatC
        };

        // 3 X 5
        // [[], [], [], []]
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4" ,"A5"},
                {"B1", "B2", "B3", "B4" ,"B5"},
                {"C1", "C2", "C3", "C4" ,"C5"}
        };


        /*
        * 현재 메모리 상태:
        *
        * Stack                           Heap
        * ┌─────────────────────┐       ┌──────────────────────────────────────────────────────────────┐
        * │ main 메서드 영역      │       │ 0x1000: [0x2000, 0x3000, 0x4000]  // String[][] 배열        │
        * │ ├─ seats: 0x1000    │────▶  │                                                              │
        * └─────────────────────┘       │ 0x2000: [0x5000, 0x5010, 0x5020, 0x5030, 0x5040]  // 1행    │
        *                               │ 0x3000: [0x5050, 0x5060, 0x5070, 0x5080, 0x5090]  // 2행    │
        *                               │ 0x4000: [0x5100, 0x5110, 0x5120, 0x5130, 0x5140]  // 3행    │
        *                               │                                                              │
        *                               │ 0x5000: "A1"    0x5010: "A2"    0x5020: "A3"                │
        *                               │ 0x5030: "A4"    0x5040: "A5"                                │
        *                               │                                                              │
        *                               │ 0x5050: "B1"    0x5060: "B2"    0x5070: "B3"                │
        *                               │ 0x5080: "B4"    0x5090: "B5"                                │
        *                               │                                                              │
        *                               │ 0x5100: "C1"    0x5110: "C2"    0x5120: "C3"                │
        *                               │ 0x5130: "C4"    0x5140: "C5"                                │
        *                               └──────────────────────────────────────────────────────────────┘
         */



        //B3출력
        System.out.println(seats[1][2]);
        //C4출력
        System.out.println(seats[2][3]);


        System.out.println(Arrays.deepToString(seats)); // n차원 배열 String출력
    }
}
