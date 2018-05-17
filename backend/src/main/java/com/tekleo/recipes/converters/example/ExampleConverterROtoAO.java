package com.tekleo.recipes.converters.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.restapi.example.ExampleRO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterROtoAO;
import com.tekleo.recipes.shared.id.ExampleId;

import java.sql.Timestamp;

/**
 * Simple converter to switch from RO to AO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:32
 */
public class ExampleConverterROtoAO implements AbstractConverterROtoAO<ExampleRO, ExampleAO> {
    /**
     * Convert from RO to AO
     * @param restApiObject RO
     * @return AO
     */
    @Override
    public ExampleAO toAO(ExampleRO restApiObject) {
        ExampleAO apiObject = new ExampleAO();

        apiObject.setExampleId(new ExampleId(restApiObject.getExampleId()));
        apiObject.setText(restApiObject.getText());
        apiObject.setCreatedAt(new Timestamp(restApiObject.getCreatedAt()));

        return apiObject;
    }
}