package com.study._08_For;

public class NestedLoop {
    public static void main(String[] args) {

        // 2중 반복문으로 아파트 호수 출력
        for (int i = 1; i < 10; i++) {      // 바깥쪽 반복문
            for (int j = 1; j < 5; j++) {  // 안쪽 반복문
                System.out.print("" + i + "0" + j + "호 ");
            }
            System.out.println();  // 한 줄 완성 후 줄바꿈
        }

        // 2단부터 9단까지 모든 구구단 출력
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("=== " + dan + "단 ===");
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " × " + i + " = " + (dan * i));
            }
            System.out.println();
        }

    }
}
