package io.github.jpleorx.web.core.exceptions;

import io.github.jpleorx.web.core.services.AbstractApi;

/**
 * An exception to be used in all {@link AbstractApi}
 *
 * All your exceptions that are used in APIs must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
public class ApiException extends Exception {
    public ApiException() {

    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}