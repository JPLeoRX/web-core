package com.tekleo.recipes.api.example;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.shared.AbstractConverterBOAO;

/**
 * Simple converter to switch between AO and BO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:32
 */
public class ExampleConverterBOAO extends AbstractConverterBOAO<ExampleBO, ExampleAO> {
    /**
     * Convert from BO to AO
     * @param exampleBO BO
     * @return AO
     */
    public ExampleAO toAO(ExampleBO exampleBO) {
        ExampleAO exampleAO = new ExampleAO();

        exampleAO.setExampleId(exampleBO.getExampleId());
        exampleAO.setText(exampleBO.getText());
        exampleAO.setCreatedAt(exampleBO.getCreatedAt());

        return exampleAO;
    }

    /**
     * Convert from AO to BO
     * @param exampleAO AO
     * @return BO
     */
    public ExampleBO toBO(ExampleAO exampleAO) {
        ExampleBO exampleBO = new ExampleBO();

        exampleBO.setExampleId(exampleAO.getExampleId());
        exampleBO.setText(exampleAO.getText());
        exampleBO.setCreatedAt(exampleAO.getCreatedAt());

        return exampleBO;
    }
}