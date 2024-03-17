package com.demo.myTodo.exception;

public class NullRequestBodyException extends MyToDoException {

    public NullRequestBodyException(String errorCode, String msg) {
        super(errorCode, msg);
    }

    public NullRequestBodyException(String errorCode) {
        super(errorCode);
    }

}
