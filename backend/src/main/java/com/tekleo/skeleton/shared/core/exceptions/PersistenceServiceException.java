package com.tekleo.skeleton.shared.core.exceptions;

import com.tekleo.skeleton.shared.core.services.AbstractPersistenceService;

/**
 * An exception to be used in all {@link AbstractPersistenceService}
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