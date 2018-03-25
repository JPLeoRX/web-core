package com.tekleo.recipes.api.example;

import com.tekleo.recipes.shared.AbstractAPI;
import com.tekleo.recipes.shared.exceptions.APIException;
import com.tekleo.recipes.shared.id.ExampleId;

import java.util.List;

/**
 * Sample API interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:37
 */
public interface ExampleAPI extends AbstractAPI {
    ExampleAO getExample(ExampleId exampleId) throws APIException;

    List<ExampleAO> getAllExamples() throws APIException;

    ExampleAO addExample(ExampleAO newEntity) throws APIException;

    ExampleAO addExample(String text) throws APIException;

    ExampleAO updateExample(ExampleAO updatedEntity) throws APIException;

    ExampleAO deleteExample(ExampleId exampleId) throws APIException;

    List<ExampleAO> deleteAllExamples() throws APIException;
}