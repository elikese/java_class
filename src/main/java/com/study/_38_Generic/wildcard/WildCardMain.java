package com.study._38_Generic.wildcard;

import com.study._38_Generic.Box;
import com.study._38_Generic.animal.Animal;
import com.study._38_Generic.animal.AnimalHospital;
import com.study._38_Generic.animal.Cat;
import com.study._38_Generic.animal.Dog;

public class WildCardMain {
    /*
     * [필기 요약] 와일드카드(Wildcard) 핵심 개념
     *
     * 1. 와일드카드란?
     *    - 제네릭 타입에서 구체적인 타입 대신 '?'를 사용하는 문법
     *    - 타입의 유연성과 범용성을 높이기 위해 주로 메서드 매개변수에서 사용됨
     *
     * 2. 와일드카드의 종류
     *    - <?>             : 비제한 와일드카드 (어떤 타입이든 허용, 단 set 불가)
     *    - <? extends T>   : 상한 경계 와일드카드 (T의 하위 타입만 허용, 읽기 전용)
     *    - <? super T>     : 하한 경계 와일드카드 (T의 상위 타입만 허용, 쓰기 전용)
     *
     * 3. 제네릭 메서드 vs 와일드카드
     *    - 제네릭 메서드: 타입을 유지하고 반환할 필요가 있을 때
     *    - 와일드카드  : 다양한 타입을 유연하게 처리할 때
     */

    // 비제한 와일드카드: 다양한 타입에 대해 동일한 메서드 시그니처로 처리 가능
    // (※ 타입 정보는 컴파일 타임에만 존재하고 런타임엔 Object로 취급됨)
    public static void printAnyBox(Box<?> box) {
        System.out.println("  박스 내용 (Object로 접근): " + box.get());
        // box.set("새 값"); // ❌ 컴파일 오류: 타입 안정성이 깨질 수 있어 set 불가
    }

    // 상한 경계 와일드카드: Animal 하위 타입만 허용, 읽기 전용으로 안전하게 사용 가능
    // (※ 메서드 시그니처는 하나로 유지됨)
    public static void checkupWildcard(AnimalHospital<? extends Animal> hospital) {
        System.out.println("와일드카드 메서드로 동물 검진:");
        hospital.checkup();
        // hospital.setAnimal(new Dog("새 개", 10)); // ❌ 컴파일 오류: 실제 타입이 Dog인지 Cat인지 모르므로 set 불가
    }

    // Animal의 하위 타입(Box<Dog>, Box<Cat>)을 받아 안전하게 Animal로 읽기 가능
    // 와일드카드는 다양한 타입을 하나의 메서드 시그니처로 통합하는 데 유리함
    public static void printAnimalBox(Box<? extends Animal> animalBox) {
        Animal animal = animalBox.get(); // ✅ 읽기 OK (최소한 Animal 보장)
        System.out.println("  동물: " + animal.getName() + " (크기: " + animal.getSize() + ")");
        // animalBox.set(new Dog("새 개", 10)); // ❌ 컴파일 오류: 정확한 타입을 모르므로 set 불가
    }

    // 하한 경계: Animal 또는 그 하위 타입을 상위 타입(Box<Object>, Box<Animal>)에 안전하게 넣을 수 있음
    // 읽기는 Object로 제한됨
    public static void addAnimalToBox(Box<? super Animal> box, Animal animal) {
        box.set(animal); // ✅ 쓰기 OK
        System.out.println("  박스에 추가됨: " + animal.getName());
        Object obj = box.get(); // ✅ 읽기 OK (Object로만 가능)
    }

    // 제네릭 메서드 - 타입을 그대로 반환 → 컴파일 시 타입 안전성 보장
    // 런타임에는 타입 정보가 지워지며 시그니처는 하나
    public static <T extends Animal> T treatAnimalGeneric(AnimalHospital<T> hospital) {
        System.out.println("제네릭 메서드로 치료 중...");
        T animal = hospital.getAnimal();
        System.out.println("치료 완료: " + animal.getName());
        return animal; // ✅ 입력한 타입 T 그대로 반환
    }

    // 와일드카드는 반환 타입을 Animal로 고정 → 타입은 축소되지만 시그니처는 하나
    public static Animal treatAnimalWildcard(AnimalHospital<? extends Animal> hospital) {
        System.out.println("와일드카드 메서드로 치료 중...");
        Animal animal = hospital.getAnimal();
        System.out.println("치료 완료: " + animal.getName());
        return animal; // ❗ 타입 손실: 실제는 Dog나 Cat이지만 Animal로 축소
    }

    public static void main(String[] args) {
        System.out.println("=== 와일드카드 학습 ===");

        System.out.println("--- 1단계: 제네릭 메서드의 특징과 한계 ---");

        // 각각의 병원 인스턴스를 타입별로 생성해야 함
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        dogHospital.setAnimal(new Dog("멍멍이", 15));

        AnimalHospital<Cat> catHospital = new AnimalHospital<>();
        catHospital.setAnimal(new Cat("야옹이", 8));

        // 비제한 와일드카드 테스트용 박스들
        Box<String> stringBox = new Box<>();
        stringBox.set("안녕하세요");

        Box<Integer> intBox = new Box<>();
        intBox.set(42);

        System.out.println("1. 비제한 와일드카드 <?> 사용:");
        printAnyBox(stringBox);
        printAnyBox(intBox);
        printAnyBox(new Box<Dog>(new Dog("바둑이", 12)));

        System.out.println();
        System.out.println("2. 상한 경계 와일드카드 <? extends Animal> 사용:");
        checkupWildcard(dogHospital);
        checkupWildcard(catHospital);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(new Dog("큰개", 20));
        Box<Cat> catBox = new Box<>();
        catBox.set(new Cat("큰고양이", 10));

        printAnimalBox(dogBox);
        printAnimalBox(catBox);

        System.out.println();
        System.out.println("3. 하한 경계 와일드카드 <? super Animal> 사용:");
        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();

        addAnimalToBox(objectBox, new Dog("새 개", 18));
        addAnimalToBox(animalBox, new Cat("새 고양이", 9));

        System.out.println();
        System.out.println("--- 3단계: 제네릭 메서드 vs 와일드카드 비교 ---");

        AnimalHospital<Dog> testHospital = new AnimalHospital<>();
        testHospital.setAnimal(new Dog("테스트개", 15));

        Dog treatedDog = treatAnimalGeneric(testHospital); // ✅ 타입 유지
        System.out.println("제네릭 메서드 결과: " + treatedDog.getName() + " (타입: Dog)");

        Animal treatedAnimal = treatAnimalWildcard(testHospital); // ❗ 타입 축소
        System.out.println("와일드카드 결과: " + treatedAnimal.getName() + " (타입: Animal)");

        System.out.println();
        System.out.println("결론:");
        System.out.println("- 제네릭 메서드: 반환 타입 유지와 타입 안전성이 필요할 때 적합");
        System.out.println("- 와일드카드: 다양한 타입을 하나의 시그니처로 유연하게 처리할 때 유리");
        System.out.println("- 둘 다 런타임에는 타입 정보가 제거되며 시그니처는 하나만 존재 (Type Erasure)");
    }
}
