package com.tekleo.recipes.shared.exceptions;

/**
 * Service exception
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:23
 */
public class ServiceException extends Exception {
    public ServiceException() {

    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}