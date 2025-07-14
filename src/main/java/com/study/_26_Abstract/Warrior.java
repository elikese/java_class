package com.study._26_Abstract;

public class Warrior extends GameCharacter{

    public Warrior(String name) {
        // 전사: 높은 체력, 낮은 마나, 중간 공격력, 높은 스킬 데미지, 높은 마나 소모
        super(name, 120, 25);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + "이(가) " + target.name + "에게 검으로 강력하게 베어냅니다!");
        target.receiveDamage(attackDamage);
        System.out.println(target.name + "이(가) " + attackDamage + " 데미지를 받았습니다.");
    }


}
