package com.tekleo.recipes.api.example;

import com.tekleo.recipes.shared.APIException;
import com.tekleo.recipes.shared.id.ExampleId;

import java.util.List;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 15:37
 */
public interface ExampleAPI {
    ExampleAO getExample(ExampleId exampleId) throws APIException;

    List<ExampleAO> getAllExamples() throws APIException;

    ExampleAO addExample(ExampleAO newEntity) throws APIException;

    ExampleAO updateExample(ExampleAO updatedEntity) throws APIException;

    ExampleAO deleteExample(ExampleId exampleId) throws APIException;
}