package com.study._31_NestedClass.nested_static;

import com.study._31_NestedClass.nested_static.Response;

public class Main {
    public static void main(String[] args) {
        /*
         * 1. 정적 중첩 클래스 독립적 생성
         *
         * Result 클래스는 Response 인스턴스 없이도 생성 가능
         */
        System.out.println("1. 정적 중첩 클래스 독립 생성:");

        // 바깥 클래스 인스턴스 없이 Result 생성
        Response.Result result1 = new Response.Result("데이터 조회 성공", 200);
        Response.Result result2 = new Response.Result("권한 없음", 403);

        System.out.println(result1);
        System.out.println(result2);

        /*
         * 2. 정적 메서드 활용
         */
        System.out.println("2. 정적 메서드 활용:");

        Response.Result successResult = Response.Result.createSuccess();
        Response.Result errorResult = Response.Result.createError();

        successResult.printResult();
        System.out.println();
        errorResult.printResult();

        /*
         * 3. 실제 Response 객체 생성 및 사용
         */
        System.out.println("3. 실제 Response 객체 사용:");

        // 성공 응답
        String userData = "사용자 정보";
        Response.Result okResult = new Response.Result("조회 완료", 200);
        Response successResponse = new Response(true, userData, okResult);

        System.out.println("=== 성공 응답 ===");
        successResponse.printResponse();

        // 실패 응답
        Response.Result failResult = new Response.Result("사용자를 찾을 수 없음", 404);
        Response failResponse = new Response(false, null, failResult);

        System.out.println("=== 실패 응답 ===");
        failResponse.printResponse();

        /*
         * 4. 정적 중첩 클래스의 독립성 확인
         */
        System.out.println("4. 독립성 확인:");

        // Response 인스턴스들과 무관하게 Result 생성 가능
        Response.Result independentResult = new Response.Result("독립적 생성", 100);
        System.out.println("독립적으로 생성된 Result: " + independentResult);
    }
}
