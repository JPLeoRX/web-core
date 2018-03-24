package com.tekleo.recipes.shared.exceptions;

/**
 * API exception
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:23
 */
public class APIException extends Exception {
    public APIException() {

    }

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIException(Throwable cause) {
        super(cause);
    }

    public APIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}