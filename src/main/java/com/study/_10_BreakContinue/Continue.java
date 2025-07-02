package com.study._10_BreakContinue;

public class Continue {
    public static void main(String[] args) {


        int waiting = 50; // 대기 인원수
        int max = 10; // 판매 가능한 갯수
        int sold = 0; // 현재 판매량
        int noShow = 6; // 노쇼 번호

        for (int i = 1; i <= waiting; i++) {
            System.out.println(i + "번 손님 입장!");

            if (i == noShow) {
                System.out.println(i + "번 손님 노쇼....");
                continue;
            } // 노쇼 검사

            sold++; // 노쇼 아니면 판매처리
            if (sold == max) {
                System.out.println("재료 소진!");
                break;
            }
        }

        System.out.println("=".repeat(50));

        waiting = 50; // 대기 인원수
        max = 10; // 판매 가능한 갯수
        sold = 0; // 현재 판매량
        noShow = 6; // 노쇼 번호
        int nowNum = 1; // 현재 입장 번호 (시작번호)
        while (nowNum <= waiting) {
            System.out.println(nowNum + "번 손님 입장!");
            nowNum++;

            if (nowNum == noShow) {
                System.out.println(nowNum + "번 손님 노쇼함");
                continue;
            }
            sold++; // 판매처리
            if (sold == max) { // 메뉴가 다 팔렸을때
                System.out.println("재료 소진!");
                break;
            }
        }


    }
}
