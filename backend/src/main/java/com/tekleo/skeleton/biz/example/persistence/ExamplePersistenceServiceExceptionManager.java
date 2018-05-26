package com.tekleo.skeleton.biz.example.persistence;

import com.tekleo.skeleton.shared.core.exceptions.managers.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class ExamplePersistenceServiceExceptionManager implements ExceptionManager<ExamplePersistenceServiceException> {
    @Override
    public ExamplePersistenceServiceException create() {
        return new ExamplePersistenceServiceException();
    }

    @Override
    public ExamplePersistenceServiceException create(String message) {
        return new ExamplePersistenceServiceException(message);
    }

    @Override
    public ExamplePersistenceServiceException create(Throwable cause) {
        return new ExamplePersistenceServiceException(cause);
    }

    @Override
    public ExamplePersistenceServiceException create(String message, Throwable cause) {
        return new ExamplePersistenceServiceException(message, cause);
    }
}
