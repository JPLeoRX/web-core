package com.tekleo.recipes.shared.core.exceptions;

import com.tekleo.recipes.shared.core.services.AbstractService;

/**
 * An exception to be used in all {@link AbstractService}
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
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