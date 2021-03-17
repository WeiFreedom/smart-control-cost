package com.wei.utils.exception;

public class ValidatorException extends RuntimeException {
    public ValidatorException(String message){
        super(message);
    }

    public ValidatorException(Throwable throwable){
        super(throwable);
    }

    public ValidatorException(String message,Throwable throwable){
        super(message,throwable);
    }
}
