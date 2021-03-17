package com.wei.utils.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message){
        super(message);
    }

    public AuthenticationException(Throwable throwable){
        super(throwable);
    }

    public AuthenticationException(String message,Throwable throwable){
        super(message,throwable);
    }
}
