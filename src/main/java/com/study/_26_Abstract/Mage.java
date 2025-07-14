package com.study._26_Abstract;

public class Mage extends GameCharacter{

    public Mage(String name) {
        // 마법사: 낮은 체력, 높은 공격력
        super(name, 80, 30);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + "이(가) " + target.name + "에게 마법 미사일을 발사합니다!");
        target.receiveDamage(attackDamage);
        System.out.println(target.name + "이(가) " + attackDamage + " 데미지를 받았습니다.");
    }

}
