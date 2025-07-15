package com.study._30_Wrapper;

public class WrapperMain {
    public static void main(String[] args) {
        /*
         * 1. 원시형의 한계 확인
         *
         * 원시형은 객체가 아니므로:
         * - 메서드를 가질 수 없음
         * 외부에서 직접 메서드를 만들어서 사용해야 한다.
         * num1 = 80
         * num1.compareTo(100)
         * 마치 객체처럼 자신의 상태를 기반으로 메서드를 사용하면 좋지만,
         * 원시형은 객체가 아니라서 이게 불가능하다.
         *
         * - null 값을 가질 수 없음
         * int의 경우 기본값이 0
         * int[] nums = {1,2,3,4,0}
         * 마지막 자리의 0은 초기화가 안된건지
         * 의도적으로 0이 들어간건지
         * 알수가 없게된다.
         * 차라리 null이라면 초기화를 안한자리구나 라고 인지가 가능
         * 마찮가지로 학생의 점수를 관리한다고 할때
         * int score;
         * score의 값이 0이면, 초기화가 안된건지 아니면 진짜 0점인건지 판단 불가능
         */

        /*
         * 2. 래퍼 클래스 생성 - 박싱(Boxing)
         *
         * 기본형 → 래퍼 클래스 객체로 변환하는 과정
         * 마치 상자에 물건을 넣는 것과 같다고 해서 "박싱"이라고 함
         */
        System.out.println("\n=== 래퍼 클래스 생성 (박싱) ===");

        // 직접 박싱 (명시적)
        Integer boxedScore1 = Integer.valueOf(85);      // 권장 방법
        Integer boxedScore2 = Integer.valueOf("90");    // 문자열에서 변환
        Long boxedLong = Long.valueOf(100L);
        Double boxedDouble = Double.valueOf(95.5);
        Boolean boxedBoolean = Boolean.valueOf(true);
        Character boxedChar = Character.valueOf('A');

        System.out.println("Integer: " + boxedScore1);
        System.out.println("Long: " + boxedLong);
        System.out.println("Double: " + boxedDouble);
        System.out.println("Boolean: " + boxedBoolean);
        System.out.println("Character: " + boxedChar);

        /*
         * 3. 래퍼 클래스에서 기본형 추출 - 언박싱(Unboxing)
         *
         * 래퍼 클래스 객체 → 기본형으로 변환하는 과정
         * 상자에서 물건을 꺼내는 것과 같다고 해서 "언박싱"이라고 함
         */
        System.out.println("\n=== 기본형 추출 (언박싱) ===");

        int unboxedInt = boxedScore1.intValue();
        long unboxedLong = boxedLong.longValue();
        double unboxedDouble = boxedDouble.doubleValue();
        boolean unboxedBoolean = boxedBoolean.booleanValue();
        char unboxedChar = boxedChar.charValue();

        System.out.println("언박싱된 int: " + unboxedInt);
        System.out.println("언박싱된 long: " + unboxedLong);
        System.out.println("언박싱된 double: " + unboxedDouble);

        /*
         * 4. 오토 박싱/언박싱 (Auto Boxing/Unboxing)
         *
         * 자바 1.5부터 지원하는 기능
         * 컴파일러가 자동으로 박싱/언박싱 코드를 추가해줌
         */
        System.out.println("\n=== 오토 박싱/언박싱 ===");

        // 오토 박싱: 컴파일러가 Integer.valueOf(95) 추가
        Integer autoBoxed = 95;

        // 오토 언박싱: 컴파일러가 autoBoxed.intValue() 추가
        int autoUnboxed = autoBoxed;

        System.out.println("오토 박싱 결과: " + autoBoxed);
        System.out.println("오토 언박싱 결과: " + autoUnboxed);

        // 연산에서도 오토 박싱/언박싱 발생
        Integer num1 = 10;
        Integer num2 = 20;
        Integer result = num1 + num2;  // 내부적으로 언박싱 → 연산 → 박싱
        System.out.println("래퍼 클래스 연산: " + num1 + " + " + num2 + " = " + result);

        /*
         * 5. 래퍼 클래스 비교 - equals() 사용 필수
         *
         * 래퍼 클래스는 객체이므로 == 연산자는 참조값을 비교
         * 값을 비교하려면 반드시 equals() 사용
         */
        System.out.println("\n=== 래퍼 클래스 비교 ===");

        Integer a = Integer.valueOf(100);
        Integer b = Integer.valueOf(100);
        Integer c = Integer.valueOf(200);

        System.out.println("a == b: " + (a == b));           // 실제로는 true (캐시 때문)
        System.out.println("a.equals(b): " + a.equals(b));   // true
        System.out.println("a.equals(c): " + a.equals(c));   // false

        /*
         * Integer 캐시 메커니즘:
         * -128 ~ 127 범위의 값은 미리 생성된 객체를 재사용
         * 성능 최적화를 위한 기능 (문자열 풀과 유사)
         */
        Integer cached1 = 127;
        Integer cached2 = 127;
        Integer noCached1 = 128;
        Integer noCached2 = 128;

        System.out.println("캐시 범위(-128~127) == 비교: " + (cached1 == cached2));     // true
        System.out.println("캐시 범위 밖 == 비교: " + (noCached1 == noCached2));        // false

        /*
         * 6. 래퍼 클래스의 주요 메서드들
         */
        System.out.println("\n=== 래퍼 클래스 주요 메서드 ===");

        Integer number = 42;

        // 문자열 변환
        String str1 = number.toString();                    // "42"
        String str2 = Integer.toString(123);                // "123"

        // 문자열에서 숫자로 변환
        int parsed1 = Integer.parseInt("456");              // 기본형 반환
        Integer parsed2 = Integer.valueOf("789");           // 래퍼 클래스 반환

        // 비교 메서드
        int compareResult = number.compareTo(50);           // 42 < 50 이므로 음수

        // 유틸리티 메서드
        int max = Integer.max(10, 20);
        int min = Integer.min(10, 20);
        int sum = Integer.sum(10, 20);
    }
}
