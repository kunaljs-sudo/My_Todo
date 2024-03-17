package com.demo.myTodo.exception;

public class MyToDoException extends RuntimeException {

    private String errorCode;

    public MyToDoException(String msg) {
        super(msg);

    }

    public MyToDoException() {
        super();

    }

    public MyToDoException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
