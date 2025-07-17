package com.study._33_Factory;

public class Main {
    public static void main(String[] args) {
        // of(): 일반적인 정적 생성 방식 (생성자 대체)
        Student s1 = Student.of("김철수", 2);
        System.out.println(s1);  // 김철수, 2학년

        // valueOf(): 이름이 캐시된 값이면 기존 객체 재사용
        Student s2 = Student.valueOf("홍길동");
        Student s3 = Student.valueOf("홍길동"); // 캐시된 같은 객체 반환
        System.out.println("s2 == s3: " + (s2 == s3)); // true → 캐싱 확인

        // newInstance(): 항상 새로운 객체를 반환 (캐싱 없음)
        Student s4 = Student.newInstance("이영희");
        System.out.println(s4);  // 이영희, 1학년 (newInstance로 새로 생성)

        // from(): 외부에서 전달받은 DTO로부터 변환해서 객체 생성
        StudentDto dto = new StudentDto("박영수", 3);
        Student s5 = Student.from(dto);

        // copyOf(): 기존 Student 객체의 값을 복사해서 새 객체 생성
        Student s6 = Student.copyOf(s1);
        System.out.println(s6);  // 김철수, 2학년 복사본
        System.out.println("s1 == s6: " + (s1 == s6)); // 값만 복사

    }
}
