package com.study._20_Access.a;

public class AccessData {
    // 필드들 - 각각 다른 접근 제어자
    public int publicField;      // 모든 곳에서 접근 가능
    int defaultField;            // 같은 패키지에서만 접근 가능
    private int privateField;    // 이 클래스 내부에서만 접근 가능

    // 메서드들 - 각각 다른 접근 제어자
    public void publicMethod() {
        System.out.println("publicMethod 호출 " + publicField);
    }

    void defaultMethod() {  // default 접근 제어자 (명시하지 않음)
        System.out.println("defaultMethod 호출 " + defaultField);
    }

    private void privateMethod() {
        System.out.println("privateMethod 호출 " + privateField);
    }

    // 내부에서는 모든 것에 접근 가능
    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 200;
        privateField = 300;   // private이지만 같은 클래스 내부라서 OK

        publicMethod();
        defaultMethod();
        privateMethod();      // private이지만 같은 클래스 내부라서 OK
    }


}
