package com.study._04_String;

public class StringMethod {
    public static void main(String[] args) {
        String str = "My name is GilDong Hong";

        // 문자열 길이 확인 - 마치 줄자로 길이 재는 것처럼
        System.out.println("문자열 길이: " + str.length());  // 23

        // 대소문자 변환 - 마치 대소문자 변환기
        System.out.println("대문자로: " + str.toUpperCase());
        System.out.println("소문자로: " + str.toLowerCase());

        // 특정 문자열 포함 여부 확인 - 마치 찾기 기능
        System.out.println("'name' 포함: " + str.contains("name"));    // true
        System.out.println("'age' 포함: " + str.contains("age"));      // false

        // 원본 문자열은 변하지 않음! (String은 불변 객체)
        System.out.println("원본: " + str);  // My name is DongYoon Lee



        str = "I like music and movie and travel.";

        // 특정 문자열의 위치 찾기 - 마치 주소 찾기
        System.out.println("'music' 위치: " + str.indexOf("music"));   // 7
        System.out.println("'java' 위치: " + str.indexOf("java"));     // -1 (없으면 -1)

        // 마지막 위치 찾기 - 같은 단어가 여러 개 있을 때
        System.out.println("마지막 'and' 위치: " + str.lastIndexOf("and"));  // 20
        System.out.println("마지막 'python' 위치: " + str.lastIndexOf("python")); // -1

        // 시작/끝 문자열 확인 - 마치 접두사/접미사 확인
        System.out.println("'I like'로 시작: " + str.startsWith("I like"));      // true
        System.out.println("'travel'로 끝남: " + str.endsWith("travel"));        // true
        System.out.println("'movie'로 끝남: " + str.endsWith("movie"));          // false


        // 문자열 바꾸기 - 마치 찾기&바꾸기 기능
        System.out.println("원본: " + str);
        System.out.println("바뀐 것: " + str.replace(" and", ","));
        // 결과: I like music, movie, travel.

        // 부분 문자열 추출하기 - 마치 가위로 자르기
        System.out.println("7번째부터 끝까지: " + str.substring(7));           // music and movie and travel.
        System.out.println("7번째부터 12번째까지: " + str.substring(7, 12));   // music (12는 포함 안됨!)

        // 실용 예제: 특정 단어만 추출하기
        int movieStart = str.indexOf("movie");
        int movieEnd = str.indexOf(".");
        System.out.println("movie부터 마침표까지: " + str.substring(movieStart, movieEnd));
        // 결과: movie and travel

        // 공백 제거하기 - 마치 공백 지우개
        String messy = "    I want to go home    ";
        System.out.println("원본: " + messy);
        System.out.println("정리된 것: " + messy.trim());

        // 문자열 합치기 - 두 가지 방법
        String s1 = "Hello";
        String s2 = "World";

        // 방법 1: + 연산자 (더 일반적)
        System.out.println("방법1: " + s1 + " " + s2);

        // 방법 2: concat() 메서드
        System.out.println("방법2: " + s1.concat(" ").concat(s2));

        // 결과는 동일: Hello World
    }

}
