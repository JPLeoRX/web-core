package com.tekleo.skeleton.restapi.example;

import com.tekleo.skeleton.shared.core.exceptions.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class ExampleRestApiExceptionManager implements ExceptionManager<ExampleRestApiException> {
    @Override
    public ExampleRestApiException create() {
        return new ExampleRestApiException();
    }

    @Override
    public ExampleRestApiException create(String message) {
        return new ExampleRestApiException(message);
    }

    @Override
    public ExampleRestApiException create(Throwable cause) {
        return new ExampleRestApiException(cause);
    }

    @Override
    public ExampleRestApiException create(String message, Throwable cause) {
        return new ExampleRestApiException(message, cause);
    }
}