package com.tekleo.recipes.biz.example.persistence;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.shared.AbstractPersistenceService;
import com.tekleo.recipes.shared.id.ExampleId;

import java.util.List;

/**
 * Sample persistence service interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:28
 */
public interface ExamplePersistenceService extends AbstractPersistenceService {
    ExampleBO getExample(ExampleId exampleId) throws ExamplePersistenceServiceException;

    List<ExampleBO> getAllExamples() throws ExamplePersistenceServiceException;

    ExampleBO addExample(ExampleBO newEntity) throws ExamplePersistenceServiceException;

    ExampleBO updateExample(ExampleBO updatedEntity) throws ExamplePersistenceServiceException;

    ExampleBO deleteExample(ExampleId exampleId) throws ExamplePersistenceServiceException;
}