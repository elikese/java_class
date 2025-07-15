package com.study._29_Object;

public class ObjectStudent {
    /*
     * Object 클래스 - 자바의 모든 클래스의 최상위 부모 클래스
     *
     * 자바에서 모든 클래스는 명시적으로 다른 클래스를 상속하지 않으면
     * 자동으로 Object 클래스를 상속받는다.
     * => Object가 가지고 있는 기본적인 메서드들을 사용가능, 오버라이딩 가능
     * 
     */

    private String name;
    private int age;

    public ObjectStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * toString() 메서드 재정의
     *
     * Object 클래스의 기본 toString()은 다음과 같이 구현되어 있음:
     * public String toString() {
     *     return getClass().getName() + "@" + Integer.toHexString(hashCode());
     * }
     *
     * 기본 구현은 "클래스명@해시코드(16진수)" 형태로 출력됨
     * 객체의 상태 정보를 문자열로 표현하려면 재정의 필요
     *
     * 용도:
     * - 디버깅 시 객체 상태 확인
     * - 로깅 목적
     * - System.out.println() 등에서 객체 출력 시 자동 호출
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    /*
     * equals() 메서드 재정의
     *
     * Object 클래스의 기본 equals()는 다음과 같이 구현되어 있음:
     * public boolean equals(Object obj) {
     *     return (this == obj);
     * }
     *
     * 기본 구현은 == 연산자와 동일하게 참조 동일성(reference equality)만 비교
     * 논리적 동등성(logical equality)을 구현하려면 재정의 필요
     *
     * equals() 메서드 재정의 시 준수해야 할 규약:
     * 1. 반사성(reflexive): x.equals(x)는 항상 true
     * 2. 대칭성(symmetric): x.equals(y)가 true면 y.equals(x)도 true
     * 3. 이행성(transitive): x.equals(y)가 true이고 y.equals(z)가 true면 x.equals(z)도 true
     * 4. 일관성(consistent): 객체 상태가 변경되지 않는 한 여러 번 호출해도 결과가 동일
     * 5. null과의 비교: x.equals(null)은 항상 false
     */
    @Override
    public boolean equals(Object obj) {
        // 1. 참조 동일성 검사 (성능 최적화)
        if (this == obj) return true;

        // 2. null 검사
        if (obj == null) return false;

        // 3. 클래스 타입 검사
        // getClass() 사용: 정확히 같은 클래스인지 확인 (상속 관계 고려 안 함)
        // instanceof 대신 getClass() 사용하는 이유:
        // - 리스코프 치환 원칙 위반 방지
        // - 대칭성 보장
        if (getClass() != obj.getClass()) return false;

        // 4. 타입 캐스팅 후 필드 비교
        ObjectStudent student = (ObjectStudent) obj;

        // 기본형 필드는 == 사용
        // 참조형 필드는 Objects.equals() 또는 null 체크 후 equals() 사용
        return age == student.age &&
                (name != null ? name.equals(student.name) : student.name == null);
    }

    /*
     * hashCode() 메서드 재정의
     *
     * Object 클래스의 기본 hashCode()는 객체의 메모리 주소를 기반으로 해시값 생성
     * equals()를 재정의하면 반드시 hashCode()도 재정의해야 함
     *
     * hashCode() 규약:
     * 1. 같은 객체에 대해 여러 번 호출하면 항상 같은 값 반환 (애플리케이션 실행 중)
     * 2. equals()가 true인 두 객체는 반드시 같은 hashCode 값을 가져야 함
     * 3. equals()가 false인 두 객체의 hashCode가 다를 필요는 없음 (하지만 다르면 성능상 유리)
     *
     * hashCode가 필요한 이유:
     * - HashMap, HashSet 등 해시 기반 컬렉션에서 객체 식별에 사용
     * - equals() 비교 전 hashCode로 1차 필터링하여 성능 향상
     */
    @Override
    public int hashCode() {
        // 일반적인 hashCode 구현 패턴:
        // 1. 각 필드의 해시값을 계산
        // 2. 31을 곱하고 더함 (31은 홀수 소수로 오버플로우 시 정보 손실 최소화)
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

        // 실무에서는 Objects.hash(name, age) 사용 권장
    }

}
