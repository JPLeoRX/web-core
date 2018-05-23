package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.biz.example.ExampleService;
import com.tekleo.skeleton.converters.example.ExampleConverterAOtoBO;
import com.tekleo.skeleton.converters.example.ExampleConverterBOtoAO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterAOtoBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoAO;
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

    @Autowired
    private ExampleConverterBOtoAO exampleConverterBOtoAO;

    @Autowired
    private ExampleConverterAOtoBO exampleConverterAOtoBO;

    @Autowired
    private ExampleApiExceptionManager exceptionManager;

    @Override
    public ExampleService getService() {
        return service;
    }

    @Override
    public AbstractConverterBOtoAO<ExampleBO, ExampleAO> getBOtoAOConverter() {
        return exampleConverterBOtoAO;
    }

    @Override
    public AbstractConverterAOtoBO<ExampleAO, ExampleBO> getAOtoBOConverter() {
        return exampleConverterAOtoBO;
    }

    @Override
    public ExampleApiExceptionManager getExceptionManager() {
        return exceptionManager;
    }
}