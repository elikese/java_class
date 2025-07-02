package com.study._08_For;

public class NestedLoop {
    public static void main(String[] args) {
        // 2중 for문
        
        for (int week=1; week<=4; week++) {
            System.out.println(week + "주 시작");
            for(int day=1; day <=7; day++) {
                System.out.print(day + "일 살았음 ");
            }
            System.out.println();
            System.out.println(week + "주 끝");
        }

        // 2중 반복문으로 아파트 호수 출력
        for (int i = 1; i < 10; i++) {      // 바깥쪽 반복문
            for (int j = 1; j < 5; j++) {  // 안쪽 반복문
                System.out.print("" + i + "0" + j + "호 ");
            }
            System.out.println();  // 한 줄 완성 후 줄바꿈
        }

    }
}
