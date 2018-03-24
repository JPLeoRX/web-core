package com.tekleo.recipes.restapi.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.shared.converters.AbstractConverterAORO;
import com.tekleo.recipes.shared.id.ExampleId;

import java.sql.Timestamp;

/**
 * Simple converter to switch between AO and RO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:53
 */
public class ExampleConverterAORO extends AbstractConverterAORO<ExampleAO, ExampleRO> {
    /**
     * Convert from RO to AO
     * @param exampleRO RO
     * @return AO
     */
    public ExampleAO toAO(ExampleRO exampleRO) {
        ExampleAO exampleAO = new ExampleAO();

        exampleAO.setExampleId(new ExampleId(exampleRO.getExampleId()));
        exampleAO.setText(exampleRO.getText());
        exampleAO.setCreatedAt(new Timestamp(exampleRO.getCreatedAt()));

        return exampleAO;
    }

    /**
     * Convert from AO to RO
     * @param exampleAO AO
     * @return RO
     */
    public ExampleRO toRO(ExampleAO exampleAO) {
        ExampleRO exampleRO = new ExampleRO();

        exampleRO.setExampleId(exampleAO.getExampleId().getInternalId());
        exampleRO.setText(exampleAO.getText());
        exampleRO.setCreatedAt(exampleAO.getCreatedAt().getTime());

        return exampleRO;
    }
}