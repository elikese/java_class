package com.study._21_Static.ticket;

public class Reception {
    private NumberTicket[] waitingList = new NumberTicket[100];  // 최대 100명
    private int size = 0;           // 현재까지 받은 손님 수
    private int currentIndex = 0;   // 현재 처리할 손님 인덱스

    public void accept(NumberTicket ticket) {
        if (size >= waitingList.length) {
            System.out.println("대기열이 꽉 찼습니다!");
            return;
        }
        waitingList[size++] = ticket;
        System.out.println(ticket.getNum() + "번 손님, 대기열에 등록되었습니다.");
    }

    public void next() {
        if (currentIndex >= size) {
            System.out.println("대기 중인 손님이 없습니다.");
        } else {
            NumberTicket nextTicket = waitingList[currentIndex++];
            System.out.println(nextTicket.getNum() + "번 손님, 오세요!");
        }
    }
}
