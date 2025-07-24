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
        // 힌트: s -> !s.isEmpty() 형태로 작성하세요
        StringChecker isNotEmpty = s -> !s.isEmpty();

        for(String input : inputs) {
            if(isNotEmpty.check(input)) {
                notEmpty.add(input);
            }
        }

        List<Person> people = List.of(
                new Person("홍길동", 18),
                new Person("김자바", 22),
                new Person("이파이썬", 30),
                new Person("박리액트", 15)
        );

        List<Person> adults = new ArrayList<>();

        // TODO: 20세 이상인 성인을 찾는 PersonChecker 람다식을 작성하세요
        // 힌트: Person의 getAge() 메서드를 활용하세요
        PersonChecker isAdult = p -> p.getAge() >= 20;

        for (Person person : people) {
            if (isAdult.check(person)) {
                adults.add(person);
            }
        }

        System.out.println("성인 목록:");
        for (Person p : adults) {
            System.out.println(p.getName() + " (" + p.getAge() + "세)");
        }

        List<Person> longNamePeople = new ArrayList<>();

        // TODO: 이름 길이가 3글자 이상인지 체크하는 PersonChecker 람다식을 작성하세요
        // 힌트: getName().length()를 활용하세요
        PersonChecker hasLongName = p -> p.getName().length() >= 3;

        for (Person person : people) {
            if (hasLongName.check(person)) {
                longNamePeople.add(person);
            }
        }

        System.out.println("이름이 3글자 이상인 사람 목록:");
        for (Person p : longNamePeople) {
            System.out.println(p.getName() + " (" + p.getAge() + "세)");
        }


        // TODO: 이름의 두 번째 글자를 *로 바꾸는 Modifier 람다식을 작성하세요
        // 힌트: charAt(0) + "*" + substring(2) 형태로 문자열을 조합하세요
        Modifier<Person> makeMasking = p -> {
            String name = p.getName();
            if (name.length() >= 2) {
                String maskedName = name.charAt(0) + "*" + name.substring(2);
                return new Person(maskedName, p.getAge());
            }
            return p;
        };

        List<Person> modifiedPeople = new ArrayList<>();
        for (Person p : people) {
            Person modifiedPerson = makeMasking.modify(p);
            modifiedPeople.add(modifiedPerson);
            System.out.println(modifiedPerson);
        }

        // TODO: 미성년자(20세 미만)의 이름을 "비공개"로 바꾸는 Modifier 람다식을 작성하세요
        // 힌트: 조건문을 사용해서 새로운 Person 객체를 반환하세요
        Modifier<Person> hideMinorName = p -> {
            if (p.getAge() < 20) {
                return new Person("비공개", p.getAge());
            }
            return p;
        };

        System.out.println("=".repeat(50));

        List<Person> minors = new ArrayList<>();
        for (Person p : people) {
            Person minor = hideMinorName.modify(p);
            minors.add(minor);
            System.out.println(minor);
        }

    }
}
