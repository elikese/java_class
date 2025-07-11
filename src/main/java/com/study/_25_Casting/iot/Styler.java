package com.study._25_Casting.iot;

public class Styler extends IoTDevice{
    private String course;     // 코스 ("표준", "셔츠", "울", "담요")
    private int timeLeft;      // 남은 시간 (분)

    public Styler(String deviceId) {
        super(deviceId, "스마트 스타일러");
        this.course = "표준";
        this.timeLeft = 0;
    }

    @Override
    public void operate() {
        if (!isPowerOn) {
            System.out.println("[" + deviceName + "] 전원이 꺼져있습니다");
            return;
        }
        if (timeLeft > 0) {
            System.out.println("[" + deviceName + "] 이미 동작 중입니다. 남은 시간: " + timeLeft + "분");
            return;
        }
        this.timeLeft = getCourseTime(course);
        System.out.println("[" + deviceName + "] " + course + " 코스로 " + timeLeft + "분 동작 시작");
    }

    // 스타일러만의 고유 기능
    public void setCourse(String course) {
        if (!isPowerOn) {
            System.out.println("[" + deviceName + "] 전원을 먼저 켜주세요");
            return;
        }
        this.course = course;
        System.out.println("[" + deviceName + "] " + course + " 코스로 설정");
    }

    public void checkProgress() {
        if (timeLeft > 0) {
            timeLeft -= 10;  // 10분씩 감소
            if (timeLeft <= 0) {
                System.out.println("[" + deviceName + "] 스타일링 완료!");
                timeLeft = 0;
            } else {
                System.out.println("[" + deviceName + "] 남은 시간: " + timeLeft + "분");
            }
        } else {
            System.out.println("[" + deviceName + "] 동작 중이 아닙니다");
        }
    }

    private int getCourseTime(String course) {
        switch (course) {
            case "표준":
                return 30;
            case "셔츠":
                return 20;
            case "울":
                return 40;
            case "담요":
                return 60;
            default:
                return 30;
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("코스: " + course);
        System.out.println("남은 시간: " + timeLeft + "분");
    }
}
