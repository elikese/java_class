package com.study._23_OOP2;

public class School {
    private String name;
    // 배열을 통한 일대다 관계: 한 학교는 여러 학생을 가질 수 있음
    private Student[] students;  // 학생들을 저장할 배열
    private int studentCount;    // 현재 등록된 학생 수 (배열의 실제 사용 크기)
    private static final int MAX_STUDENTS = 10;  // 최대 학생 수

    public School(String name) {
        this.name = name;
        // 고정 크기 배열 생성 - 최대 100명의 학생 수용 가능
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;  // 처음에는 학생이 없음
    }

    /**
     * 객체간 상호작용: 새로운 학생 객체를 배열에 추가
     * 중복 방지 로직과 배열 크기 체크로 데이터 무결성 보장
     */
    public void addStudent(Student student) {
        // 배열이 가득 찬 경우 체크
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("학교 정원이 가득 참니다. 더 이상 학생을 등록할 수 없습니다.");
            return;
        }

        // 배열의 다음 빈 자리에 학생 추가
        students[studentCount] = student;
        studentCount++;  // 학생 수 증가




        // student.setSchool(this)를 호출하지 않는 이유
        // School은 단순히 학생 목록만 관리
        // 학생의 상태(어느 학교 소속인지)는 School 입장에선 알 바가 아니다.(책임을 분리 해야한다)
        // 학생과 학교를 연결하는 건 Service의 역할
        // Service 계층에서 양방향 관계를 관리
    }

    public String getName() {
        return name;
    }

    /**
     * 현재 등록된 학생 수 반환
     * 배열의 실제 크기가 아닌, 실제로 사용 중인 크기 반환
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * 특정 인덱스의 학생 반환
     * 배열 직접 접근 대신 메서드를 통한 안전한 접근 제공
     */
    public Student getStudent(int index) {
        if (index >= 0 && index < studentCount) {
            return students[index];
        }
        return null;  // 잘못된 인덱스면 null 반환
    }

}
