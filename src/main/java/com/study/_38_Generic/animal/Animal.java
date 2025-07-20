package com.study._38_Generic.animal;

public abstract class Animal {
    private String name;
    private int size;

    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    // 각 동물마다 다른 소리를 내므로 추상 메서드로 정의
    public abstract void sound();

    @Override
    public String toString() {
        return "Animal{name='" + name + "', size=" + size + "}";
    }
}
