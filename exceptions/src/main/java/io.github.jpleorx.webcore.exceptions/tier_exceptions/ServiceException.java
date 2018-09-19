package io.github.jpleorx.webcore.exceptions.tier_exceptions;

import io.github.jpleorx.webcore.exceptions.WebException;

/**
 * An exception to be used in all services
 *
 * All your exceptions that are used in services must extend this exception
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
public class ServiceException extends WebException {
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