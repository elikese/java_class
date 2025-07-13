package com.study._26_Abstract;

public abstract class GameCharacter {
    // 추상클래스 :
    // 추상메서드를 하나 이상 포함하는 클래스.
    // 객체 생성 불가능
    // 추상메서드 :
    // 메서드의 시그니처까지만 정의하고, 구체적인 구현은 없는 메서드
    // 상속받는 클래스에서 반드시 구현되어야 한다.

    protected String name;  // 캐릭터 이름
    protected int HP;       // 체력
    protected int MP;       // 마나
    protected int attackDamage;  // 기본 공격 데미지

    // 스킬 또한 추상화되어 여러가지 스킬로 분화되어 구현되어야 됨.
    protected int skillDamage;   // 스킬 공격 데미지
    protected int skillCost;     // 스킬 마나 소모량

    // 생성자 - 모든 캐릭터는 이름과 기본 능력치를 가져야 함
    public GameCharacter(String name, int HP, int MP, int attackDamage, int skillDamage, int skillCost) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
        this.attackDamage = attackDamage;
        this.skillDamage = skillDamage;
        this.skillCost = skillCost;
    }

    // 추상 메서드 - 각 캐릭터마다 공격 방식이 달라야 함
    // 마치 "공격하기" 버튼은 있지만, 구체적인 공격 방법은 캐릭터마다 다름
    public abstract void attack(GameCharacter target);

    // 추상 메서드 - 각 캐릭터마다 스킬 공격이 달라야 함
    public abstract void useSkill(GameCharacter target);

    // 일반 메서드 - 모든 캐릭터가 동일하게 사용
    // 마치 모든 캐릭터가 같은 방식으로 상태를 보여주는 것과 같음
    public void showStatus() {
        System.out.println(name + " 체력: " + HP + " / 마나: " + MP);
    }

    // 데미지를 받는 공통 메서드
    public void receiveDamage(int damage) {
        HP -= damage;
        if (HP <= 0) {
            HP = 0;
            System.out.println(name + "이(가) 쓰러졌습니다...");
        }
    }

    // 마나 소모 공통 메서드
    public void consumeMP(int mp) {
        MP -= mp;
        if (MP < 0) {
            MP = 0;
        }
    }

}
