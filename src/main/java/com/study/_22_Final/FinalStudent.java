package com.study._22_Final;

public class FinalStudent {
    // final 필드 (한 번 초기화되면 변경 불가)
    private final String name;  // 이름은 바뀌지 않음
    private final int studentId;  // 학번도 불변

    // 생성자를 통해 초기화 (final 필드는 반드시 초기화되어야 함)
    public FinalStudent(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // final parameter 예시: 외부에서 받은 값을 변경하지 않겠다는 의미
    public void printInfo(final String prefix) {
        // prefix = prefix + "변경"; // 컴파일 에러
        System.out.println(prefix + "학생 이름: " + name + ", 학번: " + studentId);
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }


}
