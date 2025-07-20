package com.study._38_Generic.animal;

public class Main {
    public static void main(String[] args) {
        // 동물들 생성
        Dog dog = new Dog("멍멍이", 15);
        Cat cat = new Cat("야옹이", 8);

        // 개 전용 병원
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        System.out.println();

        // 고양이 전용 병원
        AnimalHospital<Cat> catHospital = new AnimalHospital<>();
        catHospital.setAnimal(cat);
        catHospital.checkup();

        // 타입 안전성 확인
        // dogHospital.setAnimal(cat); // 컴파일 오류! 개 병원에는 개만 가능

        System.out.println("→ Animal 타입 제한으로 동물 병원의 전문성 보장!");
    }
}
