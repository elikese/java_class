package com.study._02_Variable;

public class DataType {
    public static void main(String[] args) {
        /*
        컴퓨터는 모든 데이터를 0과 1로만 저장함 (2진수)

        1bit = 2진수 자리 1개 → 2개의 데이터 표현 가능 (0, 1)
        2bit = 2진수 자리 2개 → 2^2 = 4개의 데이터 표현 가능 (00, 01, 10, 11)
        8bit = 1byte = 2진수 자리 8개 → 2^8 = 256개의 데이터 표현 가능
        32bit = 4byte = 2진수 자리 32개 → 2^32 = 약 42억개의 데이터 표현 가능
        */

        // 정수 타입
        byte smallBox = 127;           // 1byte = 8bit → -128 ~ 127
        short mediumBox = 32000;       // 2byte = 16bit → -32,768 ~ 32,767
        int normalBox = 2000000000;    // 4byte = 32bit → 약 -21억 ~ 21억
        long bigBox = 3_000_000_000L;     // 8byte = 64bit → 매우 큰 수
        // 맨 앞 1bit를 부호(+/-)에 사용
        // int의 경우: 31bit는 숫자, 1bit는 부호

        // 실수 타입
        float smallPrecision = 3.14159265F;    // 4byte, 소수점 7자리 정도 정확
        double highPrecision = 3.14159265359;  // 8byte, 소수점 15자리 이상 정확

        System.out.println("float 정밀도: " + smallPrecision);   // 3.1415927 (끝부분 부정확)
        System.out.println("double 정밀도: " + highPrecision);  // 3.14159265359 (정확)

        // 문자 타입(문자 하나를 저장, 작은 따옴표 사용)
        // 아스키코드
        char char1 = 'A';
        char char2 = 65 + 1; // ASCII 코드 66 = 'B'
        System.out.println(char1);
        System.out.println(char2);

        // 문자열형 - String (문자들의 집합, 큰 따옴표 사용)
        String str = "안녕하세요!";
        String name = "홍길동";
        System.out.println("str: " + str);
        System.out.println("name: " + name);

        // 논리형 - boolean (true 또는 false만 저장)
        boolean isEmpty = true;
        boolean isAdult = false;
        boolean hasError = false;


    }

}
