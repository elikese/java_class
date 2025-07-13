package com.study._25_Casting.iot;

public class AirConditioner extends IoTDevice {
    private int temperature;
    private String mode;  // "냉방", "송풍"
    public static final String COLD = "냉방";
    public static final String WIND = "송풍";


    public AirConditioner(String deviceId) {
        super(deviceId, "스마트 에어컨");
        this.temperature = 24;
        this.mode = COLD;
    }

    @Override
    public void operate() {
        if(super.checkIsPowerOff()) {
            return;
        }
        System.out.println( deviceName + ": " + mode + "모드, " + temperature + "도 설정하여 동작 시작");
    }

    // 에어컨만의 고유 기능
    public void setTemperature(int temp) {
        if(super.checkIsPowerOff()) {
            return;
        }
        this.temperature = temp;
        System.out.println(deviceName + ": 온도를 " + temp + "도로 설정");
    }

    public void setMode(String mode) {
        if(super.checkIsPowerOff()) {
            return;
        }
        this.mode = mode;
        System.out.println(deviceName + ": " + mode + " 모드로 변경");
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("온도: " + temperature + "도");
        System.out.println("모드: " + mode);
    }

}
