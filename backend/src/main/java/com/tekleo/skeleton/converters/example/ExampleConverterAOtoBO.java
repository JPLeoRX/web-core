package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterAOtoBO;

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

        exampleBO.setId(exampleAO.getId());
        exampleBO.setText(exampleAO.getText());
        exampleBO.setCreatedAt(exampleAO.getCreatedAt());

        return exampleBO;
    }
}
