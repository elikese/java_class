package com.study._38_Generic.wildcard;

import com.study._38_Generic.Box;
import com.study._38_Generic.animal.AnimalHospital;
import com.study._38_Generic.animal.Cat;
import com.study._38_Generic.animal.Dog;

public class TypeErasureMain {
    /*
     * [필기] 타입 이레이저(Type Erasure) 예제
     *
     * 4. 타입 이레이저란?
     *    - 컴파일 시점에 제네릭 타입 정보가 제거되는 Java의 특성
     *    - 런타임에는 Object으로 변하여 동작!
     *    - 하위 호환성을 위한 설계
     */
    public static void main(String[] args) {
        System.out.println("--- 컴파일 시점 vs 런타임 시점 ---");

        // 컴파일 시점에는 서로 다른 제네릭 타입으로 인식됨을 보여주기 위한 코드
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        AnimalHospital<Cat> catHospital = new AnimalHospital<>();

        // 각각 적절한 타입의 데이터 저장 - 컴파일 시점 타입 체크를 보여줌
        stringBox.set("안녕하세요");
        intBox.set(100);
        dogHospital.setAnimal(new Dog("멍멍이", 15));
        catHospital.setAnimal(new Cat("야옹이", 8));

        System.out.println("컴파일 시점에는 각각 다른 타입:");
        System.out.println("- Box<String>과 Box<Integer>는 서로 다른 타입");
        System.out.println("- AnimalHospital<Dog>과 AnimalHospital<Cat>도 서로 다른 타입");

        System.out.println();

        // 런타임에는 제네릭 정보가 사라짐을 보여주는 코드
        System.out.println("런타임 시점에는 제네릭 정보가 사라짐:");
        System.out.println("String Box 클래스: " + stringBox.getClass().getSimpleName());
        System.out.println("Integer Box 클래스: " + intBox.getClass().getSimpleName());
        System.out.println("두 Box가 같은 클래스? " + (stringBox.getClass() == intBox.getClass())); // true가 나옴을 보여줌

        // 런타임에는 제네릭 타입이 모두 Object로 전환된다.
        try {
            System.out.println(stringBox.getClass().getDeclaredField("item").getType());
            System.out.println(intBox.getClass().getDeclaredField("item").getType());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        System.out.println("Dog Hospital 클래스: " + dogHospital.getClass().getSimpleName());
        System.out.println("Cat Hospital 클래스: " + catHospital.getClass().getSimpleName());
        System.out.println("두 Hospital이 같은 클래스? " + (dogHospital.getClass() == catHospital.getClass())); // true가 나옴을 보여줌

        System.out.println();
        System.out.println("--- 타입 이레이저의 영향 ---");



        /*
         * 런타임에는 구체적인 제네릭 타입을 알 수 없음
         * - stringBox instanceof Box<String> → 컴파일 오류
         * - instanceof는 원시 타입(Box)로만 검사 가능
         */
        // if (stringBox instanceof Box<String>) { } // 컴파일 오류! - 이것이 불가능함을 보여주는 주석
        if (stringBox instanceof Box) {
            System.out.println("   stringBox는 Box 타입입니다 (구체적 타입은 모름)");
        }

        /*
         * 타입 이레이저 후 컴파일된 코드의 실제 모습:
         * - Box<String> → Box
         * - AnimalHospital<Dog> → AnimalHospital
         * → 제네릭 정보는 컴파일 시점에만 존재하여 타입 체크에 사용됨
         */

        /*
         * [정리] 타입 이레이저의 특징
         * - 컴파일 시점: 제네릭 타입으로 타입 안전성 보장
         * - 런타임 시점: 원시 타입으로 변환되어 메모리 효율성 확보
         * - Java 5 이전 코드와의 호환성 유지
         * - 제네릭은 컴파일 타임에만 존재하는 '문법적 설탕' (syntactic sugar)
         */
    }
}
