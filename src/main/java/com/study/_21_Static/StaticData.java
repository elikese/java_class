package com.study._21_Static;

public class StaticData {
    private int id;

    // 인스턴스 변수: 각 인스턴스마다 별도로 존재함 (heap에 저장)
    // → 인스턴스마다 개별 값을 가지므로 공유되지 않음
    public int count;

    // 클래스 변수(static): StaticData 클래스 전체에서 단 하나만 존재 (method area에 저장)
    // → 모든 인스턴스가 값을 공유함
    public static int instanceCount;

    public StaticData(int id) {
        instanceCount++; // 클래스 단위 변수 → 클래스가 생성한 인스턴스의 총 수를 누적 기록
        count++; //  인스턴스 변수 → 각 인스턴스에서만 영향을 받음
        this.id = id;
    }

}
