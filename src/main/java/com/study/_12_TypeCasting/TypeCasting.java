package com.study._12_TypeCasting;

public class TypeCasting {
    public static void main(String[] args) {
        // 형변환 = 데이터 타입을 다른 타입으로 변경하는 것
        // 큰 -> 작은: 넘칠 수 있음 -> 데이터 유실 가능성 있음 (명시적 형변환 필요)
        // 작은 → 큰: 안전함 -> 데이터 유실 가능성 없음 (자동 형변환)

        // 작은 범위 → 큰 범위 (자동으로 변환됨)
        int intValue = 10;
        long longValue;
        double doubleValue;

        // int → long (자동 형변환)
        longValue = intValue;  // 10L로 자동 변환
        System.out.println("longValue = " + longValue);

        // long → double (자동 형변환)
        doubleValue = longValue;  // 10.0으로 자동 변환
        System.out.println("doubleValue = " + doubleValue);

        // int → double (자동 형변환)
        doubleValue = intValue;  // 10.0으로 자동 변환
        System.out.println("doubleValue2 = " + doubleValue);


        doubleValue = 1.5;
        // 자동 변환 불가 - 컴파일 오류
//        intValue = doubleValue;
        // 명시적 형변환 필요
        intValue = (int) doubleValue;  // 1.5 → 1 (소수점 버림!) -> 데이터유실
        System.out.println("intValue = " + intValue);


        // 자바의 연산 형변환 규칙:
        // 1. 같은 타입끼리 연산 → 같은 타입 결과
        // 2. 다른 타입끼리 연산 → 더 큰 범위 타입으로 자동 변환 후 연산

        intValue = 1;
        doubleValue = 1.5;
        System.out.println(doubleValue + intValue); // double이 더 큰 범위
    }
}
