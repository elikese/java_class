package com.study._08_For;

public class NestedLoop2 {
    public static void main(String[] args) {
        // 네모 별 찍기
        // *****
        // *****
        // *****
        // *****
        // *****
        for (int i = 0; i < 5; i++) { //세로줄
            for (int j = 0; j < 5; j++) { //가로로 별찍기
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }

        System.out.println();

        //별 삼각형 찍기
        // *
        // **
        // ***
        // ****
        // *****

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        //*****
        //****
        //***
        //**
        //*

        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
