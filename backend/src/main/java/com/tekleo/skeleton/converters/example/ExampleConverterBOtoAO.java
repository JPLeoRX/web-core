package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoAO;

/**
 * Simple converter to switch from BO to AO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:32
 */
public class ExampleConverterBOtoAO implements AbstractConverterBOtoAO<ExampleBO, ExampleAO> {
    /**
     * Convert from BO to AO
     * @param businessObject BO
     * @return AO
     */
    @Override
    public ExampleAO toAO(ExampleBO businessObject) {
        ExampleAO apiObject = new ExampleAO();

        apiObject.setExampleId(businessObject.getExampleId());
        apiObject.setText(businessObject.getText());
        apiObject.setCreatedAt(businessObject.getCreatedAt());

        return apiObject;
    }
}