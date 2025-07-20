package com.study._38_Generic;

public class Box<T> {
    /*
     * - <T>: 타입 매개변수 선언
     * - T: 클래스 내부에서 실제 타입처럼 사용
     */
    private T item;

    public Box() {}

    public Box(T item) {
        this.item = item;
    }

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    public boolean isEmpty() {
        return item == null;
    }
}
