package com.study._38_Generic.wildcard;

import com.study._38_Generic.Box;
import com.study._38_Generic.animal.Animal;
import com.study._38_Generic.animal.AnimalHospital;
import com.study._38_Generic.animal.Cat;
import com.study._38_Generic.animal.Dog;

public class Main1 {
    /*
     * [필기] 와일드카드(Wildcard)와 타입 이레이저(Type Erasure)
     *
     * 1. 와일드카드란?
     *    - 제네릭 타입에서 구체적인 타입 대신 '?'를 사용하는 것
     *    - 타입의 범위를 유연하게 지정할 수 있음
     *    - 메서드 매개변수에서 주로 사용
     *
     * 2. 와일드카드의 종류
     *    - 비제한 와일드카드: <?>
     *    - 상한 경계 와일드카드: <? extends T>
     *    - 하한 경계 와일드카드: <? super T>
     *
     * 3. 제네릭 메서드 vs 와일드카드
     *    - 제네릭 메서드: 타입을 반환하거나 타입 관계가 중요할 때
     *    - 와일드카드: 단순히 읽기만 하거나 매개변수로만 사용할 때
     */
    /**
     * [필기] 제네릭 메서드 - 구체적인 타입 요구
     */
    public static <T extends Animal> void checkupGeneric(AnimalHospital<T> hospital) {
        System.out.println("제네릭 메서드로 " + hospital.getAnimal().getClass().getSimpleName() + " 검진");
        hospital.checkup();
    }

    /**
     * [필기] 비제한 와일드카드 <?>
     * 어떤 타입이든 받을 수 있지만 Object로만 접근 가능
     */
    public static void printAnyBox(Box<?> box) {
        System.out.println("  박스 내용 (Object로 접근): " + box.get());
        // box.set("새 값"); // 컴파일 오류! 값 설정 불가
    }

    /**
     * [필기] 상한 경계 와일드카드 <? extends Animal>
     * Animal 또는 Animal의 하위 타입만 허용
     * 읽기 전용 (Producer Extends)
     */
    public static void checkupWildcard(AnimalHospital<? extends Animal> hospital) {
        System.out.println("와일드카드 메서드로 동물 검진:");
        hospital.checkup();
        // hospital.setAnimal(new Dog("새 개", 10)); // 컴파일 오류! 설정 불가
    }

    /**
     * [필기] 상한 경계 와일드카드로 동물 박스 처리
     */
    public static void printAnimalBox(Box<? extends Animal> animalBox) {
        Animal animal = animalBox.get(); // Animal로 읽기 가능
        System.out.println("  동물: " + animal.getName() + " (크기: " + animal.getSize() + ")");
        // animalBox.set(new Dog("새 개", 10)); // 컴파일 오류! 추가 불가
    }

    /**
     * [필기] 하한 경계 와일드카드 <? super Animal>
     * Animal 또는 Animal의 상위 타입만 허용
     * 쓰기 전용 (Consumer Super)
     */
    public static void addAnimalToBox(Box<? super Animal> box, Animal animal) {
        box.set(animal); // Animal과 하위 타입 추가 가능
        System.out.println("  박스에 추가됨: " + animal.getName());
        // Animal retrieved = box.get(); // 컴파일 오류! Object로만 읽기 가능
        Object obj = box.get(); // Object로는 읽기 가능
    }

    /**
     * [필기] 제네릭 메서드 - 구체적인 타입 반환
     */
    public static <T extends Animal> T treatAnimalGeneric(AnimalHospital<T> hospital) {
        System.out.println("제네릭 메서드로 치료 중...");
        T animal = hospital.getAnimal();
        System.out.println("치료 완료: " + animal.getName());
        return animal; // T 타입 그대로 반환
    }

    /**
     * [필기] 와일드카드 - Animal 타입으로만 반환
     */
    public static Animal treatAnimalWildcard(AnimalHospital<? extends Animal> hospital) {
        System.out.println("와일드카드 메서드로 치료 중...");
        Animal animal = hospital.getAnimal();
        System.out.println("치료 완료: " + animal.getName());
        return animal; // Animal 타입으로만 반환
    }
    public static void main(String[] args) {
        System.out.println("=== 와일드카드 학습 ===");

        System.out.println("--- 1단계: 제네릭 메서드의 한계 ---");

        // 각각 다른 타입의 병원과 박스들
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        dogHospital.setAnimal(new Dog("멍멍이", 15));

        AnimalHospital<Cat> catHospital = new AnimalHospital<>();
        catHospital.setAnimal(new Cat("야옹이", 8));

        Box<String> stringBox = new Box<>();
        stringBox.set("안녕하세요");

        Box<Integer> intBox = new Box<>();
        intBox.set(42);

        // 제네릭 메서드로 각각 따로 처리해야 함
        checkupGeneric(dogHospital);
        checkupGeneric(catHospital);

        System.out.println("문제: 각 타입마다 별도로 메서드를 호출해야 함");

        System.out.println();
        System.out.println("--- 2단계: 와일드카드로 해결 ---");

        // 1. 비제한 와일드카드 <?> 사용
        System.out.println("1. 비제한 와일드카드 <?> 사용:");

        printAnyBox(stringBox);  // 어떤 타입이든 가능
        printAnyBox(intBox);
        printAnyBox(new Box<Dog>(new Dog("바둑이", 12)));

        System.out.println();

        // 2. 상한 경계 와일드카드 <? extends Animal> 사용
        System.out.println("2. 상한 경계 와일드카드 <? extends Animal> 사용:");

        checkupWildcard(dogHospital);  // 하나의 메서드로 모든 동물 병원 처리!
        checkupWildcard(catHospital);

        // 동물 박스도 처리 가능
        Box<Dog> dogBox = new Box<>();
        dogBox.set(new Dog("큰개", 20));
        Box<Cat> catBox = new Box<>();
        catBox.set(new Cat("큰고양이", 10));

        printAnimalBox(dogBox);
        printAnimalBox(catBox);

        System.out.println();

        // 3. 하한 경계 와일드카드 <? super Animal> 사용
        System.out.println("3. 하한 경계 와일드카드 <? super Animal> 사용:");

        // Animal 또는 그 상위 타입 박스에 동물 추가 가능
        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();

        addAnimalToBox(objectBox, new Dog("새 개", 18));
        addAnimalToBox(animalBox, new Cat("새 고양이", 9));

        System.out.println();
        System.out.println("--- 3단계: 제네릭 메서드 vs 와일드카드 비교 ---");

        AnimalHospital<Dog> testHospital = new AnimalHospital<>();
        testHospital.setAnimal(new Dog("테스트개", 15));

        // 제네릭 메서드: 구체적인 타입 반환 가능
        Dog treatedDog = treatAnimalGeneric(testHospital);
        System.out.println("제네릭 메서드 결과: " + treatedDog.getName() + " (타입: Dog)");

        // 와일드카드: Animal 타입으로만 반환
        Animal treatedAnimal = treatAnimalWildcard(testHospital);
        System.out.println("와일드카드 결과: " + treatedAnimal.getName() + " (타입: Animal)");

        System.out.println();
        System.out.println("결론:");
        System.out.println("- 제네릭 메서드: 구체적인 타입을 반환해야 할 때");
        System.out.println("- 와일드카드: 단순히 읽기만 하거나 매개변수로만 사용할 때");

    }
}
