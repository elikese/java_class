package com.study._39_Collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashUserMain {
    public static void main(String[] args) {
        Set<HashUser> set = new HashSet<>();

        HashUser u1 = new HashUser("홍길동", 20);
        HashUser u2 = new HashUser("홍길동", 20);

        set.add(u1);
        set.add(u2);

        /*
         * [설명]
         * 같은 내용의 객체라도 equals()와 hashCode()가 없으면
         * HashSet은 "다른 객체"라고 판단함 → 중복 제거 실패
         *
         * hashCode()가 같으면 -> 그다음 equals() 비교 수행
         * equals()가 true면 같은 객체로 판단하여 중복 제거
         *
         * equals()와 hashCode()를 제대로 구현해야만
         * 논리적으로 같은 객체로 인식됨 → 중복 제거 성공
         */

        System.out.println("Set 크기: " + set.size()); // 몇 개 들어갔을까?
    }
}
