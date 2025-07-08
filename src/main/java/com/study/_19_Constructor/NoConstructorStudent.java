package com.study._19_Constructor;

public class NoConstructorStudent {

    String name;
    int korean;
    int english;
    int math;

    /*
     * 생성자가 하나도 없으면 → 자바가 자동으로 기본 생성자를 만들어줌
     * 생성자가 하나라도 있으면 → 자바가 기본 생성자를 만들지 않음
     *
     * NoConstructorStudent 생성자가 없으므로 자바가 자동으로 다음과 같은
     * 기본 생성자를 만들어줍니다:
     *
     * public NoConstructorStudent() {
     *     // 아무 코드 없음
     * }
     */

}
