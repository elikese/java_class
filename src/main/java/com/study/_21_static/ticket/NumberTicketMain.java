package com.study._21_static.ticket;

public class NumberTicketMain {
    public static void main(String[] args) {
        NumberTicket t1 = new NumberTicket();  // 1
        NumberTicket t2 = new NumberTicket();  // 2
        NumberTicket t3 = new NumberTicket();  // 3

        System.out.println("t1 번호: " + t1.getNum());
        System.out.println("t2 번호: " + t2.getNum());
        System.out.println("t3 번호: " + t3.getNum());

        System.out.println("마지막으로 발급된 번호: " + NumberTicket.getLastIssuedNum());
    }
}
