package com.tekleo.skeleton.biz.example.persistence;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.converters.example.ExampleConverterBOtoDO;
import com.tekleo.skeleton.converters.example.ExampleConverterDOtoBO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoDO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterDOtoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Sample persistence service implementation
 *
 * This class is a Spring service {@link Service} with access to the database {@link Transactional}
 *
 * Database operations occur using {@link EntityManager}
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:32
 */
@Service
@Transactional
public class ExamplePersistenceServiceImpl implements ExamplePersistenceService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ExampleConverterDOtoBO exampleConverterDOtoBO;

    @Autowired
    private ExampleConverterBOtoDO exampleConverterBOtoDO;

    @Autowired
    private ExamplePersistenceServiceExceptionManager exceptionManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<ExampleDO> getDatabaseObjectClass() {
        return ExampleDO.class;
    }

    @Override
    public AbstractConverterDOtoBO<ExampleDO, ExampleBO> getDOtoBOConverter() {
        return exampleConverterDOtoBO;
    }

    @Override
    public AbstractConverterBOtoDO<ExampleBO, ExampleDO> getBOtoDOConverter() {
        return exampleConverterBOtoDO;
    }

    @Override
    public ExamplePersistenceServiceExceptionManager getExceptionManager() {
        return exceptionManager;
    }
}