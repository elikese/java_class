package com.study._25_Casting.iot;

public class IoTDevice {
    protected String deviceId;
    protected String deviceName;
    protected boolean isPowerOn;

    public IoTDevice(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.isPowerOn = false;
    }

    // 모든 IoT 기기의 공통 기능
    public void powerOn() {
        System.out.println(deviceName + "전원 ON");
        this.isPowerOn = true;
    }

    public void powerOff() {
        System.out.println(deviceName + "전원 OFF");
        this.isPowerOn = false;
    }

    public void showStatus() {
        System.out.println("=== " + deviceName + " 상태 ===");
        System.out.println("ID: " + deviceId);
        System.out.println("전원: " + (isPowerOn ? "ON" : "OFF"));
    }

    public boolean checkIsPowerOff() {
        if (!isPowerOn) {
            System.out.println(deviceName + " 전원이 꺼져있습니다");
            return true;
        }
        return false;
    }

    // 차후에 오버라이딩 할 것
    public void operate() {
        if (checkIsPowerOff()) {
            System.out.println("기본 동작으로 실행합니다!");
        }
    };

}
