package com.covid19.Exception;

public class MemberException extends RuntimeException{

    public MemberException() {
    }

    public MemberException(String message) {
        super(message);
    }
}
