package com.cdw.exception;

import com.cdw.exception.MyException;

/**
 * @author: cdw
 * @date: 2021/11/27 20:00
 * @description:
 */
public class NameException extends MyException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
