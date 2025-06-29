package com.study._11_Scope;

public class Scope2 {
    public static void main(String[] args) {
        int outer = 1;  // 바깥쪽 변수

        if (true) {
            int inner = 2;  // 안쪽 변수

            // 안쪽에서 바깥쪽 변수 접근 가능
            System.out.println("outer = " + outer);

            // 안쪽에서 안쪽 변수 접근 가능
            System.out.println("inner = " + inner);

            if (true) {  // 더 깊은 블록
                int deeper = 3;

                // 모든 바깥쪽 변수들 접근 가능
                System.out.println("outer = " + outer);
                System.out.println("inner = " + inner);
                System.out.println("deeper = " + deeper);
            }
            // deeper는 여기서 사용 불가 (이미 사라짐)
        }
        // inner는 여기서 사용 불가 (이미 사라짐)
    }
}
