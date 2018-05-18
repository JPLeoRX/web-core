package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.restapi.example.ExampleRO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterROtoAO;
import com.tekleo.skeleton.shared.id.ExampleId;

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

        apiObject.setId(new ExampleId(restApiObject.getId()));
        apiObject.setText(restApiObject.getText());
        apiObject.setCreatedAt(new Timestamp(restApiObject.getCreatedAt()));

        return apiObject;
    }
}