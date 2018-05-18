package com.tekleo.skeleton.biz.example.persistence;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.converters.example.ExampleConverterDOtoBO;
import com.tekleo.skeleton.shared.id.ExampleId;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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
    public ExampleBO get(ExampleId id) throws ExamplePersistenceServiceException {
        // Check for null arguments
        if (id == null)
            throw new ExamplePersistenceServiceException("Id is null");

        // Find DO
        ExampleDO found = entityManager.find(ExampleDO.class, id.getInternalId());

        // If none found
        if (found == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + id);

        // Convert to BO
        return getDOtoBOConverter().toBO(found);
    }

    @Override
    public List<ExampleBO> getAll() throws ExamplePersistenceServiceException {
        // Create a query
        TypedQuery<ExampleDO> query = entityManager.createQuery("FROM ExampleDO", ExampleDO.class);

        // Execute it, store results as DO
        List<ExampleDO> results = query.getResultList();

        // Convert results to BO
        return new ExampleConverterDOtoBO().toBO(results);
    }

    @Override
    public ExampleBO add(ExampleBO newItem) throws ExamplePersistenceServiceException {
        // Check for null arguments
        if (newItem == null)
            throw new ExamplePersistenceServiceException("New entity is null");

        // Create DO
        ExampleDO toAdd = getBOtoDOConverter().toDO(newItem);

        // Write to database
        entityManager.persist(toAdd);

        // Convert to BO
        return getDOtoBOConverter().toBO(toAdd);
    }

    @Override
    public ExampleBO update(ExampleBO updatedItem) throws ExamplePersistenceServiceException {
        // Check for null arguments
        if (updatedItem == null)
            throw new ExamplePersistenceServiceException("Updated entity is null");

        // Find DO
        ExampleDO found = entityManager.find(ExampleDO.class, updatedItem.getId().getInternalId());

        // If none found
        if (found == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + updatedItem.getId());

        // Create DO
        ExampleDO toUpdate = getBOtoDOConverter().toDO(updatedItem);

        // Update in the database
        entityManager.merge(toUpdate);

        // Convert to BO
        return getDOtoBOConverter().toBO(toUpdate);
    }

    @Override
    public ExampleBO remove(ExampleBO removedItem) throws ExamplePersistenceServiceException {
        // Check for null arguments
        if (removedItem == null)
            throw new ExamplePersistenceServiceException("Removed entity is null");

        // Find DO
        ExampleDO toDelete = entityManager.find(ExampleDO.class, removedItem.getId().getInternalId());

        // If none found
        if (toDelete == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + removedItem.getId());

        // Delete in the database
        entityManager.remove(toDelete);

        // Convert to BO
        return getDOtoBOConverter().toBO(toDelete);
    }
}