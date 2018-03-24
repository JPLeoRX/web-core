package com.tekleo.recipes.api.example;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.biz.example.ExampleService;
import com.tekleo.recipes.biz.example.ExampleServiceException;
import com.tekleo.recipes.shared.date_and_time.Time;
import com.tekleo.recipes.shared.exceptions.APIException;
import com.tekleo.recipes.shared.id.ExampleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ExampleAO getExample(ExampleId exampleId) throws APIException {
        try {
            return new ExampleAO(service.getExample(exampleId));
        } catch (ExampleServiceException e) {
            throw new APIException(e);
        }
    }

    @Override
    public List<ExampleAO> getAllExamples() throws APIException {
        try {
            return new ExampleConverterBOAO().toAO(service.getAllExamples());
        } catch (ExampleServiceException e) {
            throw new APIException(e);
        }
    }

    @Override
    public ExampleAO addExample(ExampleAO newEntity) throws APIException {
        try {
            return new ExampleAO(service.addExample(new ExampleBO(newEntity)));
        } catch (ExampleServiceException e) {
            throw new APIException(e);
        }
    }

    @Override
    public ExampleAO addExample(String text) throws APIException {
        return this.addExample(new ExampleAO(new ExampleId(), text, Time.Current.getAsTimestamp()));
    }

    @Override
    public ExampleAO updateExample(ExampleAO updatedEntity) throws APIException {
        try {
            return new ExampleAO(service.updateExample(new ExampleBO(updatedEntity)));
        } catch (ExampleServiceException e) {
            throw new APIException(e);
        }
    }

    @Override
    public ExampleAO deleteExample(ExampleId exampleId) throws APIException {
        try {
            return new ExampleAO(service.deleteExample(exampleId));
        } catch (ExampleServiceException e) {
            throw new APIException(e);
        }
    }
}