package com.tekleo.skeleton.restapi.example;

import com.tekleo.skeleton.shared.core.exceptions.RestApiException;

public class ExampleRestApiException extends RestApiException {
    public ExampleRestApiException() {

    }

    public ExampleRestApiException(String message) {
        super(message);
    }

    public ExampleRestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExampleRestApiException(Throwable cause) {
        super(cause);
    }

    public ExampleRestApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}