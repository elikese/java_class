package com.study._37_Exception;

public class InvalidEmailException extends RuntimeException {
    // TODO: InvalidEmailException 만들기
    // RuntimeException을 상속받아서 만들어보세요
    // 생성자에서 메시지를 받을 수 있도록 하세요
    public InvalidEmailException(String message) {
        super(message);
    }
}
