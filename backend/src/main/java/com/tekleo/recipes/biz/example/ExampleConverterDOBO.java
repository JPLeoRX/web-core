package com.tekleo.recipes.biz.example;

import com.tekleo.recipes.shared.converters.AbstractConverterDOBO;
import com.tekleo.recipes.biz.example.persistence.ExampleDO;
import com.tekleo.recipes.shared.id.ExampleId;

import java.sql.Timestamp;

/**
 * Simple converter to switch between DO and BO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:20
 */
public class ExampleConverterDOBO extends AbstractConverterDOBO<ExampleDO, ExampleBO> {
    /**
     * Convert from BO to DO
     * @param exampleBO BO
     * @return DO
     */
    public ExampleDO toDO(ExampleBO exampleBO) {
        ExampleDO exampleDO = new ExampleDO();

        exampleDO.setExampleId(exampleBO.getExampleId().getInternalId());
        exampleDO.setText(exampleBO.getText());
        exampleDO.setCreatedAt(exampleBO.getCreatedAt().getTime());

        return exampleDO;
    }

    /**
     * Convert from DO to BO
     * @param exampleDO DO
     * @return BO
     */
    public ExampleBO toBO(ExampleDO exampleDO) {
        ExampleBO exampleBO = new ExampleBO();

        exampleBO.setExampleId(new ExampleId(exampleDO.getExampleId()));
        exampleBO.setText(exampleDO.getText());
        exampleBO.setCreatedAt(new Timestamp(exampleDO.getCreatedAt()));

        return exampleBO;
    }
}