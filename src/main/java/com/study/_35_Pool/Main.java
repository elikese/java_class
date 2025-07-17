package com.study._35_Pool;

public class Main {
    public static void main(String[] args) {
        /*
         * Pool(풀) 패턴이란?
         * - 객체를 미리 만들어 놓고, 필요할 때 꺼내 쓰고 다시 반납하는 방식
         * - 매번 객체를 새로 생성하지 않고, 기존 것을 재사용하여 성능을 향상시킬 수 있음
         *
         * 실제 예시:
         * - 자바의 Integer.valueOf() 도 내부적으로 -128 ~ 127까지 캐싱된 Integer 객체를 재사용
         *   -> 이 범위의 숫자를 valueOf()로 생성하면 새로 만들지 않고 기존 객체를 반환함
         *
         * 사용 예시:
         * - 데이터베이스 연결(Connection)
         * - 스레드(Thread)
         * - TCP 소켓, 버퍼 등 생성 비용이 큰 리소스
         *
         * 사용 시기:
         * - 객체 생성 비용이 크고,
         * - 객체를 자주 반복적으로 사용하며,
         * - 동시에 사용할 수 있는 객체 수가 제한적인 경우
         *
         *
         */
        Restaurant restaurant = new Restaurant(5); // 테이블 5개인 음식점

        // 손님 입장
        Table t1 = restaurant.enter("홍길동");
        Table t2 = restaurant.enter("김철수");
        Table t3 = restaurant.enter("이영희");
        Table t4 = restaurant.enter("박영수");
        Table t5 = restaurant.enter("최수정");

        // 자리가 없음
        Table t6 = restaurant.enter("대기자1");

        // 손님 한 명 나감
        restaurant.leave(t3);

        // 대기 중이던 손님 입장
        Table t7 = restaurant.enter("대기자2");
    }
}
