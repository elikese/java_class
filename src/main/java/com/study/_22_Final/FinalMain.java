package com.study._22_Final;

public class FinalMain {
    public static void main(String[] args) {

        // final : 반드시 "한번"만 "초기화" 되어야 함!

        // 방법 1: 선언과 초기화를 분리
        final int data1;
//        System.out.println(data1); // 초기화 전엔 사용 불가능
        data1 = 10;      // 최초 한 번만 값 할당 가능
        // data1 = 20;   // 컴파일 에러! 이미 할당됨

        // 방법 2: 선언과 동시에 초기화
        final int data2 = 20;
        // data2 = 30;   // 컴파일 에러! 이미 할당됨

        FinalStudent student1 = new FinalStudent("김자바", 202500001, 20);
        student1.printInfo();

        // 나이는 변경 가능
        student1.setAge(21);
        student1.printInfo();

        final FinalStudent student2 = new FinalStudent("이자바", 202500002, 20);

        // 참조값 자체는 변경 불가
        // student2 = new FinalStudent("이자바", 202500002, 21);  // 컴파일 에러!

        // 하지만 객체 내부 상태는 변경 가능
        student2.setAge(21);  // age는 final이 아니므로 변경 가능!
        student2.printInfo();

        // 결론: final은 스택에 있는 변수가 저장하고 있는 값(원시형값 or 참조형 주소)을 변경하지 못하게 하는 것


    }
}
