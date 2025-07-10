package com.study._23_OOP2;

public class Student {

    // 캡슐화: private으로 데이터 은닉
    private String name;
    private int grade;
    private School school;  // 연관관계: 한 학생은 하나의 학교에 소속

    /**
     * 생성자: 객체 생성 시 기본 정보만 설정
     * 학교는 나중에 등록 과정을 통해 설정됨 (객체간 상호작용)
     */
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        // school은 null로 시작 - 아직 어떤 학교에도 소속되지 않음
    }

    /**
     * 객체간 상호작용: 다른 객체(School)와의 관계 설정
     * 이 메서드는 보통 Service 클래스에서 호출됨
     */
    public void setSchool(School school) {
        this.school = school;
    }

    // 캡슐화: private 필드에 안전하게 접근하는 getter 메서드들
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    /**
     * 연관된 객체 반환: 다른 객체들이 이 학생의 학교 정보를 알 수 있게 함
     * 객체간 상호작용의 기본 - 참조를 통한 다른 객체 접근
     */
    public School getSchool() {
        return school;
    }


    public void printInfo() {
        System.out.println("이름: " + name + ", 학년: " + grade +
                ", 학교: " + (school != null ? school.getName() : "없음"));
        // null 체크: 연관된 객체가 없을 수도 있음을 고려한 안전한 코딩
        // printInfo에서 school.getName()을 호출
        // 객체가 다른 객체의 정보를 사용하는 방법
    }
}
