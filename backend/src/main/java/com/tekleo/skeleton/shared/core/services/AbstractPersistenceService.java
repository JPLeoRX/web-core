package com.tekleo.skeleton.shared.core.services;

import com.tekleo.skeleton.shared.core.AbstractId;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterBOtoDO;
import com.tekleo.skeleton.shared.core.converters.AbstractConverterDOtoBO;
import com.tekleo.skeleton.shared.core.exceptions.PersistenceServiceException;
import com.tekleo.skeleton.shared.core.objects.AbstractBO;
import com.tekleo.skeleton.shared.core.objects.AbstractDO;

import java.util.List;

/**
 * This class will represent a persistence service
 *
 * By default a persistence service must support 4 basic operation:
 * 1) Retrieve
 * 2) Add
 * 3) Update
 * 4) Remove
 *
 * We should extend this interface and add more methods if we need any additional operations
 *
 * @param <I> id of this entity
 * @param <D> database object
 * @param <B> business object
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
public interface AbstractPersistenceService<I extends AbstractId, D extends AbstractDO<I>, B extends AbstractBO<I>> {
    /**
     * Get converter from DO to BO
     * @return converter
     */
    AbstractConverterDOtoBO<D, B> getDOtoBOConverter();

    /**
     * Get converter from BO to DO
     * @return converter
     */
    AbstractConverterBOtoDO<B, D> getBOtoDOConverter();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws PersistenceServiceException
     */
    B get(I id) throws PersistenceServiceException;

    /**
     * Get all items from the database
     * @return list of all items
     * @throws PersistenceServiceException
     */
    List<B> getAll() throws PersistenceServiceException;

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws PersistenceServiceException
     */
    B add(B newItem) throws PersistenceServiceException;

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws PersistenceServiceException
     */
    B update(B updatedItem) throws PersistenceServiceException;

    /**
     * Remove item from the database
     * @param removedItem item to remove
     * @return removed item
     * @throws PersistenceServiceException
     */
    B remove(B removedItem) throws PersistenceServiceException;
}