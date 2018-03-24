package com.tekleo.recipes.biz.example;

import com.tekleo.recipes.biz.example.persistence.ExamplePersistenceService;
import com.tekleo.recipes.biz.example.persistence.ExamplePersistenceServiceException;
import com.tekleo.recipes.shared.id.ExampleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 15:05
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExamplePersistenceService persistenceService;

    @Override
    public ExampleBO getExample(ExampleId exampleId) throws ExampleServiceException {
        try {
            return persistenceService.getExample(exampleId);
        } catch (ExamplePersistenceServiceException e) {
            throw new ExampleServiceException(e);
        }
    }

    @Override
    public List<ExampleBO> getAllExamples() throws ExampleServiceException {
        try {
            return persistenceService.getAllExamples();
        } catch (ExamplePersistenceServiceException e) {
            throw new ExampleServiceException(e);
        }
    }

    @Override
    public ExampleBO addExample(ExampleBO newEntity) throws ExampleServiceException {
        try {
            return persistenceService.addExample(newEntity);
        } catch (ExamplePersistenceServiceException e) {
            throw new ExampleServiceException(e);
        }
    }

    @Override
    public ExampleBO updateExample(ExampleBO updatedEntity) throws ExampleServiceException {
        try {
            return persistenceService.updateExample(updatedEntity);
        } catch (ExamplePersistenceServiceException e) {
            throw new ExampleServiceException(e);
        }
    }

    @Override
    public ExampleBO deleteExample(ExampleId exampleId) throws ExampleServiceException {
        try {
            return persistenceService.deleteExample(exampleId);
        } catch (ExamplePersistenceServiceException e) {
            throw new ExampleServiceException(e);
        }
    }
}