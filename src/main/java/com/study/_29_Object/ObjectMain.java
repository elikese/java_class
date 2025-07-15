package com.study._29_Object;

public class ObjectMain {
    public static void main(String[] args) {

        /*
         * 1. toString() 동작 확인
         *
         * System.out.println()은 내부적으로 객체의 toString() 메서드를 호출
         * obj.toString()과 obj를 직접 출력하는 것은 동일한 결과
         */
        System.out.println("=== toString() 동작 확인 ===");

        ObjectStudent student1 = new ObjectStudent("김철수", 20);
        System.out.println("명시적 toString() 호출: " + student1.toString());
        System.out.println("암시적 toString() 호출: " + student1);

        /*
         * 2. Object 다형성 동작 확인
         *
         * Object는 모든 클래스의 최상위 부모이므로 모든 객체를 참조할 수 있음
         * 이를 통해 서로 다른 타입의 객체를 하나의 배열에 저장 가능
         */
        System.out.println("\n=== Object 다형성 ===");

        Object obj1 = new ObjectStudent("이영희", 22);  // 업캐스팅
        Object obj2 = "Hello World";             // String도 Object 상속
        Object obj3 = Integer.valueOf(42);       // Integer도 Object 상속

        Object[] objects = {obj1, obj2, obj3, Double.valueOf(3.14)};

        System.out.println("Object 배열의 모든 요소 출력:");
        for (Object obj : objects) {
            // 컴파일 타임에는 Object의 toString() 호출로 보이지만
            // 런타임에는 실제 객체의 오버라이드된 toString() 호출 (동적 바인딩)
            System.out.println("- " + obj + " (실제 타입: " + obj.getClass().getSimpleName() + ")");
        }

        /*
         * 3. 동일성(Identity) vs 동등성(Equality) 비교
         *
         * 동일성(==): 두 참조 변수가 같은 객체 인스턴스를 가리키는지 확인
         * 동등성(equals): 두 객체의 내용이 논리적으로 같은지 확인
         */
        System.out.println("\n=== 동일성 vs 동등성 ===");

        ObjectStudent s1 = new ObjectStudent("박민수", 25);
        ObjectStudent s2 = new ObjectStudent("박민수", 25);  // 동일한 내용, 다른 인스턴스
        ObjectStudent s3 = s1;                        // 같은 인스턴스 참조

        // 동일성 비교 (참조 주소 비교)
        System.out.println("s1 == s2 (동일성): " + (s1 == s2));  // false
        System.out.println("s1 == s3 (동일성): " + (s1 == s3));  // true

        // 동등성 비교 (내용 비교)
        System.out.println("s1.equals(s2) (동등성): " + s1.equals(s2));  // true
        System.out.println("s1.equals(s3) (동등성): " + s1.equals(s3));  // true

        /*
         * 4. hashCode() 규약 확인
         *
         * equals()가 true를 반환하는 두 객체는 반드시 같은 hashCode를 가져야 함
         * 이 규약을 어기면 HashMap, HashSet 등에서 예상과 다른 동작 발생
         */
        System.out.println("\n=== hashCode() 규약 확인 ===");

        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());

        boolean equalsResult = s1.equals(s2);
        boolean hashCodeResult = s1.hashCode() == s2.hashCode();

        System.out.println("s1.equals(s2): " + equalsResult);
        System.out.println("s1과 s2의 hashCode가 같음: " + hashCodeResult);
        System.out.println("equals가 true이면 hashCode도 같아야 함: " +
                (equalsResult == hashCodeResult));

        /*
         * 5. getClass() 메서드 사용
         *
         * 객체의 런타임 클래스 정보를 반환
         * instanceof와 달리 정확히 같은 클래스인지 확인 가능
         */
        System.out.println("\n=== getClass() 메서드 ===");

        ObjectStudent student = new ObjectStudent("최학생", 19);
        String str = "Hello";

        System.out.println("student.getClass(): " + student.getClass());
        System.out.println("str.getClass(): " + str.getClass());

        // 클래스명만 간단히 출력
        System.out.println("student 클래스명: " + student.getClass().getSimpleName());
    }
}
