package com.tekleo.recipes.biz.example;

import com.tekleo.recipes.shared.exceptions.ServiceException;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 15:01
 */
public final class ExampleServiceException extends ServiceException {
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