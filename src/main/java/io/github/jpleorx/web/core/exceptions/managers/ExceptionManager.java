package io.github.jpleorx.web.core.exceptions.managers;

/**
 * Exception managers will provide a factory-like way of creating exceptions
 *
 * For each existing custom exception you'll need to create a class that implements this interface
 *
 * @param <E> generic type (child of {@link Exception})
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:35
 */
public interface ExceptionManager<E extends Exception> {
    /**
     * New instance
     * @return exception
     */
    E create();

    /**
     * New instance
     * @param message message
     * @return exception
     */
    E create(String message);

    /**
     * New instance
     * @param cause cause
     * @return exception
     */
    E create(Throwable cause);

    /**
     * New instance
     * @param message message
     * @param cause cause
     * @return exception
     */
    E create(String message, Throwable cause);
}