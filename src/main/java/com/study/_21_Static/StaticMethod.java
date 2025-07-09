package com.study._21_Static;

public class StaticMethod {
    private int instanceValue;
    private static int staticValue;

    private static void anotherStaticMethod() {
        System.out.println("다른 static 메서드");
    }

    private void anotherInstanceMethod() {
        System.out.println("다른 인스턴스 메서드");
    }

    // static 메서드 -> static 변수만 사용가능
    public static void staticMethod() {
        // 가능: static 변수 사용
        staticValue++;

        // 가능: static 메서드 호출
        anotherStaticMethod();

        // 불가능: 인스턴스 변수 사용
        // instanceValue++;  // 컴파일 에러!

        // 불가능: 인스턴스 메서드 호출
        // instanceMethod();  // 컴파일 에러!
    }

    // 인스턴스 메서드
    public void instanceMethod() {
        // 가능: 인스턴스 변수 사용
        instanceValue++;

        // 가능: static 변수 사용 (공용이니까)
        staticValue++;

        // 가능: static 메서드 호출
        staticMethod();

        // 가능: 인스턴스 메서드 호출
        anotherInstanceMethod();
    }

    /*

    - static 변수와 static 메서드는 클래스가 로딩될 때
      JVM의 Method Area에 올라간다.
      → 즉, 프로그램이 시작되면(main 실행 시점) 이미 메모리에 존재한다.

    - instance 변수는
      객체가 생성될 때(new 연산자 실행 시점) heap에 할당된다.
      → 즉, 객체가 없으면 메모리에 존재하지 않는다.

    - instance 메서드 또한 static 메서드와 마찬가지로
      클래스 로딩 시 method area에 코드가 올라가 있다.
      → 하지만 instance 메서드는 실행 시 암묵적으로 this(인스턴스 주소)를 필요로 한다.
      → 즉, 단순히 코드가 올라가 있다는 이유만으로 호출할 수는 없다.
        (this가 없으면 누구의 메서드인지 판단 불가)

    그래서 static 메서드에서는 instance 멤버(변수/메서드)에 접근할 수 없다.

    반대로 instance 메서드는 객체가 생성된 후에 호출되므로,
       static 멤버든 instance 멤버든 모두 접근이 가능하다.
       (this도 있고, static도 클래스 단위로 항상 존재하므로)
 */

}
