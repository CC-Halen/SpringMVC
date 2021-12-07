package com.cdw.exception;

import com.cdw.exception.MyException;

/**
 * @author: cdw
 * @date: 2021/11/27 20:00
 * @description:
 */
public class AgeException extends MyException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
