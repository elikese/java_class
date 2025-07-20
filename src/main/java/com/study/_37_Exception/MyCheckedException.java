package com.study._37_Exception;

public class MyCheckedException extends Exception{

    /*
     * 체크 예외 특징:
     * 1. Exception을 상속 (RuntimeException 제외)
     * 2. 컴파일 시점에 예외 처리 강제
     * 3. throws 선언 필수
     * 4. try-catch 또는 throws로 처리 필수
     *
     * 사용 시점: 복구 가능한 예외
     * 예) 파일 읽기 실패 -> 다른 파일을 읽게 만든다(복구 전개)
     * 네트워크 연결 실패 -> 일정 시간 후 재시도하거나, 다른 서버로 우회(복구 전개)
     */

    public MyCheckedException(String message) {
        super(message);
    }

}
