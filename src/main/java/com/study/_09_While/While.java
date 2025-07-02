package com.study._09_While;

import java.util.Random;
import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        /*
        while (조건식) {
            // 조건이 참인 동안 반복 실행될 코드
        }

        // 조건결과가 false가 되면 반복 종료
         */

        // for문이 적합한 경우 - 횟수가 명확
        // while문이 적합한 경우 - 횟수가 불명확, 조건 중심

        int count = 0;

        while (count < 3) {
            count++;  // count = count + 1
            System.out.println("현재 숫자는: " + count);
        }

        System.out.println("while문 종료");

        int sum = 0;
        int i = 1;

        while (i <= 10) {
            sum += i;  // sum = sum + i
            System.out.println("i=" + i + ", sum=" + sum);
            i++;
        }

        System.out.println("최종 합계: " + sum);


        // 스캐너 객체생성
        Scanner scanner = new Scanner(System.in);

        // 랜덤 객체생성
        Random random = new Random();

        int num = random.nextInt(1,10);   // 1이상 10미만 중 랜덤
        int data = 0;

        while(num != data) {
            System.out.print("입력: ");
            data = scanner.nextInt();
            if(num == data) {
                System.out.println("정답은 " + data + "입니다.");
            } else {
                System.out.println("틀렸습니다. 다시 입력하세요.");
            }
        }
    }
}
