package com.study._09_While;

import java.util.Random;
import java.util.Scanner;

public class UpDown {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int answer = random.nextInt(1, 101);
        int guess = 0;


        /*
        1. while문을 사용하여 매 반복마다 스캐너를 통해 1~100 숫자를 하나 입력 받는다
        2. Random을 통해 생성한 1~100사이 정수 random과 비교한다.
        3. 작으면 "up"출력, 크면 "down"출력
        4. 같으면 "정답입니다!" 출력하고 반복을 탈출
        */

        while (guess != answer) {
            System.out.print("숫자를 입력하세요 (1~100): ");
            guess = scanner.nextInt();

            if (guess < answer) {
                System.out.println("Up");
            } else if (guess > answer) {
                System.out.println("Down");
            } else {
                System.out.println("정답입니다! 🎉");
            }
        }


    }
}
