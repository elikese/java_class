package com.study._27_Interface;

public interface Swimmable {

    void swim();
    /*
    can - do 에서 do를 쪼개는 이유
    SOLID에서 I에 해당하는
    Interface Segregation Principle(인터페이스 분리 원칙)
    - 구현체는 자신이 사용하지 않는 메서드는 의존하면 안된다.
    animal에 swim, fly를 정의해버리면, dog도 fly를 강제구현해야 함
    필요한 기능들끼리 묶어서 여러 인터페이스로 나눈 뒤,
    유연하게 조합해서 사용하라!
    */
}
