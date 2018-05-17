package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.converters.example.ExampleConverterAOtoBO;
import com.tekleo.skeleton.converters.example.ExampleConverterBOtoAO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterAOtoBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoAO;
import com.tekleo.skeleton.shared.core.services.AbstractApi;
import com.tekleo.skeleton.shared.id.ExampleId;

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