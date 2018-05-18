package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.restapi.example.ExampleRO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterAOtoRO;
import org.springframework.stereotype.Service;

/**
 * Simple converter to switch between AO and RO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:53
 */
@Service
public class ExampleConverterAOtoRO implements AbstractConverterAOtoRO<ExampleAO, ExampleRO> {
    /**
     * Convert from AO to RO
     * @param apiObject AO
     * @return RO
     */
    public ExampleRO toRO(ExampleAO apiObject) {
        ExampleRO exampleRO = new ExampleRO();

        exampleRO.setId(apiObject.getId().getInternalId());
        exampleRO.setText(apiObject.getText());
        exampleRO.setCreatedAt(apiObject.getCreatedAt().getTime());

        return exampleRO;
    }
}