package com.tekleo.skeleton.biz.example.persistence;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.converters.example.ExampleConverterBOtoDO;
import com.tekleo.skeleton.converters.example.ExampleConverterDOtoBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoDO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterDOtoBO;
import com.tekleo.skeleton.shared.core.services.AbstractPersistenceService;
import com.tekleo.skeleton.shared.id.ExampleId;

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