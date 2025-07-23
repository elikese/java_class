package com.study._41_StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperationMain {
    public static void main(String[] args) {
        /*
         * [필기] Stream 연산의 두 가지 종류
         *
         * 1. 중간 연산 (Intermediate Operations)
         *    - 자기자신을 반환하므로 체이닝 가능
         *    - 지연 연산: 최종 연산 호출 전까지 실행되지 않음
         *    - 예: filter, map, distinct, limit, skip
         *
         * 2. 최종 연산 (Terminal Operations)
         *    - 구체적인 결과를 반환 (Stream이 아님)
         *    - 실행의 시작점: 이것이 호출되어야 중간 연산들도 실행됨
         *    - 스트림을 소모시킴 (재사용 불가)
         *    - 예: collect, forEach, anyMatch, count
         */

        // 학습용 데이터 준비
        List<String> names = Arrays.asList("김자바", "이파이썬", "박스프링", "최코틀린", "김자바", "정리액트");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("=== 중간 연산들 (Intermediate Operations) ===");

        // 1. filter() - 조건 필터링
        System.out.println("--- filter(): 조건에 맞는 요소만 선택 ---");
        /*
         * [필기] filter(Predicate<T> predicate)
         * - 사용 함수형 인터페이스: Predicate<T>
         * - 시그니처: boolean test(T t)
         * - 역할: 각 요소를 받아서 true/false 반환 → true인 요소만 통과
         */

        List<String> kimNames = names.stream()
                .filter(name -> name.startsWith("김"))  // Predicate<String> 람다 직접 구현
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)  // Predicate<Integer> 람다 직접 구현
                .collect(Collectors.toList());

        System.out.println("김씨만 필터링 (Predicate<String>): " + kimNames);
        System.out.println("짝수만 필터링 (Predicate<Integer>): " + evenNumbers);

        // 2. map() - 데이터 변환
        System.out.println("\n--- map(): 각 요소를 변환 ---");
        /*
         * [필기] map(Function<T, R> mapper)
         * - 사용 함수형 인터페이스: Function<T, R>
         * - 시그니처: R apply(T t)
         * - 역할: T 타입을 받아서 R 타입으로 변환
         */

        List<String> upperNames = names.stream()
                .map(name -> name.toUpperCase())  // Function<String, String> 람다 직접 구현
                .collect(Collectors.toList());

        List<Integer> doubledNumbers = numbers.stream()
                .map(num -> num * 2)  // Function<Integer, Integer> 람다 직접 구현
                .collect(Collectors.toList());

        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())  // Function<String, Integer> 람다 직접 구현
                .collect(Collectors.toList());

        System.out.println("대문자 변환 (Function<String,String>): " + upperNames);
        System.out.println("2배 변환 (Function<Integer,Integer>): " + doubledNumbers);
        System.out.println("이름 길이 (Function<String,Integer>): " + nameLengths);

        // 3. distinct() - 중복 제거
        System.out.println("\n--- distinct(): 중복 요소 제거 ---");
        /*
         * [필기] distinct()
         * - 함수형 인터페이스 사용하지 않음
         * - 내부적으로 equals()와 hashCode() 사용
         * - 매개변수 없는 메서드
         */

        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("원본: " + names);
        System.out.println("중복 제거: " + uniqueNames);

        // 4. limit() & skip() - 개수 제한
        System.out.println("\n--- limit() & skip(): 개수 제한 ---");
        /*
         * [필기] limit(long maxSize), skip(long n)
         * - 함수형 인터페이스 사용하지 않음
         * - 단순히 숫자만 받아서 개수 제한/건너뛰기
         */

        List<String> first3Names = names.stream()
                .limit(3)
                .collect(Collectors.toList());

        List<String> skip2Names = names.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("처음 3개만: " + first3Names);
        System.out.println("처음 2개 건너뛴 후: " + skip2Names);

        // 5. sorted() - 정렬
        System.out.println("\n--- sorted(): 정렬 ---");
        /*
         * [필기] sorted(), sorted(Comparator<T> comparator)
         * - sorted(): 함수형 인터페이스 사용 안함 (자연 순서 정렬)
         * - sorted(Comparator): Comparator<T> 함수형 인터페이스 사용
         */

        // 자연 순서 정렬 (오름차순)
        List<String> sortedNames = names.stream()
                .distinct()
                .sorted()  // 자연 순서 (사전순)
                .collect(Collectors.toList());

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()  // 자연 순서 (오름차순)
                .collect(Collectors.toList());

        System.out.println("이름 사전순 정렬: " + sortedNames);
        System.out.println("숫자 오름차순 정렬: " + sortedNumbers);


        List<String> sortedByLength = names.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())  // Comparator<String> 사용
                .collect(Collectors.toList());

        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())  // Comparator<Integer> 사용
                .collect(Collectors.toList());

        System.out.println("이름 길이순 정렬 (Comparator): " + sortedByLength);
        System.out.println("숫자 내림차순 정렬 (Comparator): " + sortedDesc);

        System.out.println("\n=== 최종 연산들 (Terminal Operations) ===");

        // 1. collect() - 결과를 컬렉션으로 수집
        System.out.println("--- collect(): 결과를 컬렉션으로 수집 ---");
        /*
         * [필기] collect(Collector<T, A, R> collector)
         * - Collector는 복잡한 인터페이스 (내부적으로 여러 함수형 인터페이스 조합)
         * - 보통 Collectors.toList(), Collectors.toSet() 등 미리 만들어진 것 사용
         */

        List<String> longNamesList = names.stream()
                .filter(name -> name.length() > 3)  // Predicate<String> 람다 직접 구현
                .collect(Collectors.toList());

        Set<String> uniqueNamesSet = names.stream()
                .collect(Collectors.toSet());

        System.out.println("3글자 초과 이름들 (List): " + longNamesList);
        System.out.println("중복 제거된 이름들 (Set): " + uniqueNamesSet);

        // 2. forEach() - 각 요소에 대해 작업 수행
        System.out.println("\n--- forEach(): 각 요소 처리 ---");
        /*
         * [필기] forEach(Consumer<T> action)
         * - 사용 함수형 인터페이스: Consumer<T>
         * - 시그니처: void accept(T t)
         * - 역할: 각 요소를 받아서 소비 (출력, 저장 등)
         */

        System.out.println("이름 출력 (Consumer<String>):");
        names.stream()
                .distinct()
                .forEach(name -> System.out.println("  → " + name));  // Consumer<String> 람다 직접 구현

        System.out.println("제곱 출력 (Consumer<Integer>):");
        numbers.stream()
                .limit(5)
                .forEach(num -> System.out.println("  " + num + "² = " + (num * num)));  // Consumer<Integer> 람다 직접 구현

        // 3. anyMatch(), allMatch(), noneMatch() - 조건 매칭
        System.out.println("\n--- 조건 매칭 연산들 ---");
        /*
         * [필기] anyMatch/allMatch/noneMatch(Predicate<T> predicate)
         * - 사용 함수형 인터페이스: Predicate<T>
         * - 시그니처: boolean test(T t)
         * - 역할: 조건을 만족하는지 검사해서 boolean 반환
         */

        boolean hasKim = names.stream()
                .anyMatch(name -> name.startsWith("김"));  // Predicate<String> 람다 직접 구현

        boolean allLongNames = names.stream()
                .allMatch(name -> name.length() >= 2);  // Predicate<String> 람다 직접 구현

        boolean noShortNames = names.stream()
                .noneMatch(name -> name.length() < 2);  // Predicate<String> 람다 직접 구현

        System.out.println("김씨가 있나? (anyMatch): " + hasKim);
        System.out.println("모든 이름이 2글자 이상? (allMatch): " + allLongNames);
        System.out.println("2글자 미만 이름이 없나? (noneMatch): " + noShortNames);

        // 4. count(), min(), max() - 통계 연산
        System.out.println("\n--- 통계 연산들 ---");
        /*
         * [필기] count(), min(Comparator<T>), max(Comparator<T>)
         * - count(): 함수형 인터페이스 사용 안함 (단순 개수)
         * - min/max: Comparator<T> 사용 (비교 기준 제공)
         */

        long totalCount = names.stream().count();
        long uniqueCount = names.stream().distinct().count();

        // Comparator로 최대/최소값 찾기
        String longestName = names.stream()
                .max((s1, s2) -> s1.length() - s2.length())  // Comparator<String> 람다 직접 구현
                .orElse("없음");

        Integer maxNumber = numbers.stream()
                .max((n1, n2) -> n1.compareTo(n2))  // Comparator<Integer> 람다 직접 구현
                .orElse(0);

        System.out.println("전체 이름 개수: " + totalCount);
        System.out.println("중복 제거 후 개수: " + uniqueCount);
        System.out.println("가장 긴 이름: " + longestName);
        System.out.println("최댓값: " + maxNumber);
    }
}
