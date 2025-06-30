package com.study._15_MultiArray;

import java.util.Scanner;

public class CoordGame {
    public static void main(String[] args) {
        /*
         * 좌표이동 게임 - 2차원 배열과 while문 활용
         *
         * 게임 규칙:
         * - 5x5 맵에서 플레이어(P)가 보물(T)을 찾는 게임
         * - w,a,s,d 키로 이동 (위, 왼쪽, 아래, 오른쪽)
         * - 맵 밖으로 나갈 수 없음
         * - 보물을 찾으면 게임 종료
         * - q를 누르면 게임 종료
         *
         * 학습 포인트:
         * 1. 2차원 배열로 게임 맵 표현
         * 2. while 반복문으로 게임 루프 구현
         * 3. 조건문으로 이동 가능 여부 판단
         * 4. Scanner로 사용자 입력 처리
         */


        Scanner scanner = new Scanner(System.in);

        // ========== 1. 게임 맵과 변수 초기화 ==========
        /*
         * 게임 맵 설정:
         * - 5x5 크기의 2차원 배열
         * - 0: 빈 공간, 1: 플레이어, 2: 보물
         *
         * 좌표 시스템:
         * - row: 행 (세로 위치)
         * - col: 열 (가로 위치)
         * - 왼쪽 위가 (0,0), 오른쪽 아래가 (4,4)
         */

        final int MAP_SIZE = 5;
        int[][] gameMap = new int[MAP_SIZE][MAP_SIZE];

        // 플레이어 초기 위치
        int playerRow = 0;
        int playerCol = 0;

        // 보물 위치 (랜덤으로 설정)
        int treasureRow = 3;
        int treasureCol = 4;

        // 게임 상태
        boolean gameRunning = true;
        boolean treasureFound = false;
        int moveCount = 0; // 이동 횟수 카운트

        System.out.println("🎮 좌표이동 게임에 오신 것을 환영합니다!");
        System.out.println("📍 목표: 플레이어(P)를 움직여서 보물(T)을 찾으세요!");
        System.out.println("🎯 조작법: w(위), a(왼쪽), s(아래), d(오른쪽), q(종료)");
        System.out.println("📏 맵 크기: " + MAP_SIZE + "x" + MAP_SIZE);
        System.out.println();


        // ========== 2. 게임 메인 루프 (while문) ==========
        /*
         * while 반복문을 사용하는 이유:
         * - 게임이 언제 끝날지 미리 알 수 없음
         * - 사용자가 q를 누르거나 보물을 찾을 때까지 계속 반복
         * - for문은 반복 횟수가 정해져 있을 때 사용
         */

        while (gameRunning) {

            // ========== 3. 맵 초기화 및 표시 ==========
            /*
             * 매번 맵을 새로 그려야 하는 이유:
             * - 플레이어가 이동할 때마다 화면을 업데이트
             * - 이전 위치는 빈 공간으로, 현재 위치는 플레이어로 표시
             */

            // 맵 초기화 (모든 칸을 빈 공간으로)
            for (int row = 0; row < MAP_SIZE; row++) {
                for (int col = 0; col < MAP_SIZE; col++) {
                    gameMap[row][col] = 0; // 0 = 빈 공간
                }
            }

            // 현재 위치에 플레이어와 보물 배치
            gameMap[playerRow][playerCol] = 1; // 1 = 플레이어
            if (!treasureFound) {
                gameMap[treasureRow][treasureCol] = 2; // 2 = 보물
            }

            // 맵 화면에 출력
            System.out.println("📍 현재 위치: (" + playerRow + ", " + playerCol + ")");
            System.out.println("🏴 이동 횟수: " + moveCount);
            System.out.println();

            // 맵 테두리와 좌표 표시
            System.out.print("   "); // 왼쪽 여백
            for (int col = 0; col < MAP_SIZE; col++) {
                System.out.print(" " + col + " "); // 열 번호 표시
            }
            System.out.println();

            for (int row = 0; row < MAP_SIZE; row++) {
                System.out.print(row + " |"); // 행 번호 표시

                for (int col = 0; col < MAP_SIZE; col++) {
                    if (gameMap[row][col] == 0) {
                        System.out.print(" · "); // 빈 공간
                    } else if (gameMap[row][col] == 1) {
                        System.out.print(" P "); // 플레이어
                    } else if (gameMap[row][col] == 2) {
                        System.out.print(" T "); // 보물
                    }
                }
                System.out.println("|");
            }
            System.out.println();


            // ========== 4. 보물 발견 체크 ==========
            /*
             * 게임 종료 조건 1: 보물 발견
             * - 플레이어와 보물의 좌표가 같아지면 게임 클리어
             */
            if (playerRow == treasureRow && playerCol == treasureCol) {
                treasureFound = true;
                System.out.println("🎉 축하합니다! 보물을 찾았습니다!");
                System.out.println("✨ 총 이동 횟수: " + moveCount + "회");
                System.out.println("🏆 게임 클리어!");
                break; // while 반복문 탈출
            }


            // ========== 5. 사용자 입력 처리 ==========
            /*
             * 사용자 입력을 받아서 이동 처리
             * - 잘못된 입력에 대한 처리도 포함
             */

            System.out.print("🎮 이동할 방향을 입력하세요 (w/a/s/d/q): ");
            String input = scanner.nextLine().toLowerCase(); // 소문자로 변환

            // 입력값 검증
            if (input.length() != 1) {
                System.out.println("❌ 한 글자만 입력해주세요!");
                continue; // 다시 입력 받기
            }

            char direction = input.charAt(0);

            // 이동하려는 새로운 좌표 계산
            int newRow = playerRow;
            int newCol = playerCol;

            /*
             * 방향별 좌표 변화:
             * - w(위): row - 1 (위로 한 칸)
             * - s(아래): row + 1 (아래로 한 칸)
             * - a(왼쪽): col - 1 (왼쪽으로 한 칸)
             * - d(오른쪽): col + 1 (오른쪽으로 한 칸)
             */

            switch (direction) {
                case 'w': // 위로 이동
                    newRow = playerRow - 1;
                    System.out.println("⬆️ 위로 이동 시도");
                    break;

                case 's': // 아래로 이동
                    newRow = playerRow + 1;
                    System.out.println("⬇️ 아래로 이동 시도");
                    break;

                case 'a': // 왼쪽으로 이동
                    newCol = playerCol - 1;
                    System.out.println("⬅️ 왼쪽으로 이동 시도");
                    break;

                case 'd': // 오른쪽으로 이동
                    newCol = playerCol + 1;
                    System.out.println("➡️ 오른쪽으로 이동 시도");
                    break;

                case 'q': // 게임 종료
                    System.out.println("👋 게임을 종료합니다.");
                    gameRunning = false;
                    continue; // while문 조건 체크로 이동 (게임 종료)

                default: // 잘못된 입력
                    System.out.println("❌ 잘못된 입력입니다! w, a, s, d, q 중 하나를 입력하세요.");
                    continue; // 다시 입력 받기
            }


            // ========== 6. 이동 가능 여부 체크 ==========
            /*
             * 경계 체크 (Boundary Check):
             * - 맵 밖으로 나가려고 하면 이동 불가
             * - 유효한 좌표 범위: 0 <= row < MAP_SIZE, 0 <= col < MAP_SIZE
             */

            if (newRow < 0 || newRow >= MAP_SIZE || newCol < 0 || newCol >= MAP_SIZE) {
                System.out.println("🚫 맵 경계를 벗어날 수 없습니다!");
                System.out.println("📍 현재 위치 유지: (" + playerRow + ", " + playerCol + ")");
            } else {
                // 이동 가능한 경우
                playerRow = newRow;
                playerCol = newCol;
                moveCount++;
                System.out.println("✅ 이동 성공! 새로운 위치: (" + playerRow + ", " + playerCol + ")");
            }

            System.out.println(); // 빈 줄로 구분


            // ========== 7. 힌트 시스템 (선택사항) ==========
            /*
             * 보물까지의 거리 계산 (맨해튼 거리)
             * - 절댓값을 이용한 거리 계산
             * - |x1-x2| + |y1-y2|
             */

            if (!treasureFound && moveCount % 3 == 0 && moveCount > 0) {
                int distance = Math.abs(playerRow - treasureRow) + Math.abs(playerCol - treasureCol);
                System.out.println("💡 힌트: 보물까지 " + distance + "칸 남았습니다!");

                // 방향 힌트
                if (playerRow < treasureRow) {
                    System.out.println("💡 힌트: 아래쪽으로 가보세요! (s)");
                } else if (playerRow > treasureRow) {
                    System.out.println("💡 힌트: 위쪽으로 가보세요! (w)");
                }

                if (playerCol < treasureCol) {
                    System.out.println("💡 힌트: 오른쪽으로 가보세요! (d)");
                } else if (playerCol > treasureCol) {
                    System.out.println("💡 힌트: 왼쪽으로 가보세요! (a)");
                }
                System.out.println();
            }
        }

        // ========== 8. 게임 종료 처리 ==========
        System.out.println("=".repeat(50));
        System.out.println("🎮 게임 종료!");

        if (treasureFound) {
            // 성공적으로 보물을 찾은 경우
            System.out.println("🏆 결과: 게임 클리어!");
        } else {
            // 중간에 종료한 경우
            System.out.println("😢 결과: 게임 포기");
            System.out.println("💪 다음에 다시 도전해보세요!");
        }

        System.out.println("📊 통계:");
        System.out.println("   - 총 이동 횟수: " + moveCount + "회");
        System.out.println("   - 최종 위치: (" + playerRow + ", " + playerCol + ")");
        System.out.println("   - 보물 위치: (" + treasureRow + ", " + treasureCol + ")");

        scanner.close();



        /*
         * 게임 구현 핵심 정리
         *
         * 1. 2차원 배열 활용:
         *    - 게임 맵을 2차원 배열로 표현
         *    - 좌표 시스템 (row, col)으로 위치 관리
         *
         * 2. while 반복문:
         *    - 게임이 끝날 때까지 무한 반복
         *    - 조건: gameRunning == true
         *    - break문으로 반복문 탈출
         *
         * 3. 조건문 활용:
         *    - 경계 체크 (맵 밖으로 나가는지 확인)
         *    - 게임 종료 조건 체크 (보물 발견)
         *    - 사용자 입력 검증
         *
         * 4. Scanner 활용:
         *    - 사용자 입력 받기
         *    - 문자열 처리 (toLowerCase, charAt)
         *
         * 5. 게임 개발 패턴:
         *    - 초기화 → 게임루프 → 입력처리 → 상태업데이트 → 화면출력 → 종료처리
         *
         * 확장 아이디어:
         * - 장애물 추가 (벽, 함정)
         * - 여러 개의 보물
         * - 시간 제한
         * - 점수 시스템
         * - 레벨 시스템
         */
    }
}
