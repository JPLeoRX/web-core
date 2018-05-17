package com.tekleo.recipes.api.example;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.converters.example.ExampleConverterAOtoBO;
import com.tekleo.recipes.converters.example.ExampleConverterBOtoAO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterAOtoBO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterBOtoAO;
import com.tekleo.recipes.shared.core.services.AbstractApi;
import com.tekleo.recipes.shared.id.ExampleId;

/**
 * Sample API interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:37
 */
public interface ExampleAPI extends AbstractApi<ExampleId, ExampleBO, ExampleAO> {
    @Override
    default AbstractConverterBOtoAO<ExampleBO, ExampleAO> getBOtoAOConverter() {
        return new ExampleConverterBOtoAO();
    }

    @Override
    default AbstractConverterAOtoBO<ExampleAO, ExampleBO> getAOtoBOConverter() {
        return new ExampleConverterAOtoBO();
    }
}