package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.shared.core.exceptions.ApiException;

public class ExampleApiException extends ApiException {
    public ExampleApiException() {

    }

    public ExampleApiException(String message) {
        super(message);
    }

    public ExampleApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExampleApiException(Throwable cause) {
        super(cause);
    }

    public ExampleApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}