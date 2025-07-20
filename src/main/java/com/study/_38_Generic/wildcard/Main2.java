package com.study._38_Generic.wildcard;

import com.study._38_Generic.Box;
import com.study._38_Generic.animal.AnimalHospital;
import com.study._38_Generic.animal.Cat;
import com.study._38_Generic.animal.Dog;

public class Main2 {
    /*
     * [필기] 타입 이레이저(Type Erasure) 예제
     *
     * 4. 타입 이레이저란?
     *    - 컴파일 시점에 제네릭 타입 정보가 제거되는 Java의 특성
     *    - 런타임에는 원시 타입(Raw Type)으로 동작
     *    - 하위 호환성을 위한 설계
     */
    public static void main(String[] args) {
        System.out.println("=== 타입 이레이저 학습 ===");

        System.out.println("--- 컴파일 시점 vs 런타임 시점 ---");

        // 컴파일 시점: 서로 다른 제네릭 타입
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        AnimalHospital<Cat> catHospital = new AnimalHospital<>();

        stringBox.set("안녕하세요");
        intBox.set(100);
        dogHospital.setAnimal(new Dog("멍멍이", 15));
        catHospital.setAnimal(new Cat("야옹이", 8));

        System.out.println("컴파일 시점에는 각각 다른 타입:");
        System.out.println("- Box<String>과 Box<Integer>는 서로 다른 타입");
        System.out.println("- AnimalHospital<Dog>과 AnimalHospital<Cat>도 서로 다른 타입");

        System.out.println();

        // 런타임 시점: 제네릭 정보가 사라짐
        System.out.println("런타임 시점에는 제네릭 정보가 사라짐:");
        System.out.println("String Box 클래스: " + stringBox.getClass().getSimpleName());
        System.out.println("Integer Box 클래스: " + intBox.getClass().getSimpleName());
        System.out.println("두 Box가 같은 클래스? " + (stringBox.getClass() == intBox.getClass()));

        System.out.println();

        System.out.println("Dog Hospital 클래스: " + dogHospital.getClass().getSimpleName());
        System.out.println("Cat Hospital 클래스: " + catHospital.getClass().getSimpleName());
        System.out.println("두 Hospital이 같은 클래스? " + (dogHospital.getClass() == catHospital.getClass()));

        System.out.println();
        System.out.println("--- 타입 이레이저의 영향 ---");

        // 1. 런타임에 타입 정보 확인 불가
        System.out.println("1. 런타임에는 구체적인 제네릭 타입을 알 수 없음");
        // if (stringBox instanceof Box<String>) { } // 컴파일 오류!
        if (stringBox instanceof Box) { // Raw Type으로만 확인 가능
            System.out.println("   stringBox는 Box 타입입니다 (구체적 타입은 모름)");
        }

        System.out.println();

        // 2. 타입 이레이저 후의 실제 모습
        System.out.println("3. 타입 이레이저 후 컴파일된 코드의 실제 모습:");
        System.out.println("   Box<String> → Box");
        System.out.println("   AnimalHospital<Dog> → AnimalHospital");
        System.out.println("   제네릭 정보는 컴파일 시점에만 존재하여 타입 체크에 사용됨");

        System.out.println();
        System.out.println("--- 정리 ---");
        System.out.println("타입 이레이저의 특징:");
        System.out.println("- 컴파일 시점: 제네릭 타입으로 타입 안전성 보장");
        System.out.println("- 런타임 시점: 원시 타입으로 변환되어 메모리 효율성 확보");
        System.out.println("- Java 5 이전 코드와의 호환성 유지");
        System.out.println("- 제네릭은 컴파일 타임에만 존재하는 '문법적 설탕'");
    }
}
