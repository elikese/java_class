package com.study._21_static.ticket;

public class NumberTicket {
    private static int nextNum = 1;  // static → 모든 객체가 공유
    private int num;

    public NumberTicket() {
        this.num = nextNum++;  // 생성될 때마다 번호표 발급
        System.out.println("번호표 발급! 번호표: " + num);
    }

    public int getNum() {
        return num;
    }

    public static int getLastIssuedNum() {
        return nextNum - 1;
    }
}
