package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.biz.example.persistence.ExampleDO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterDOtoBO;
import com.tekleo.skeleton.shared.id.ExampleId;

import java.sql.Timestamp;

/**
 * Simple converter to switch from DO to BO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:20
 */
public class ExampleConverterDOtoBO implements AbstractConverterDOtoBO<ExampleDO, ExampleBO> {
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