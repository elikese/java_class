package com.study._13_Scanner;

import java.util.Scanner;

public class BankMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 10000;  // 잔액

        while (true) {
            // 메뉴 출력
            System.out.println("\n=== 간단 ATM ===");
            System.out.println("1. 잔액 확인");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("현재 잔액: " + balance + "원");
                    break;

                case 2:
                    System.out.print("입금할 금액: ");
                    int deposit = scanner.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println(deposit + "원 입금했습니다.");
                        System.out.println("현재 잔액: " + balance + "원");
                    } else {
                        System.out.println("올바른 금액을 입력하세요.");
                    }
                    break;

                case 3:
                    // 실습) 출금 구현
                    // int withdraw를 scanner를 통해 받음
                    // withdraw가 양수인지, 잔액보다 작은지 검사
                    // withdraw가 잔액보다 크다면 잔액이 부족합니다 print
                    // 나머지 입력에 대해서는 올바른 금액을 입력하세요 print
                    System.out.print("출금할 금액: ");
                    int withdraw = scanner.nextInt();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println(withdraw + "원 출금했습니다.");
                        System.out.println("현재 잔액: " + balance + "원");
                    } else if (withdraw > balance) {
                        System.out.println("잔액이 부족합니다.");
                    } else {
                        System.out.println("올바른 금액을 입력하세요.");
                    }
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;  // main 메서드 종료

                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }
}
