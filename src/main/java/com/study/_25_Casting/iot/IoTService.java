package com.study._25_Casting.iot;

public class IoTService {
    private IoTDevice[] devices;
    private int deviceCount;

    public IoTService(int maxDevices) {
        this.devices = new IoTDevice[maxDevices];
        this.deviceCount = 0;
    }

    // 기기 추가
    public void addDevice(IoTDevice device) {
        if (deviceCount < devices.length) {
            devices[deviceCount] = device;
            deviceCount++;
            System.out.println("기기 등록 완료: " + device.deviceName);
        } else {
            System.out.println("기기 등록 실패: 최대 등록 수 초과");
        }
    }

    // 모든 기기 전원 켜기
    public void powerOnAll() {
        System.out.println("\n=== 모든 기기 전원 켜기 ===");
        for (int i = 0; i < deviceCount; i++) {
            devices[i].powerOn();
        }
    }

    // 모든 기기 전원 끄기
    public void powerOffAll() {
        System.out.println("\n=== 모든 기기 전원 끄기 ===");
        for (int i = 0; i < deviceCount; i++) {
            devices[i].powerOff();
        }
    }

    // 모든 기기 동작시키기
    public void operateAll() {
        System.out.println("\n=== 모든 기기 동작 ===");
        for (int i = 0; i < deviceCount; i++) {
            devices[i].operate();  // 다형성! 각 기기별로 다른 동작
        }
    }

    // 모든 기기 상태 확인
    public void showAllStatus() {
        System.out.println("\n=== 전체 기기 상태 ===");
        for (int i = 0; i < deviceCount; i++) {
            devices[i].showStatus();  // 다형성! 각 기기별로 다른 상태 표시
            System.out.println();
        }
    }

    // 특정 기기 찾기 (ID로)
    public IoTDevice findDevice(String deviceId) {
        for (int i = 0; i < deviceCount; i++) {
            if (devices[i].deviceId.equals(deviceId)) {
                return devices[i];
            }
        }
        return null;
    }

    // instanceof를 사용한 타입별 제어
    public void controlByType() {
        System.out.println("\n=== 타입별 특화 제어 ===");
        for (int i = 0; i < deviceCount; i++) {
            IoTDevice device = devices[i];

            if (device instanceof AirConditioner) {
                AirConditioner ac = (AirConditioner) device;
                ac.setTemperature(22);
                ac.setMode("냉방");
            } else if (device instanceof Styler) {
                Styler styler = (Styler) device;
                styler.setCourse("셔츠");
            }
        }
    }
}
