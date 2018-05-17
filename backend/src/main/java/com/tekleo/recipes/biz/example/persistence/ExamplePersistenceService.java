package com.tekleo.recipes.biz.example.persistence;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.converters.example.ExampleConverterBOtoDO;
import com.tekleo.recipes.converters.example.ExampleConverterDOtoBO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterBOtoDO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterDOtoBO;
import com.tekleo.recipes.shared.core.services.AbstractPersistenceService;
import com.tekleo.recipes.shared.id.ExampleId;

/**
 * Sample persistence service interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:28
 */
public interface ExamplePersistenceService extends AbstractPersistenceService<ExampleId, ExampleDO, ExampleBO> {
    @Override
    default AbstractConverterDOtoBO<ExampleDO, ExampleBO> getDOtoBOConverter() {
        return new ExampleConverterDOtoBO();
    }

    @Override
    default AbstractConverterBOtoDO<ExampleBO, ExampleDO> getBOtoDOConverter() {
        return new ExampleConverterBOtoDO();
    }
}