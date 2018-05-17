package com.tekleo.recipes.converters.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterAOtoBO;

/**
 * Simple converter to switch from AO to BO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:32
 */
public class ExampleConverterAOtoBO implements AbstractConverterAOtoBO<ExampleAO, ExampleBO> {
    /**
     * Convert from AO to BO
     * @param exampleAO AO
     * @return BO
     */
    @Override
    public ExampleBO toBO(ExampleAO exampleAO) {
        ExampleBO exampleBO = new ExampleBO();

        exampleBO.setExampleId(exampleAO.getExampleId());
        exampleBO.setText(exampleAO.getText());
        exampleBO.setCreatedAt(exampleAO.getCreatedAt());

        return exampleBO;
    }
}