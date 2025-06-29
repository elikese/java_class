package com.study._08_While;

public class DoWhile {
    public static void main(String[] args) {
        /*
        do {
            // 최소 한 번은 실행되는 코드
        } while (조건식);

        // while문과의 차이점:
        // while: 조건 확인 → 실행
        // do-while: 실행 → 조건 확인
         */

        // 1. 사용자에게 메뉴 한 번은 보여줘야 할 때
        // 2. 설정 초기화 등 최소 1회 실행이 보장돼야 할 때
        // 3. 외부에서 입력을 반드시 최소 한 번은 받아야 할 때


        int userChoice;

        // 메뉴를 최소 한 번은 보여주고 싶을 때
        do {
            System.out.println("=== 메뉴 ===");
            System.out.println("1. 게임 시작");
            System.out.println("2. 설정");
            System.out.println("3. 종료");

            // 실제로는 사용자 입력을 받겠지만, 예제에서는 고정값
            userChoice = 3;  // 종료 선택

            System.out.println("선택: " + userChoice);

        } while (userChoice != 3);  // 3번(종료)을 선택할 때까지 반복

        System.out.println("프로그램을 종료합니다.");

        // 마치 가게에서 "어서오세요!" 인사를 먼저 하고
        // 손님이 필요한 게 있는지 확인하는 것과 같음

    }
}
