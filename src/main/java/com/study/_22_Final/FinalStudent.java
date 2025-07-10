package com.study._22_Final;

public class FinalStudent {
    // final 필드 (한 번 초기화되면 변경 불가)
    private final String name;  // 이름은 바뀌지 않음
    private final int studentId;  // 학번도 불변
    private int age;

    // 생성자를 통해 초기화 (final 필드는 반드시 초기화되어야 함)
    public FinalStudent(String name, int studentId, int age) {
        this.name = name;
        this.studentId = studentId;
        this.age = age;
    }

    // final parameter 예시: 외부에서 받은 값을 변경하지 않겠다는 의미
    public void printInfo(final String SchoolName) {
//         SchoolName = 자바; 컴파일 에러
        System.out.println("학교명: " + SchoolName + "학생 이름: " + name + " 학번: " + studentId);
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    // 이런 메서드는 만들 수 없음 (final 필드라서)
    // public void setStudentId(String studentId) {
    //     this.studentId = studentId;  // 컴파일 에러!
    // }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo() {
        System.out.println("학번: " + studentId);
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }

}
