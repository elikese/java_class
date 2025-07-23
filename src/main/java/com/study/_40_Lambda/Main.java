package com.study._40_Lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> customerNames = List.of("홍길동", "김길동", "박길동", "아무개");
        List<String> customerNames2 = new ArrayList<>();

        // StringProcessor로 customerNames의 이름뒤에 "님"을 붙혀주세요
        // "홍길동" -> "홍길동님"
        // 변환된 이름을 반복문을 순회하면서 customerNames2에 추가해서 최종 출력
        StringProcessor makeNim = s -> s + "님";

        for(String name : customerNames) {
            customerNames2.add(makeNim.process(name));
        }

        System.out.println(customerNames2);

        List<String> allNames = List.of("김풍", "이순신", "홍길동", "강감찬", "박군", "을지문덕");
        List<String> longNames = new ArrayList<>();

        // StringChecker를 만들어서 풀네임이 3글자 이하인 사람들을 걸러내고
        // 반복문을 순회하면서 longNames에 추가해서 최종 출력
        StringChecker isLongName = s -> s.length() >= 3;

        for(String name : allNames) {
            if(isLongName.check(name)) {
                longNames.add(name);
            }
        }

        System.out.println("전체 이름: " + allNames);
        System.out.println("긴 이름들: " + longNames);


        List<String> inputs = List.of("hello", "", "world", "", "java", "");
        List<String> notEmpty = new ArrayList<>();

        // TODO: 빈 문자열이 아닌지 확인하는 StringChecker를 만드세요
        // [문제 해설] 문자열이 비어 있지 않은 경우만 true를 반환하는 람다식을 작성합니다.
        StringChecker isNotEmpty = s -> !s.isEmpty();

        for(String input : inputs) {
            if(isNotEmpty.check(input)) {
                notEmpty.add(input); // 조건을 만족하는 문자열만 수집
            }
        }

        List<Person> people = List.of(
                new Person("홍길동", 18),
                new Person("김자바", 22),
                new Person("이파이썬", 30),
                new Person("박리액트", 15)
        );

        List<Person> adults = new ArrayList<>();

        // 람다식을 이용한 조건 정의 (20세 이상인 경우만)
        // [문제 해설] Person 객체의 나이가 20 이상이면 true를 반환하는 람다
        PersonChecker isAdult = p -> p.getAge() >= 20;

        for (Person person : people) {
            if (isAdult.check(person)) {
                adults.add(person); // 성인만 리스트에 추가
            }
        }

        System.out.println("성인 목록:");
        for (Person p : adults) {
            System.out.println(p.getName() + " (" + p.getAge() + "세)");
        }

        List<Person> longNamePeople = new ArrayList<>();

        // 이름 길이가 3글자 이상인지 체크하는 람다
        // [문제 해설] 이름이 3글자 이상인 경우만 true를 반환
        PersonChecker hasLongName = p -> p.getName().length() >= 3;

        for (Person person : people) {
            if (hasLongName.check(person)) {
                longNamePeople.add(person); // 조건을 만족하는 사람만 저장
            }
        }

        System.out.println("이름이 3글자 이상인 사람 목록:");
        for (Person p : longNamePeople) {
            System.out.println(p.getName() + " (" + p.getAge() + "세)");
        }

        List<Person> modifiedPeople = new ArrayList<>();

        // 미성년자면 이름을 "비공개"로 바꾸는 람다
        // [문제 해설] 나이가 20 미만인 경우 이름을 "비공개"로 설정
        Modifier<Person> hideMinorName = p -> {
            if (p.getAge() < 20) {
                return new Person("비공개", p.getAge());
            }
            return p; // 성인은 원본 그대로 유지
        };

        // 이름 두 번째 글자를 *로 바꾸는 람다
        // [문제 해설] 이름의 두 번째 글자를 *로 바꿔서 마스킹 처리
        Modifier<Person> maskSecondChar = p -> {
            String name = p.getName();
            if (name.length() >= 2) {
                String maskedName = name.charAt(0) + "*" + name.substring(2);
                return new Person(maskedName, p.getAge());
            }
            return p; // 이름이 한 글자일 경우는 그대로 유지
        };

        // people 리스트 재사용
        for (Person person : people) {
            // [문제 해설] 먼저 미성년자 이름 비공개 처리 → 이어서 두 번째 글자 마스킹
            Person modified = hideMinorName.modify(person);
            modified = maskSecondChar.modify(modified);
            modifiedPeople.add(modified); // 최종 결과 저장
        }

        System.out.println("이름 변환된 사람 목록:");
        for (Person p : modifiedPeople) {
            System.out.println(p.getName() + " (" + p.getAge() + "세)");
        }

    }
}
