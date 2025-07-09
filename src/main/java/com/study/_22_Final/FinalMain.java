package com.study._22_Final;

public class FinalMain {
    public static void main(String[] args) {

        // final : 반드시 "한번"만 "초기화" 되어야 함!

        // 방법 1: 선언과 초기화를 분리
        final int data1;
//        System.out.println(data1); // 초기화 전엔 사용 불가능
        data1 = 10;      // 최초 한 번만 값 할당 가능
        // data1 = 20;   // 컴파일 에러! 이미 할당됨

        // 방법 2: 선언과 동시에 초기화
        final int data2 = 20;
        // data2 = 30;   // 컴파일 에러! 이미 할당됨

    }
}
