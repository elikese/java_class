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


    }
}
