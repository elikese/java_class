package com.study._23_OOP2;

public class Main {
    public static void main(String[] args) {
        // === 1단계: 객체 생성 ===
        // 개별 객체들 생성 - 아직 서로 독립적인 상태
        Student s1 = new Student("홍길동", 1);
        Student s2 = new Student("김철수", 2);
        Student s3 = new Student("이영희", 3);
        Student s4 = new Student("박민수", 1);

        School school1 = new School("자바학교");
        School school2 = new School("파이썬학교");

        // 서비스 객체 생성 - 다른 객체들 사이의 상호작용을 관리할 중재자
        Service service = new Service();

        // === 2단계: 객체간 관계 설정 (등록) ===
        System.out.println("=== 학생 등록 ===");
        // 서비스를 통한 객체간 관계 설정 - Student와 School이 서로를 알게 됨
        service.register(s1, school1);
        service.register(s2, school1);
        service.register(s3, school2);
        service.register(s4, school1);

        // === 3단계: 설정된 관계 확인 ===
        System.out.println("\n=== 학교별 학생 목록 ===");
        // 객체간 협력으로 정보 출력 - School → Student들 → 각자의 정보
        service.printAllStudents(school1);
        System.out.println();
        service.printAllStudents(school2);

        // === 4단계: 학교 정보 확인 ===
        System.out.println("\n=== 학교 정보 ===");
        service.printSchoolInfo(school1);
        System.out.println();
        service.printSchoolInfo(school2);

        // === 5단계: 개별 객체 상태 확인 ===
        System.out.println("\n=== 학생 개별 정보 ===");
        // 각 Student 객체가 자신의 현재 상태 (연관된 School 포함) 출력
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
        s4.printInfo();

        // 핵심 학습 포인트:
        // 1. regiser() -> student.setSchool() + school.addStudent() => 양방향 연관관계 설정
        // 2. student.getSchool().getName() => 객체 탐색
        // 3. 배열 순회로 연관된 객체들 접근
        // 4. 각 객체가 자신의 책임만 수행
    }
}
