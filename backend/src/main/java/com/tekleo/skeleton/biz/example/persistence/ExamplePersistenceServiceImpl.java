package com.tekleo.skeleton.biz.example.persistence;

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

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<ExampleDO> getDatabaseObjectClass() {
        return ExampleDO.class;
    }
}