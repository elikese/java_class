package com.study._31_NestedClass.nested_static;

public class Response {
    private static String systemVersion = "1.0";  // 정적 멤버
    private boolean success;
    private Object data;
    private Result result;

    /*
     * 정적 중첩 클래스 - Result
     *
     * API 응답의 결과 정보를 담는 클래스
     * Response와 관련 있지만 독립적으로 사용 가능
     *
     * static이 붙어있으므로:
     * - Response 인스턴스 없이도 생성 가능
     * - 바깥 클래스의 static 필드는 접근 가능
     * - 사실상 두개의 클래스를 정의하는 것과 다름없음.
     *
     * 언제 사용할까?
     * - 논리적으로 서로 응집되어 있지만, 서로 생명주기(객체가 메모리에 올라가고 삭제될때까지의 시점)가 다를때
     *
     * - 내부적으로 유틸리티 클래스가 필요할때(**)
     */

    public static class Result {
        private String message;
        private int code;

        public Result(String message, int code) {
            this.message = message;
            this.code = code;
        }

        public void printResult() {
            System.out.println("코드: " + code + ", 메시지: " + message);
            // 바깥 클래스의 static 필드에 접근 가능
            System.out.println("시스템 버전: " + systemVersion);

            // 바깥 클래스의 인스턴스 필드에는 직접 접근 불가
            // System.out.println("성공 여부: " + success);  // 컴파일 오류!
        }

        // 정적 메서드에서도 바깥 클래스의 정적 멤버만 접근 가능
        public static Result createSuccess() {
            return new Result("성공", 200);
        }

        public static Result createError() {
            return new Result("오류", 500);
        }

        // getter 메서드들
        public String getMessage() { return message; }
        public int getCode() { return code; }

        @Override
        public String toString() {
            return "Result{message='" + message + "', code=" + code + "}";
        }
    }

    // Response 생성자
    public Response(boolean success, Object data, Result result) {
        this.success = success;
        this.data = data;
        this.result = result;
    }

    public void printResponse() {
        System.out.println("성공: " + success);
        System.out.println("데이터: " + data);
        System.out.println("결과: " + result);
    }

    // getter 메서드들
    public boolean isSuccess() { return success; }
    public Object getData() { return data; }
    public Result getResult() { return result; }
}
