package com.study._06_If;

public class ElseIf {
    public static void main(String[] args) {
        // if ~ else if ~ else
        // 하나의 조건이 만족되면, 나머지는 검사 안함
        // 오직 하나의 블록만 실행 됨
        int age = 14;

        if (age <= 7) {
            System.out.println("미취학");
        } else if (age <= 13) {
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        } else {
            System.out.println("성인");
        }

        // if문 여러개
        // 각각 독립적인 조건으로 판단해야 하는 경우


    }
}
