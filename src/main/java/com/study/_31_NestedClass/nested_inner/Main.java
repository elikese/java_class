package com.study._31_NestedClass.nested_inner;

public class Main {
    public static void main(String[] args) {

        // static이 없는 내부 클래스는 외부 인스턴스 없이는 독립적으로 생성 불가능.
        // 바깥 인스턴스가 생성되고 -> 내부클래스가 생성되어야 한다.
//      Question.Choice choice = new Question.Choice("선택지", 1);  // 컴파일 에러


        // Question 객체 생성
        Question q1 = new Question(1, "내부 클래스의 특징으로 올바른 것은?");

        // 바깥 인스턴스가 존재하면, 생성은 가능 하지만 권장 x
        // 내부 생성자를 private로 제한해서
        // 바깥클래스가 메서드를 통해 외부에서 접근하게 설계하는게 권장
//        Question.Choice choice = q1.new Choice("선택지", 1);

        // 선택지 추가
        q1.addChoice(0, "static 키워드가 필요하다");
        q1.addChoice(1, "바깥 클래스의 인스턴스에 소속된다");
        q1.addChoice(2, "독립적으로 존재할 수 있다");
        q1.addChoice(3, "바깥 클래스의 멤버에 접근할 수 없다");



        // 정답 설정 (2번이 정답)
        q1.setCorrectAnswer(2);

        // 문제 출력
        q1.printQuestion();

        // 정답 확인
        q1.checkAnswer(2); // 정답
        System.out.println();
        q1.checkAnswer(1); // 오답


        /*
        !내부 클래스 사용 시 주의 사항!

        Choice 인스턴스는 반드시 Question 인스턴스 안에서만 생성될 수 있다.
        → 즉, Choice는 항상 자신을 감싸고 있는 바깥쪽 Question 객체를 참조하고 있는 상태이다.

        그런데 Question 객체는 더 이상 사용되지 않아 GC(Garbage Collector)에 의해 수거되어야 하는 상황인데,
        만약 Choice 인스턴스가 외부로 노출되어 다른 객체들이 계속 들고 있게 된다면,
        Choice 내부에서 참조 중인 Question도 함께 메모리에 남게 되어,
        결과적으로 GC 대상이 되지 못한다.

        → 즉, Question은 사용되지 않는데도 메모리에서 사라지지 않게 되고,
           이것이 곧 메모리 누수(Memory Leak)로 이어진다.

        따라서, 아래와 같은 방법으로 내부 클래스를 안전하게 설계해야 한다.

        1. 내부 클래스의 생성자를 private으로 만들어 외부에서 직접 생성하지 못하게 막는다.
        2. 내부 클래스는 Question 클래스의 메서드를 통해서만 생성되도록 제한하고,
           생성된 객체는 외부에 노출되지 않도록 Question의 private 필드에만 저장한다.
        */


    }
}
