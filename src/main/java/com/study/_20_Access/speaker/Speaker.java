package com.study._20_Access.speaker;

public class Speaker {
    private int volume;  // 외부에서 직접 접근 불가 (안전!)

    public Speaker(int volume) {
        this.volume = volume;
    }

    public void volumeUp() {
        volume += 10;
        if (volume > 100) {
            volume = 100;
        }
    }

    public void volumeDown() {
        volume -= 10;
        if (volume < 0) {
            volume = 0;
        }
    }

    public void showVolume() {
        System.out.println("현재 볼륨: " + volume);
    }
}
