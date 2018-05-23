package com.tekleo.skeleton.shared.core.exceptions;

import com.tekleo.skeleton.shared.core.services.AbstractRestApi;

/**
 * An exception to be used in all {@link AbstractRestApi}
 *
 * All your exceptions that are used in REST APIs must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 21:09
 */
public class RestApiException extends Exception {
    public RestApiException() {

    }

    public RestApiException(String message) {
        super(message);
    }

    public RestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestApiException(Throwable cause) {
        super(cause);
    }

    public RestApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}