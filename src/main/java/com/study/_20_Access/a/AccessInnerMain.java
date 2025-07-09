package com.study._20_Access.a;

public class AccessInnerMain {

    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public - 접근 가능 ✅
        data.publicField = 1;
        data.publicMethod();

        // default - 같은 패키지라서 접근 가능 ✅
        data.defaultField = 2;
        data.defaultMethod();

        // private - 다른 클래스라서 접근 불가 ❌
        // data.privateField = 3;    // 컴파일 에러!
        // data.privateMethod();     // 컴파일 에러!

        data.innerAccess();  // public 메서드를 통해 내부 접근
    }
}
