package com.study._33_Factory;

public class StudentDto {
    /*
     * DTO (Data Transfer Object)
     * - 데이터를 '운반'하는 데 사용되는 단순한 데이터 객체입니다.
     * - 로직은 없고, 오직 '데이터만 담는 용도'로 사용합니다.
     */

    private String name;
    private int grade;

    public StudentDto(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
