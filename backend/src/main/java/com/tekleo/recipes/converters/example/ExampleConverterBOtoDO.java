package com.tekleo.recipes.converters.example;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.biz.example.persistence.ExampleDO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterBOtoDO;

/**
 * Simple converter to switch from BO to DO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:20
 */
public class ExampleConverterBOtoDO implements AbstractConverterBOtoDO<ExampleBO, ExampleDO> {
    /**
     * Convert from BO to DO
     * @param exampleBO BO
     * @return DO
     */
    @Override
    public ExampleDO toDO(ExampleBO exampleBO) {
        ExampleDO exampleDO = new ExampleDO();

        exampleDO.setExampleId(exampleBO.getExampleId().getInternalId());
        exampleDO.setText(exampleBO.getText());
        exampleDO.setCreatedAt(exampleBO.getCreatedAt().getTime());

        return exampleDO;
    }
}
