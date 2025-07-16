package com.study._33_Factory;

public class Student {
    /*
     * 이 클래스는 GoF에서 말하는 "Factory Method Pattern"과는 다릅니다!
     * - 여기서는 생성자를 대신하는 정적 메서드를 제공할 뿐입니다.
     * - 따라서 이것은 "디자인 패턴"이라기보다는 "객체 생성 기법"입니다.
     *
     * => 생성자보다 더 유연하게 객체 생성을 제어할 수 있습니다.
     */

    private String name;
    private int grade;

    // 생성자를 private으로 숨깁니다.
    private Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // 1. of() : 단순한 정적 생성
    public static Student of(String name, int grade) {
        return new Student(name, grade);
    }

    // 2. valueOf() : 이름이 같은 학생이면 캐싱처럼 동일 객체 반환 (단순 예시)
    private static final Student[] cache = new Student[] {
            new Student("홍길동", 1),
            new Student("김철수", 2),
            new Student("이영희", 3)
    };

    public static Student valueOf(String name) {
        for (Student s : cache) {
            if (s.name.equals(name)) {
                return s; // 캐싱된 객체 반환
            }
        }
        return new Student(name, 1); // 새로운 객체 생성
    }

    // 3. newInstance() : 항상 새로운 객체를 반환
    public static Student newInstance(String name) {
        return new Student(name, 1); // 기본 학년은 1학년
    }

    // 4. from() : 다른 타입(예: DTO)에서 변환해서 생성
    public static Student from(StudentDto dto) {
        return new Student(dto.getName(), dto.getGrade());
    }

    // 5. copyOf() : 기존 객체를 복사
    public static Student copyOf(Student other) {
        return new Student(other.name, other.grade);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}
