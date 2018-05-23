package com.tekleo.skeleton.shared.core.exceptions;

import org.springframework.stereotype.Service;

/**
 * Default exception manager for {@link PersistenceServiceException}
 *
 * If you don't want to specify your own exceptions and their manager - feel free to use this default implementation.
 * It will be more than sufficient for most projects.
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:39
 */
@Service
public class PersistenceServiceExceptionManager implements ExceptionManager<PersistenceServiceException> {
    @Override
    public PersistenceServiceException create() {
        return new PersistenceServiceException();
    }

    @Override
    public PersistenceServiceException create(String message) {
        return new PersistenceServiceException(message);
    }

    @Override
    public PersistenceServiceException create(Throwable cause) {
        return new PersistenceServiceException(cause);
    }

    @Override
    public PersistenceServiceException create(String message, Throwable cause) {
        return new PersistenceServiceException(message, cause);
    }
}