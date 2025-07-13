package com.study._25_Casting.iot;

public class Main {
    public static void main(String[] args) {
        // IoT 매니저 생성
        IoTManager manager = new IoTManager(10);

        // 다양한 IoT 기기들 생성 및 등록
        AirConditioner ac1 = new AirConditioner("AC001");
        AirConditioner ac2 = new AirConditioner("AC002");
        Styler styler1 = new Styler("ST001");

        // 기기 추가
        manager.addDevice(ac1);
        manager.addDevice(ac2);
        manager.addDevice(styler1);

        // 다형성 활용 - 배열로 통합 관리
        manager.powerOnAll();
        manager.operateAll();

        // 개별 작동
        styler1 = (Styler) manager.getDevice("ST001");
        styler1.setCourse(Styler.STANDARD);
        styler1.doProgress();
        styler1.doProgress();
        styler1.doProgress();
        styler1.showStatus();


        // 특정 기기들만 작동
        AirConditioner[] acs = manager.getAirConditioners();
        for (AirConditioner ac : acs) {
            ac.setMode(AirConditioner.COLD);
            ac.setTemperature(24);
            ac.operate();
        }

        // 다시 동작시켜서 설정 변경 확인
        manager.operateAll();

        // 전체 상태 확인
        manager.showAllStatus();

    }
}
