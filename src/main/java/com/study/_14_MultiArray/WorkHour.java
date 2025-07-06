package com.study._14_MultiArray;

public class WorkHour {
    public static void main(String[] args) {
        // 직원 ID에 해당하는 이름 배열
        String[] employeeNames = {"김철수", "이영희", "박민수", "최지우"};

        // {id, 근무시간, 시급}
        int[][] workRecords = {
                {0, 40, 10000},
                {1, 35, 12000},
                {2, 20, 9000},
                {3, 45, 11000}
        };

        // 1. 전체 근무 현황 출력
        System.out.println("=== 근무 현황 ===");
        System.out.println("이름\t근무시간\t시급");
        for (int i = 0; i < workRecords.length; i++) {
            int id = workRecords[i][0];
            int hours = workRecords[i][1];
            int wage = workRecords[i][2];
            System.out.println(employeeNames[id] + "\t" + hours + "시간\t" + wage + "원");
        }

        // 2. 전체 인건비 계산
        int totalPay = 0;
        for (int[] record : workRecords) {
            int hours = record[1];
            int wage = record[2];
            totalPay += hours * wage;
        }
        System.out.println("\n총 인건비: " + totalPay + "원");

        // 3. 특정 직원 찾기 (이영희)
        String targetName = "이영희";
        int targetId = -1;
        for (int i = 0; i < employeeNames.length; i++) {
            if (employeeNames[i].equals(targetName)) {
                targetId = i;
                break;
            }
        }

        for (int[] record : workRecords) {
            if (record[0] == targetId) {
                System.out.println("\n[직원 찾기: " + targetName + "]");
                System.out.println("- 근무 시간: " + record[1] + "시간");
                System.out.println("- 시급: " + record[2] + "원");
                break;
            }
        }

        // 4. 근무시간 부족 직원 찾기 (30시간 미만)
        System.out.println("\n[근무시간 부족 직원 (30시간 미만)]");
        boolean found = false;
        for (int[] record : workRecords) {
            if (record[1] < 30) {
                System.out.println("- " + employeeNames[record[0]] + ": " + record[1] + "시간");
                found = true;
            }
        }
        if (!found) {
            System.out.println("근무시간이 부족한 직원이 없습니다.");
        }
    }
}
