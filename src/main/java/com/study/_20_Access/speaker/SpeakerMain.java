package com.study._20_Access.speaker;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(50);
        speaker.volumeUp();
        speaker.volumeDown();
        speaker.volumeDown();
        speaker.showVolume();


    }
}
