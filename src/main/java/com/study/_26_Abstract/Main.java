package com.study._26_Abstract;

public class Main {
    public static void main(String[] args) {
        // 추상클래스는 직접 인스턴스 생성 불가!
        // GameCharacter character = new GameCharacter("테스트", 100, 50, 20, 30, 15); // 컴파일 에러!

        // 구체적인 캐릭터들 생성
        Warrior warrior = new Warrior("아서");
        Mage mage = new Mage("머린");
        // TODO: Archer 구현 후 주석 해제
        // Archer archer = new Archer("로빈");

        System.out.println("=== 게임 시작 ===");

        // 각 캐릭터 상태 확인
        warrior.showStatus();
        mage.showStatus();
        // TODO: Archer 구현 후 주석 해제
        // archer.showStatus();

        System.out.println("\n=== 1vs1 기본 공격 ===");

        // 기본 공격: 아서가 머린을 공격
        warrior.attack(mage);
        mage.showStatus();

        // 반격: 머린이 아서를 공격
        mage.attack(warrior);
        warrior.showStatus();

        System.out.println("\n=== 스킬 공격 ===");

        // 스킬 사용: 머린이 아서에게 파이어볼
        mage.useSkill(warrior);
        mage.showStatus(); // 마나 소모 확인
        warrior.showStatus(); // 데미지 확인

        // 스킬 사용: 아서가 머린에게 파워 슬래시
        warrior.useSkill(mage);
        warrior.showStatus(); // 마나 소모 확인
        mage.showStatus(); // 데미지 확인

        // 다형성 배열 - Archer 추가 후에도 이 코드는 수정할 필요 없음!
        GameCharacter[] allCharacters = {warrior, mage}; // Archer 추가 시 여기만 수정

        System.out.println("\n--- 모든 캐릭터 상태 출력 (OCP 적용) ---");
        for (GameCharacter character : allCharacters) {
            character.showStatus(); // 어떤 캐릭터든 동일하게 동작
        }

        /*
        SOLID
        1. SRP(single responsibility principle) - 단일책임원리
        - 하나의 클래스는 하나의 책임만 가진다.
        2. OCP(open closed principle) - 개방폐쇄원칙
        - 확장에는 열려있고, 수정에는 닫혀있어야 한다.
        => 새로운 기능이 추가될때는, 기존코드는 간섭받지 않는다.

         */

    }
}
