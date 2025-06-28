package com.study._03_Operator;

public class Operator4 {
    public static void main(String[] args) {
        // && : 둘 다 참일 때만 참 (and)
        int age = 25;
        boolean hasLicense = true;
        // 운전 가능 조건: 18세 이상 AND 면허 소지
        boolean canDrive = (age >= 18) && hasLicense;
        System.out.println("운전 가능: " + canDrive);  // true


        // || : 둘 중 하나라도 참이면 참 (or)
        boolean isWeekend = true;
        boolean isHoliday = false;
        // 휴일 조건: 주말 OR 공휴일
        boolean isRest = isWeekend || isHoliday;
        System.out.println("쉬는 날: " + isRest);  // true


        // ! : 참을 거짓으로, 거짓을 참으로 뒤집기
        boolean isOnline = true;
        boolean isOffline = !isOnline;  // true의 반대는 false
        System.out.println("온라인: " + isOnline);   // true
        System.out.println("오프라인: " + isOffline); // false
    }
}
