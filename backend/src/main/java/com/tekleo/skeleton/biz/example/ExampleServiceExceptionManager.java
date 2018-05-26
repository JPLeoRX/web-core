package com.tekleo.skeleton.biz.example;

import com.tekleo.skeleton.shared.core.exceptions.managers.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceExceptionManager implements ExceptionManager<ExampleServiceException> {
    @Override
    public ExampleServiceException create() {
        return new ExampleServiceException();
    }

    @Override
    public ExampleServiceException create(String message) {
        return new ExampleServiceException(message);
    }

    @Override
    public ExampleServiceException create(Throwable cause) {
        return new ExampleServiceException(cause);
    }

    @Override
    public ExampleServiceException create(String message, Throwable cause) {
        return new ExampleServiceException(message, cause);
    }
}