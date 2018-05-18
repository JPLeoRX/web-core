package com.tekleo.skeleton.shared.core.services;

import com.tekleo.skeleton.shared.core.AbstractId;
import com.tekleo.skeleton.shared.core.exceptions.PersistenceServiceException;
import com.tekleo.skeleton.shared.core.exceptions.ServiceException;
import com.tekleo.skeleton.shared.core.objects.AbstractBO;

import java.util.List;

/**
 * This class will represent a service
 *
 * All default operations from {@link AbstractPersistenceService} are implemented here
 *
 * We should extend this interface and add more methods if we need any additional operations on top of default {@link AbstractPersistenceService} scope
 *
 * @param <I> id of this entity
 * @param <B> business object
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:31
 */
public interface AbstractService<I extends AbstractId, B extends AbstractBO<I>> {
    /**
     * Get a pointer to the persistence service
     * @return persistence service
     */
    AbstractPersistenceService<I, ?, B> getPersistenceService();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B get(I id) throws ServiceException {
        try {
            return getPersistenceService().get(id);
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getAll() throws ServiceException {
        try {
            return getPersistenceService().getAll();
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B add(B newItem) throws ServiceException {
        try {
            return getPersistenceService().add(newItem);
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B update(B updatedItem) throws ServiceException {
        try {
            return getPersistenceService().update(updatedItem);
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Remove item from the database
     * @param removedItem item to remove
     * @return removed item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B remove(B removedItem) throws ServiceException {
        try {
            return getPersistenceService().remove(removedItem);
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default int removeAll() throws ServiceException {
        try {
            return getPersistenceService().removeAll();
        } catch (PersistenceServiceException e) {
            throw new ServiceException(e);
        }
    }
}