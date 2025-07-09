package com.study._20_Access.b;

import com.study._20_Access.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public - 다른 패키지여도 접근 가능 ✅
        data.publicField = 1;
        data.publicMethod();

        // default - 다른 패키지라서 접근 불가 ❌
        // data.defaultField = 2;    // 컴파일 에러!
        // data.defaultMethod();     // 컴파일 에러!

        // private - 당연히 접근 불가 ❌
        // data.privateField = 3;    // 컴파일 에러!
        // data.privateMethod();     // 컴파일 에러!

        data.innerAccess();  // public 메서드는 사용 가능
    }
}
