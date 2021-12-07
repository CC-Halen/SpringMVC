package com.cdw.exception;

/**
 * @author: cdw
 * @date: 2021/11/27 20:00
 * @description:
 */
public class MyException extends Exception{
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
