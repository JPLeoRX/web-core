package com.tekleo.recipes.api.example;

import com.tekleo.recipes.biz.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sample API implementation
 *
 * This class is a Spring service {@link Service} so we can inject it in various parts of the app
 * We access database here using the business service, which should be {@link Autowired} to work correctly
 *
 * Methods don't bear much implementation here, we just redirect to the service and rethrow exceptions
 * In complex apps this API can be heavily loaded
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:37
 */
@Service
public class ExampleAPIImpl implements ExampleAPI {
    @Autowired
    private ExampleService service;

    @Override
    public ExampleService getService() {
        return service;
    }
}