package com.study._13_Array;

public class StackHeap {
    public static void main(String[] args) {
        // stack - 작지만 한번에 빠르게 접근가능, 원시자료형 값/ 참조자료형 주소 저장
        // heap - 크지만 물어 물어 찾아가야 함, JVM이 알아서 메모리 관리/정리, 참조자료형 주소/값 저장


        // === 1단계: 기본 자료형 변수들 ===
        int age = 25;           // Stack에 25 저장
        double height = 175.5;  // Stack에 175.5 저장
        boolean isStudent = true; // Stack에 true 저장

        /*
         * 현재 Stack 상태:
         * ┌─────────────────────┐
         * │ main 메서드 영역     │
         * │ ├─ age: 25         │
         * │ ├─ height: 175.5   │
         * │ ├─ isStudent: true │
         * └─────────────────────┘
         *
         * Heap: 아직 비어있음
         */

        System.out.println("=== 1단계: 기본 자료형 ===");
        System.out.println("age: " + age + " (Stack에 직접 저장)");
        System.out.println("height: " + height + " (Stack에 직접 저장)");
        System.out.println("isStudent: " + isStudent + " (Stack에 직접 저장)");


        // === 2단계: 배열 생성 ===
        int[] scores = {85, 90, 78}; // Heap에 배열 생성, Stack에는 주소 저장

        /*
         * 현재 메모리 상태:
         *
         * Stack                        Heap
         * ┌────────────────────┐     ┌─────────────────────┐
         * │ main 메서드 영역     │     │ 0x1000: [85,90,78]  │
         * │ ├─ age: 25         │     └─────────────────────┘
         * │ ├─ height: 175.5   │
         * │ ├─ isStudent: true │
         * │ ├─ scores: 0x1000  │────▶ (주소로 연결)
         * └────────────────────┘
         */

        System.out.println("\n=== 2단계: 배열 생성 ===");
        System.out.println("scores 변수: Stack에 주소(0x1000) 저장");
        System.out.println("실제 배열 데이터: Heap에 저장");
        System.out.println("scores[0] = " + scores[0] + " (Heap에서 가져옴)");


        // === 3단계: 문자열 생성 ===
        String name = "홍길동";      // Heap에 문자열 객체 생성
        String school = "서울대학교"; // Heap에 또 다른 문자열 객체 생성

        /*
         * 현재 메모리 상태:
         *
         * Stack                        Heap
         * ┌────────────────────┐     ┌─────────────────────┐
         * │ main 메서드 영역     │     │ 0x1000: [85,90,78]  │
         * │ ├─ age: 25         │     │ 0x2000: "홍길동"     │
         * │ ├─ height: 175.5   │     │ 0x3000: "서울대학교"  │
         * │ ├─ isStudent: true │     └─────────────────────┘
         * │ ├─ scores: 0x1000  │────▶
         * │ ├─ name: 0x2000    │────▶
         * │ ├─ school: 0x3000  │────▶
         * └────────────────────┘
         */

        System.out.println("\n=== 3단계: 문자열 생성 ===");
        System.out.println("name 변수: Stack에 주소(0x2000) 저장");
        System.out.println("실제 문자열: Heap에 저장");
        System.out.println("name = " + name);


        // === 4단계: 참조 복사 vs 값 복사 ===
        int age2 = age;           // 값 복사 (Stack에서 Stack으로)
        int[] scores2 = scores;   // 주소 복사 (같은 Heap 객체를 가리킴)

        /*
         * 현재 메모리 상태:
         *
         * Stack                        Heap
         * ┌────────────────────┐     ┌─────────────────────┐
         * │ main 메서드 영역     │     │ 0x1000: [85,90,78]  │
         * │ ├─ age: 25         │     │ 0x2000: "홍길동"     │
         * │ ├─ height: 175.5   │     │ 0x3000: "서울대학교"  │
         * │ ├─ isStudent: true │     └─────────────────────┘
         * │ ├─ scores: 0x1000  │────▶ (같은 배열)
         * │ ├─ name: 0x2000    │────▶     ▲
         * │ ├─ school: 0x3000  │────▶     │
         * │ ├─ age2: 25        │          │
         * │ ├─ scores2: 0x1000 │──────────┘
         * └─────────────────────┘
         */

        System.out.println("\n=== 4단계: 복사 비교 ===");
        System.out.println("age2 = age (값 복사)");
        System.out.println("scores2 = scores (주소 복사)");

        // 값 변경 테스트
        age2 = 30;        // age는 그대로, age2만 변경
        scores2[0] = 95;  // scores와 scores2 둘 다 영향받음!

        System.out.println("age2 = 30으로 변경 후:");
        System.out.println("  age: " + age + " (변경 안됨)");
        System.out.println("  age2: " + age2 + " (변경됨)");

        System.out.println("scores2[0] = 95로 변경 후:");
        System.out.println("  scores[0]: " + scores[0] + " (함께 변경됨!)");
        System.out.println("  scores2[0]: " + scores2[0] + " (변경됨)");


        // === 5단계: 새로운 객체 생성 ===
        int[] newScores = new int[3];  // 새로운 배열 생성
        newScores[0] = 100;
        newScores[1] = 200;
        newScores[2] = 300;

        /*
         * 최종 메모리 상태:
         *
         * Stack                        Heap
         * ┌─────────────────────┐     ┌─────────────────────┐
         * │ main 메서드 영역      │     │ 0x1000: [95,90,78]  │
         * │ ├─ age: 25          │     │ 0x2000: "홍길동"     │
         * │ ├─ height: 175.5    │     │ 0x3000: "서울대학교"  │
         * │ ├─ isStudent: true  │     │ 0x4000: [100,200,300]│
         * │ ├─ scores: 0x1000   │────▶└─────────────────────┘
         * │ ├─ name: 0x2000     │────▶     ▲
         * │ ├─ school: 0x3000   │────▶     │
         * │ ├─ age2: 30         │          │
         * │ ├─ scores2: 0x1000  │──────────┘
         * │ ├─ newScores: 0x4000│──────────┘
         * └─────────────────────┘
         */

        System.out.println("\n=== 5단계: 새로운 배열 생성 ===");
        System.out.println("newScores: 새로운 Heap 공간(0x4000)에 생성");
        System.out.println("newScores[0] = " + newScores[0]);


        // === 6단계: 메서드 종료 ===
        System.out.println("\n=== 6단계: main 메서드 종료 시 ===");
        System.out.println("Stack의 main 영역 전체가 사라짐");
        System.out.println("Heap의 객체들은 가비지 컬렉터가 나중에 정리");

        /*
         * main 메서드가 끝나면:
         *
         * Stack                        Heap
         * ┌─────────────────────┐     ┌─────────────────────┐
         * │     비어있음         │     │ 0x1000: [95,90,78] │ ← 참조 끊김
         * └─────────────────────┘     │ 0x2000: "홍길동"    │ ← 참조 끊김
         *                             │ 0x3000: "서울대학교" │ ← 참조 끊김
         *                             │ 0x4000: [100,200,300]│ ← 참조 끊김
         *                             └─────────────────────┘
         *
         * 가비지 컬렉터가 나중에 Heap의 사용하지 않는 객체들을 정리
         */
    }
}
