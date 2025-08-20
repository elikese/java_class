package com.study._38_Generic.animal;

public class AnimalHospital<T extends Animal> {
    /**
     * 제네릭 동물 병원 클래스
     *
     * <T extends Animal>: 타입 매개변수 상한 경계 설정
     * - T는 Animal 타입이거나 Animal을 상속받은 타입이어야 함
     * - 이를 통해 Animal의 메서드들(getName, getSize, sound)을 사용할 수 있음
     * - 타입 안전성 보장: Animal 계열이 아닌 타입은 사용 불가
     */
    private T animal;

    /**
     * T 타입의 동물만 등록 가능
     */
    public void setAnimal(T animal) {
        this.animal = animal;
    }

    /**
     * Animal의 메서드들을 자유롭게 사용 가능
     * 상한 경계 덕분에 캐스팅 없이 Animal의 기능 사용
     */
    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        System.out.print("동물 소리: ");
        animal.sound();
    }

    /**
     * 두 동물을 비교하여 더 큰 동물을 반환
     * 반환 타입도 T로 타입 안전성 보장
     */
    public T getBigger(T animal1, T animal2) {
        return animal1.getSize() > animal2.getSize() ? animal1 : animal2;
    }

    public T getAnimal() {
        return animal;
    }

    public void speak() {
        animal.sound();
    }


}
