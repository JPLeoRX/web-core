package com.tekleo.recipes.converters.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.restapi.example.ExampleFO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterFOtoAO;
import com.tekleo.recipes.shared.date_and_time.Time;
import com.tekleo.recipes.shared.id.ExampleId;

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