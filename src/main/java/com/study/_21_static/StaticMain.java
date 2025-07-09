package com.study._21_static;

public class StaticMain {
    public static void main(String[] args) {
        /*
            method area (메서드 영역)
            - 클래스의 바이트코드, 메서드 정보, static 변수 등이 저장됨
            - 클래스 로딩 시 JVM이 관리하는 공간

            heap 영역
            - new로 생성된 인스턴스가 저장되는 공간
            - 인스턴스 변수는 이곳에 저장됨
         */


        StaticData data1 = new StaticData(1);
        StaticData data2 = new StaticData(2);
        StaticData data3 = new StaticData(3);

        System.out.println("count1: "  + data1.count);
        System.out.println("count2: "  + data2.count);
        System.out.println("count3: "  + data3.count);
        /*
            → count는 인스턴스 변수이므로 각 객체마다 따로 존재
            → 현재 구조에서는 생성될 때마다 1씩 증가하도록 되어 있으므로
               모든 객체의 count는 1로 출력됨 (각자 0 → 1 증가)
         */

        // 클래스 변수는 클래스 단 하나만 존재 (Method Area)
        System.out.println("instanceCount (권장): " + StaticData.instanceCount);
        System.out.println("instanceCount (비권장): " + data1.instanceCount);
        /*
            → instanceCount는 static 변수 (클래스 변수)
            → StaticData 클래스 전체에서 하나만 존재하며 공유됨
            → 생성자가 호출될 때마다 1씩 증가하므로 최종 값은 3

            → 클래스명을 통해 접근하는 것이 개념적으로 올바르고 권장됨
            → 인스턴스를 통해 접근하는 것도 가능하지만 권장되지 않는다.
         */

        /*
        public static void main(String[] args)
            public: 누구나 접근가능, JVM이 호출해야 하니까
            static: 객체 생성없이, 클래스 로딩만 되었을때 바로 실행가능 함, JVM이 호출해야 하니까
            void: 반환이 없다. main의 역할은 프로그램 시작만 담당

            String[] args: String[] 문자열 args를 매개변수로 받는다(java 외부로부터 전달 받음)
         */
        System.out.println(args[0]);
        System.out.println(args[1]);

    }
}
