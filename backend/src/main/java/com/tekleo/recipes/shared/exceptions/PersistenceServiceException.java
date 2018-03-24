package com.tekleo.recipes.shared.exceptions;

/**
 * Persistence service exception
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:23
 */
public class PersistenceServiceException extends Exception {
    public PersistenceServiceException() {

    }

    public PersistenceServiceException(String message) {
        super(message);
    }

    public PersistenceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceServiceException(Throwable cause) {
        super(cause);
    }

    public PersistenceServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}