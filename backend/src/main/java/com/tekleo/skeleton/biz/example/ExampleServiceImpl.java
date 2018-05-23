package com.tekleo.skeleton.biz.example;

import com.tekleo.skeleton.biz.example.persistence.ExamplePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sample service implementation
 *
 * This class is a Spring service {@link Service} so we can inject it in various parts of the app
 * We access database here using the persistence service, which should be {@link Autowired} to work correctly
 *
 * Methods don't bear much implementation here, we just redirect to the persistence service and rethrow exceptions
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:05
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExamplePersistenceService persistenceService;

    @Autowired
    private ExampleServiceExceptionManager exceptionManager;

    @Override
    public ExamplePersistenceService getPersistenceService() {
        return persistenceService;
    }

    @Override
    public ExampleServiceExceptionManager getExceptionManager() {
        return exceptionManager;
    }
}