package com.study._41_StreamApi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("김자바", "컴퓨터공학", 92, "010-1111-1111", "kim@secret.com"),
                new Student("이파이썬", "컴퓨터공학", 88, "010-2222-2222", "lee@secret.com"),
                new Student("박경영", "경영학", 76, "010-3333-3333", "park@secret.com"),
                new Student("최경영", "경영학", 84, "010-4444-4444", "choi@secret.com"),
                new Student("정노드", "컴퓨터공학", 91, "010-5555-5555", "jung@secret.com"),
                new Student("한삼성", "전자공학", 79, "010-6666-6666", "han@secret.com")
        );

        /*
         * [필기] 패턴 1: Entity → DTO 변환
         *
         * 실무에서 가장 많이 사용하는 패턴!
         * - Entity의 민감한 정보를 제외하고 DTO로 변환
         * - 추가 계산 로직 포함 (점수 → 등급, 상태 변환)
         * - map() 안에서 직접 람다로 변환 로직 작성
         */

        System.out.println("\n=== 패턴 1: Entity → DTO 변환 ===");

        // 모든 학생을 DTO로 변환 (map 안에서 직접 변환)
        List<StudentDto> studentDtos = students.stream()
                .map(student -> {  // Function<Student, StudentDto>
                    // 점수 → 등급 변환
                    String grade;
                    if (student.getScore() >= 90) grade = "A";
                    else if (student.getScore() >= 80) grade = "B";
                    else if (student.getScore() >= 70) grade = "C";
                    else grade = "F";

                    // 민감정보 제거하고 계산된 필드 추가해서 DTO 생성
                    return new StudentDto(student.getName(), student.getMajor(), grade);
                })
                .collect(Collectors.toList());

        System.out.println("Entity → DTO 변환 결과 (민감정보 2개 제거 + 계산필드 1개 추가):");
        System.out.println("변환 전 - Entity (전화번호, 이메일 포함):");
        students.forEach(student -> System.out.println(student));

        System.out.println("\n변환 후 - DTO (민감정보 제거, 등급 추가):");
        studentDtos.forEach(dto -> System.out.println(dto));

        /*
         * [필기] 패턴 2: 조건 필터링 + 정렬 + 수집
         *
         * 실무 예시: API에서 "우수 학생만 조회해서 성적순으로 정렬"
         * - filter로 조건 필터링
         * - sorted로 정렬
         * - collect로 결과 수집
         */

        System.out.println("\n=== 패턴 2: 우수 학생 조회 (80점 이상, 성적순 정렬) ===");

        List<StudentDto> topStudents = students.stream()
                .filter(student -> student.getScore() >= 80)                   // Predicate<Student> - 80점 이상
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())             // Comparator<Student> - 내림차순 (높은 점수부터)
                .map(student -> {  // Function<Student, StudentDto> - 직접 변환
                    String grade = student.getScore() >= 90 ? "A" : "B";
                    return new StudentDto(student.getName(), student.getMajor(), grade);
                })
                .collect(Collectors.toList());

        System.out.println("80점 이상 학생들 (성적순):");
        topStudents.forEach(student -> System.out.println(student));

        /*
         * [필기] 패턴 3: 조건 검사 (anyMatch, allMatch)
         *
         * 실무 예시: "90점 이상 학생이 있는지 확인"
         * - anyMatch로 존재 여부 확인
         * - allMatch로 전체 조건 만족 확인
         */

        System.out.println("\n=== 패턴 3: 조건 검사 ===");

        boolean has90Plus = students.stream()
                .anyMatch(student -> student.getScore() >= 90);  // Predicate<Student>

        boolean allPass = students.stream()
                .allMatch(student -> student.getScore() >= 60);  // Predicate<Student>

        System.out.println("90점 이상 학생 존재? " + has90Plus);
        System.out.println("모든 학생이 60점 이상? " + allPass);

        /*
         * [필기] 패턴 4: 상위 N명 조회
         *
         * 실무 예시: "성적 상위 3명 조회"
         * - sorted + limit + collect 조합
         */

        System.out.println("\n=== 패턴 4: 성적 상위 3명 ===");

        List<Student> top3 = students.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore())) // Comparator<Student> - 내림차순
                .limit(3)                                                          // 상위 3명만
                .collect(Collectors.toList());

        System.out.println("성적 상위 3명:");
        for (int i = 0; i < top3.size(); i++) {
            Student student = top3.get(i);
            System.out.println((i+1) + "등 - " + student.getName() + ": " + student.getScore());
        }

        /*
         * [필기] 패턴 5: 복합 조건 필터링
         *
         * 실무 예시: "컴퓨터공학과 중에서 85점 이상인 학생들"
         * - 여러 filter 체이닝
         */

        System.out.println("\n=== 패턴 5: 복합 조건 (컴퓨터공학과 + 90점 이상) ===");

        List<StudentDto> csTopStudents = students.stream()
                .filter(student -> student.getMajor().equals("컴퓨터공학"))    // Predicate<Student>
                .filter(student -> student.getScore() >= 90)                 // Predicate<Student>
                .map(student -> {  // Function<Student, StudentDto> - 컴퓨터공학과 우수학생만 변환
                    String grade = "A";     // 85점 이상이므로 A등급
                    return new StudentDto(student.getName(), student.getMajor(), grade);
                })
                .collect(Collectors.toList());

        System.out.println("컴퓨터공학과 90점 이상 학생:");
        csTopStudents.forEach(student -> System.out.println("  " + student));

        /*
         * [필기] 패턴 6: 특정 조건의 학생 이름만 추출
         *
         * 실무 예시: "80점 이상 학생들의 이름만 리스트로 추출"
         * - filter + map(이름만) + collect
         */

        // 80점 이상인 학생들만 추출
        List<String> topStudentNames = students.stream()
                .filter(student -> student.getScore() >= 80)        // Predicate<Student>
                .map(student -> student.getName())                  // Function<Student, String> - 이름만 추출
                .collect(Collectors.toList());

        System.out.println("80점 이상 학생 이름들:");
        topStudentNames.forEach(name -> System.out.println("  - " + name));

        // 추가: 전공명만 추출 (중복 제거)
        List<String> majorNames = students.stream()
                .map(student -> student.getMajor())                 // Function<Student, String> - 전공만 추출
                .distinct()                                         // 중복 제거
                .collect(Collectors.toList());

        System.out.println("\n전체 전공 목록:");
        majorNames.forEach(major -> System.out.println("  - " + major));

        /*
         * [필기] 패턴 7: 총 개수 계산
         *
         * 실무 예시: "80점 이상 학생은 몇 명인가?"
         * - filter + count 조합
         */

        System.out.println("\n=== 패턴 7: 조건별 개수 계산 ===");

        // 80점 이상 학생 수
        long topStudentCount = students.stream()
                .filter(student -> student.getScore() >= 80)        // Predicate<Student>
                .count();                                           // 개수 세기

        // 컴공 학생 수
        long csStudentCount = students.stream()
                .filter(student -> student.getMajor().equals("컴퓨터공학"))
                .count();

        System.out.println("80점 이상 학생 수: " + topStudentCount + "명");
        System.out.println("컴퓨터공학과 학생 수: " + csStudentCount + "명");
    }
}
