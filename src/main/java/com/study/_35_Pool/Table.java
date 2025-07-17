package com.study._35_Pool;

public class Table {
    /*
        음식점 테이블을 배열로 관리하는 간단한 풀(Pool) 패턴 예시입니다.
         * - 음식점에는 테이블이 5개만 있음
         * - 손님이 오면 비어있는 테이블을 배정하고
         * - 나가면 테이블을 다시 사용 가능하게 만듦
     */
    private final int id;
    private boolean inUse = false; // 테이블 사용 중인지 여부

    public Table(int id) {
        this.id = id;
    }

    public void serve(String customerName) {
        System.out.println("손님 " + customerName + "에게 " + id + "번 테이블을 제공 중입니다.");
        inUse = true;
    }

    public void clear() {
        System.out.println(id + "번 테이블이 비었습니다.");
        inUse = false;
    }

    public boolean isAvailable() {
        return !inUse;
    }

    public int getId() {
        return id;
    }
}
