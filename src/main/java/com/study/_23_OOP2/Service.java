package com.study._23_OOP2;

public class Service {
    /**
     * Service 클래스 - 학생과 학교 관련 비즈니스 로직 처리
     *
     * OOP 특징:
     * 1. 단일 책임 원칙: 학생-학교 관련 모든 업무를 담당
     * 2. 객체간 협력의 중재자: Student와 School 객체 사이의 상호작용을 조율
     */

    /**
     * 학생 등록: 두 객체(Student, School) 사이의 양방향 관계 설정
     *
     * 객체간 상호작용의 핵심:
     * 1. Student 객체에게 School 정보를 알려줌 (student.setSchool())
     * 2. School 객체에게 Student를 추가하라고 요청 (school.addStudent())
     * 3. 양방향 관계가 일관성 있게 설정됨
     */
    public void register(Student student, School school) {
        // 방어적 프로그래밍: null 객체로 인한 오류 방지
        if (student == null || school == null) {
            System.out.println("학생 또는 학교 정보가 없습니다.");
            return;
        }

        // 객체간 상호작용 1: 학생 객체의 상태 변경
        student.setSchool(school);     // 학생에 학교 연결

        // 객체간 상호작용 2: 학교 객체의 상태 변경
        school.addStudent(student);    // 학교에 학생 추가

        // 객체간 협력: 두 객체의 정보를 조합해서 결과 출력
        System.out.println(student.getName() + " 학생이 " + school.getName() + "에 등록되었습니다.");
    }

    /**
     * 학교의 모든 학생 정보 출력
     *
     * 객체간 협력 과정:
     * 1. School 객체로부터 학생 배열 획득
     * 2. 각 Student 객체에게 자신의 정보 출력 요청
     * 3. 여러 객체가 협력해서 전체 정보 완성
     */
    public void printAllStudents(School school) {
        if (school == null) {
            System.out.println("학교 정보가 없습니다.");
            return;
        }

        System.out.println("[" + school.getName() + "]의 재학생 목록:");

        // 객체간 협력: School 객체에게 학생 수 요청
        if (school.getStudentCount() == 0) {
            System.out.println("재학생이 없습니다.");
        } else {
            // 향상된 for문으로 배열 순회: 각 Student 객체에게 정보 출력 요청
            // 배열 순회하며 각 학생 정보 출력
            for (int i = 0; i < school.getStudentCount(); i++) {
                Student student = school.getStudent(i);
                student.printInfo();
            }
        }
    }

    /**
     * 학교 기본 정보 출력
     * 객체의 상태를 조회해서 의미 있는 정보로 가공
     */
    public void printSchoolInfo(School school) {
        if (school == null) {
            System.out.println("학교 정보가 없습니다.");
            return;
        }

        System.out.println("학교명: " + school.getName());
        // 연관된 객체들의 개수를 통한 통계 정보 제공
        System.out.println("재학생 수: " + school.getStudentCount() + "명");
    }
}
