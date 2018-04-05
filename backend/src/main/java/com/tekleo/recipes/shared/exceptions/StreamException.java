package com.tekleo.recipes.shared.exceptions;

/**
 * Exception to be used in anonymous functions defined for streams
 *
 * @author Leo Ertuna
 * @since 06.04.2018 00:30
 */
public class StreamException extends RuntimeException {
    public StreamException() {

    }

    public StreamException(String message) {
        super(message);
    }

    public StreamException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamException(Throwable cause) {
        super(cause);
    }

    public StreamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}