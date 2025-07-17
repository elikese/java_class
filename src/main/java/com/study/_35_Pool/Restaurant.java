package com.study._35_Pool;

public class Restaurant {
    private final Table[] tables;

    public Restaurant(int size) {
        tables = new Table[size];
        for (int i = 0; i < size; i++) {
            tables[i] = new Table(i + 1);
        }
    }

    // 손님이 들어올 때 사용 가능한 테이블을 찾아 제공
    public Table enter(String customerName) {
        for (int i = 0; i < tables.length; i++) {
            if (tables[i].isAvailable()) {
                tables[i].serve(customerName);
                return tables[i];
            }
        }
        System.out.println("죄송합니다 " + customerName + "님, 현재 자리가 없습니다.");
        return null;
    }

    // 손님이 나갈 때 테이블을 비움 (반납)
    public void leave(Table table) {
        table.clear();
    }
}
