package com.study._25_Casting.iot;

public class Main {
    public static void main(String[] args) {
        // IoT 매니저 생성
        IoTService manager = new IoTService(10);

        // 다양한 IoT 기기들 생성 및 등록
        AirConditioner ac1 = new AirConditioner("AC001");
        AirConditioner ac2 = new AirConditioner("AC002");
        Styler styler1 = new Styler("ST001");


        manager.addDevice(ac1);
        manager.addDevice(ac2);
        manager.addDevice(styler1);

        // 다형성 활용 - 배열로 통합 관리
        manager.powerOnAll();
        manager.operateAll();

        // instanceof를 활용한 타입별 제어
        manager.controlByType();

        // 다시 동작시켜서 설정 변경 확인
        manager.operateAll();

        // 전체 상태 확인
        manager.showAllStatus();

    }
}
