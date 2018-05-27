package io.github.jpleorx.web.core.exceptions;

import io.github.jpleorx.web.core.services.AbstractPersistenceService;

/**
 * An exception to be used in all {@link AbstractPersistenceService}
 *
 * All your exceptions that are used in persistence services must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
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