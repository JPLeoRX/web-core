package com.tekleo.recipes.converters.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.restapi.example.ExampleRO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterAOtoRO;

/**
 * Simple converter to switch between AO and RO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:53
 */
public class ExampleConverterAOtoRO implements AbstractConverterAOtoRO<ExampleAO, ExampleRO> {
    /**
     * Convert from AO to RO
     * @param apiObject AO
     * @return RO
     */
    public ExampleRO toRO(ExampleAO apiObject) {
        ExampleRO exampleRO = new ExampleRO();

        exampleRO.setExampleId(apiObject.getExampleId().getInternalId());
        exampleRO.setText(apiObject.getText());
        exampleRO.setCreatedAt(apiObject.getCreatedAt().getTime());

        return exampleRO;
    }
}