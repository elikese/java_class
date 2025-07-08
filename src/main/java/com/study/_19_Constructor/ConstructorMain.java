package com.study._19_Constructor;

public class ConstructorMain {
    public static void main(String[] args) {
        //  생성자는 객체를 만들 때(new 연산자) 호출되는 메서드
        NoConstructorStudent student = new NoConstructorStudent();
        student.name = "홍길동";
        student.korean = 90;
        student.english = 90;
        student.math = 80;
        // 일일이 직접 접근해서 필드 값들을 초기화 해줘야 함
        // 생성자를 아무것도 정의하지 않으면, 기본 생성자를 자바가 만들어 줌

        // 모든 필드를 초기화해주는 생성자를 정의
        // 한줄에 모든 필드값 초기화 가능
        Student student1 = new Student("홍길동", 90, 90, 80);
        Student student2 = new Student("김길동", 80, 70, 70);


        // Method Area
        // JVM = stack + heap + Method Area + ...
        // 클래스의 정보를 저장하고 있는 메모리 영역
        // 클래스에 정의된 메서드도 저장되어 있다 -> 메서드는 객체끼리 돌려쓴다.
        System.out.println("홍길동 총점: " + student1.getTotalScore());
        System.out.println("김길동 총점: " + student2.getTotalScore());

        // 서로 다른 객체라 해서 서로 다른 동작(메서드)를 해야할까?
        // 서로 다른 객체라 해서 각각 메서드를 메모리에 띄울 필요가 없다.
        // method area에 메서드가 정의 되어 있고,
        // 객체가 가진 메서드 호출시, this(자기자신의 주소)가 전달되어
        // 자기자신의 필드값에 알맞게 메서드가 동작된다.








    }
}
