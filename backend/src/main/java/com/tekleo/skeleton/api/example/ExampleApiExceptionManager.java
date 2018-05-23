package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.shared.core.exceptions.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class ExampleApiExceptionManager implements ExceptionManager<ExampleApiException> {
    @Override
    public ExampleApiException create() {
        return new ExampleApiException();
    }

    @Override
    public ExampleApiException create(String message) {
        return new ExampleApiException(message);
    }

    @Override
    public ExampleApiException create(Throwable cause) {
        return new ExampleApiException(cause);
    }

    @Override
    public ExampleApiException create(String message, Throwable cause) {
        return new ExampleApiException(message, cause);
    }
}