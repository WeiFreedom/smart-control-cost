package com.wei.utils.exception;

public class WorkingException extends RuntimeException {
    public WorkingException(String message){
        super(message);
    }

    public WorkingException(Throwable throwable){
        super(throwable);
    }

    public WorkingException(String message,Throwable throwable){
        super(message,throwable);
    }
}
