package com.tekleo.recipes.biz.example.persistence;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.biz.example.ExampleConverterDOBO;
import com.tekleo.recipes.shared.id.ExampleId;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 14:32
 */
@Service
@Transactional
public class ExamplePersistenceServiceImpl implements ExamplePersistenceService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ExampleBO getExample(ExampleId exampleId) throws ExamplePersistenceServiceException {
        // Find DO
        ExampleDO found = entityManager.find(ExampleDO.class, exampleId.getInternalId());

        // If none found
        if (found == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + exampleId);

        // Convert to BO
        return new ExampleBO(found);
    }

    @Override
    public List<ExampleBO> getAllExamples() throws ExamplePersistenceServiceException {
        // Create a query
        TypedQuery<ExampleDO> query = entityManager.createQuery("FROM ExampleDO", ExampleDO.class);

        // Execute it, store results as DO
        List<ExampleDO> results = query.getResultList();

        // Convert results to BO
        return new ExampleConverterDOBO().toBO(results);
    }

    @Override
    public ExampleBO addExample(ExampleBO newEntity) throws ExamplePersistenceServiceException {
        // Create DO
        ExampleDO toAdd = new ExampleDO(newEntity);

        // Write to database
        entityManager.persist(toAdd);

        // Convert to BO
        return new ExampleBO(toAdd);
    }

    @Override
    public ExampleBO updateExample(ExampleBO updatedEntity) throws ExamplePersistenceServiceException {
        // Find DO
        ExampleDO found = entityManager.find(ExampleDO.class, updatedEntity.getExampleId().getInternalId());

        // If none found
        if (found == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + updatedEntity.getExampleId());

        // Create DO
        ExampleDO toUpdate = new ExampleDO(updatedEntity);

        // Update in the database
        entityManager.merge(toUpdate);

        // Convert to BO
        return new ExampleBO(toUpdate);
    }

    @Override
    public ExampleBO deleteExample(ExampleId exampleId) throws ExamplePersistenceServiceException {
        // Find DO
        ExampleDO toDelete = entityManager.find(ExampleDO.class, exampleId.getInternalId());

        // If none found
        if (toDelete == null)
            throw new ExamplePersistenceServiceException("No object found for id=" + exampleId);

        // Delete in the database
        entityManager.remove(toDelete);

        // Convert to BO
        return new ExampleBO(toDelete);
    }
}