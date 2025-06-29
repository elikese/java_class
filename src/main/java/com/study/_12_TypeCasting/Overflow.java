package com.study._12_TypeCasting;

public class Overflow {
    public static void main(String[] args) {
        // 실제 서비스 형변환 버그 보고 사례 -> 21억이 굉장히 많이 출현
        // 이유 -> int 범위: 약 -21억 ~ 21억
        long maxIntValue = 2_147_483_647L;  // int 최댓값
        long overIntValue = 2_147_483_648L; // int 최댓값 + 1

        // 정상 범위 형변환
        int intValue1 = (int) maxIntValue;
        System.out.println("정상 범위: " + intValue1);  // 2147483647

        // 오버플로우 발생!
        int intValue2 = (int) overIntValue;
        System.out.println("오버플로우: " + intValue2);  // -2147483648 (음수로!)
    }
}
