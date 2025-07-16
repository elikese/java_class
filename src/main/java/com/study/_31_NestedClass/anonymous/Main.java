package com.study._31_NestedClass.anonymous;

public class Main {
    public static void main(String[] args) {
        /*
         * 익명 클래스:
         * - 이름이 없는 클래스
         * - 클래스 정의와 동시에 인스턴스 생성
         * - 인터페이스나 추상 클래스를 구현되어서 한번 쓰고 버려질 클래스의 객체가 된다.
         * - 일반 클래스 처럼 method area, heap 두군데 모두 메모리가 로드 됨.
         *
         *
         * **) 컴파일 시점에는 Hello 타입으로 치고,
         * 런타임에 익명이 부여되어 메모리에 올라감.
         * => 필드를 선언해도, 인스턴스주소로 참조 불가능
         * (컴파일러는 생성 타입으로만 추론하니까)
         */

        Hello hello = new Hello() {
            @Override
            public void hello() {
                System.out.println("하이하이");
            }

            @Override
            public void bye() {
                System.out.println("바이바이");
            }
        };

        hello.bye();
        hello.hello();

        // Main$1..Main$2..익명1..익명2...
        System.out.println(hello.getClass().getName());


        GameCharacter character = new GameCharacter("마스터", 999, 99) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("마스터 공격");
                target.receiveDamage(attackDamage);
            }
        };


        character.showStatus();
        System.out.println(character.getClass().getName());

    }
}
