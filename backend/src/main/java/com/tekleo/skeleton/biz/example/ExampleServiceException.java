package com.tekleo.skeleton.biz.example;

import com.tekleo.skeleton.shared.core.exceptions.ServiceException;

public class ExampleServiceException extends ServiceException {
    public ExampleServiceException() {

    }

    public ExampleServiceException(String message) {
        super(message);
    }

    public ExampleServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExampleServiceException(Throwable cause) {
        super(cause);
    }

    public ExampleServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
