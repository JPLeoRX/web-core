package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.restapi.example.ExampleFO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterFOtoAO;
import com.tekleo.skeleton.shared.date_and_time.Time;
import com.tekleo.skeleton.shared.id.ExampleId;

public class ExampleConverterFOtoAO implements AbstractConverterFOtoAO<ExampleFO, ExampleAO> {
    /**
     * Convert from FO to AO
     * @param formObject FO
     * @return AO
     */
    @Override
    public ExampleAO toAO(ExampleFO formObject) {
        ExampleAO exampleAO = new ExampleAO();

        exampleAO.setExampleId(new ExampleId());
        exampleAO.setCreatedAt(Time.Current.getAsTimestamp());
        exampleAO.setText(formObject.getText());

        return exampleAO;
    }
}