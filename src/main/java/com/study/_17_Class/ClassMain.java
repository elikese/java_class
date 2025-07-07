package com.study._17_Class;

public class ClassMain {
    public static void main(String[] args) {

        /*
        클래스 -> 새로운 참조 자료형을 정의 하는 것
        학생점수를 관리한다고 생각

        (학생이름, 국어점수, 영어점수, 수학점수) -> 한 셋트
        데이터 셋트를 정의 해 주는게 클래스
         */

        // null은 자바에서 **"참조형 변수가 아무런 객체도 연결되지 않은 상태(주소값이 없는 상태)"**
        // stack에서 0x0010같은 주소 값이 있어야하는데,
        // 아직 할당되지 않았거나, 연결이 끊어질 경우, 현재 주소가 없다는 상태를 표현하기 위해 null이라 표현.


        Student student1; // Student 타입의 "student1" 변수 선언 -> 스택에 student1 생성
        student1 = new Student();
        // Student클래스의 객체 생성 -> heap에 빈 메모리공간(객체) 생성
        // student1에는 heap의 메모리 주소값을 복사해서 대입

        student1.name = "홍길동"; // 필드값 접근
        student1.korean = 90;
        student1.english = 80;
        student1.math = 70;
        // heap에 생성된 객체 내부 필드에 값이 저장됨
        // student1.name의 의미:
        // "student1의 name이 저장하고 있는 값을 의미"
        // arr[1] -> arr의 index 1에 접근

        /*
        stack (main)
        -----------------------------
        student1 : 0x1000
        -----------------------------

        heap
        0x1000: Student 객체정보
        0x1010: 0x2000
        0x1014: korean : 90
        0x1018: english : 80
        0x101C: math : 70

        0x2000: "홍길동" 문자열 객체
            └── byte[]: ['홍', '길', '동']
         */

        System.out.println("학생이름: " + student1.name);
        System.out.println("국어점수: " + student1.korean);
        System.out.println("영어점수: " + student1.english);
        System.out.println("수학점수: " + student1.math);

        Student student2 = new Student(); // 선언과 생성을 동시에
        student2.name = "김길동";
        student2.korean = 100;
        student2.english = 100;
        student2.math = 40;

        System.out.println();
        System.out.println("학생이름: " + student2.name);
        System.out.println("국어점수: " + student2.korean);
        System.out.println("영어점수: " + student2.english);
        System.out.println("수학점수: " + student2.math);

        /*
        객체: 클래스로 부터 만들어진 데이터 메모리 실체(물리적 실체)
        인스턴스: 객체가 특정 클래스의 소속임을 명확히 하는 용어
        --- 두 용어를 혼용해서 사용하는 것이 일반적

        --- 또 다른 관점
        객체 -> 논리적 설계에서 쓰이는 개념
        인스턴스 -> 실제 프로그램 구동시에 생성되는 실체

        student1, student2는 객체다. (o)
        student1, student2는 인스턴스다. (o)
        student1, student2는 Student의 객체다. (o)
        student1, student2는 Student의 인스턴스다. (o)
         */


        /*
        1. Car 클래스를 정의하세요
        다음 필드를 포함하여야함
        String brand: 자동차 브랜드
        String model: 모델명
        int year: 출시년도

        2. ClassMain의 main 메서드 내에서
        Car 객체를 생성 하여 주세요
        생성한 Car 객체의 필드값들에 접근하여서
        
        최종적으로
        
        "현대-소나타-2023년식"을 출력해 주세요
         */

        Car car1 = new Car();
        car1.brand = "현대";
        car1.model = "소나타";
        car1.year = 2023;

        System.out.println(car1.brand + "-" + car1.model + "-" + car1.year + "년식");

    }
}
