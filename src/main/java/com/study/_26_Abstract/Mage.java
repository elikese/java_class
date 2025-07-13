package com.study._26_Abstract;

public class Mage extends GameCharacter{

    public Mage(String name) {
        // 마법사: 낮은 체력, 높은 마나, 높은 공격력, 매우 높은 스킬 데미지, 높은 마나 소모
        super(name, 80, 100, 30, 50, 25);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + "이(가) " + target.name + "에게 마법 미사일을 발사합니다!");
        target.receiveDamage(attackDamage);
        System.out.println(target.name + "이(가) " + attackDamage + " 데미지를 받았습니다.");
    }

    @Override
    public void useSkill(GameCharacter target) {
        if (MP < skillCost) {
            System.out.println(name + "이(가) 마나가 부족해서 '파이어볼' 스킬을 사용할 수 없습니다!");
            return;
        }

        System.out.println(name + "이(가) " + target.name + "에게 '파이어볼' 스킬을 시전합니다!");
        consumeMP(skillCost);
        target.receiveDamage(skillDamage);
        System.out.println(target.name + "이(가) " + skillDamage + " 데미지를 받았습니다.");
    }
}
