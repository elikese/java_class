package com.study._19_Constructor;

public class Student {
    String name;
    int korean;
    int english;
    int math;

    int getTotalScore() {
        return korean + english + math;
    }

    /*
     * === 생성자의 특징 ===
     * 1. 클래스 이름과 동일해야 함 (Student)
     * 2. 반환 타입이 없음 (void도 쓰지 않음)
     * 3. 객체 생성 시(new) 자동으로 호출됨
    */


    public Student(String name, int korean, int english, int math) {
        System.out.println("생성자 호출 - " + name + " 학생 정보 등록");

        /*
         * this 키워드 - 나 자신을 가리키는 키워드
         * this는 현재 객체 자신을 가리키는 참조값(주소)이다.
         * 직접접근해서 객체주소를 담은 변수(student1)
         * student1.name = "홍길동";
         * this.name = "홍길동";
         *
         * 왜 필요한가?
         * - 매개변수 이름과 필드 이름이 같을 때 구분하기 위해
         * - this.name = name; 에서
         *   왼쪽은 객체의 필드, 오른쪽은 매개변수
         */

        /*
         * === this 키워드에 대한 심화 설명 ===
         *
         * - this는 현재 객체 자신을 가리키는 참조값(주소)이다.
         * - 자바에서 객체는 힙(Heap) 영역에 생성되고,
         *   this는 그 힙에 있는 해당 객체의 메모리 주소를 참조한다.
         *
         * - 메서드들은 클래스 단위로 메서드 영역(Method Area)에 단 한 번만 올라가고,
         *   모든 객체는 이 메서드를 공유해서 사용한다.
         *   이때 호출 주체가 누구인지 구분하기 위해 this를 전달한다.
         *
         *
         * [JVM 메모리 관점에서 보는 this]
         * - 객체는 Heap 영역에 생성된다.
         * - 클래스의 메서드, 생성자 등은 Method Area에 단 한 번 로드된다.
         * - 객체가 메서드를 호출하면, JVM은 해당 메서드에 this(참조값)를 넘겨준다.
         * - this는 현재 메서드를 호출한 객체의 주소를 담고 있다.
         * - 이를 통해 같은 메서드 코드라도, 각기 다른 객체의 상태를 처리할 수 있다.
         *
         * 예시:
         *   Student s1 = new Student(...);  // s1의 주소 → this
         *
         * - 매개변수와 필드 이름이 같을 때, this.name을 사용해
         *   "객체의 필드"와 "전달된 파라미터"를 명확히 구분할 수 있다.
         */

        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // 생성자도 오버로딩 가능
    // 이름만 받는 생성자 - 점수는 모두 0점
    Student(String name) {
        this.name = name;
        System.out.println("이름만 받는 생성자 호출");
    }

    // 3. 이름과 국어 점수만 받는 생성자
    Student(String name, int korean) {
        this(name, korean, 0, 0);
        // this()
        // this != this() 아예 상관이 없음. 인도 != 인도네시아
        // 같은 이름의 생성자 호출(오버로딩 된)
        // 제약사항: 생성자의 가장 첫 줄에 적어줘야 한다.


        System.out.println("이름, 국어점수 생성자 호출");
    }
}
