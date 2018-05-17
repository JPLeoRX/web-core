package com.tekleo.recipes.shared.core.services;

import com.tekleo.recipes.shared.core.AbstractId;
import com.tekleo.recipes.shared.core.converters.AbstractConverterAOtoBO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterBOtoAO;
import com.tekleo.recipes.shared.core.exceptions.ApiException;
import com.tekleo.recipes.shared.core.exceptions.ServiceException;
import com.tekleo.recipes.shared.core.objects.AbstractAO;
import com.tekleo.recipes.shared.core.objects.AbstractBO;

import java.util.List;

/**
 * This class will represent an API
 *
 * All default operations from {@link AbstractService} are implemented here
 *
 * We should extend this interface and add more methods if we need any additional operations on top of default {@link AbstractService} scope
 *
 * @param <I> id of this entity
 * @param <B> business object
 * @param <A> api object
 *
 * @author Leo Ertuna
 * @since 17.05.2018 13:05
 */
public interface AbstractApi<I extends AbstractId, B extends AbstractBO<I>, A extends AbstractAO<I>> {
    /**
     * Get a pointer to the service
     * @return service
     */
    AbstractService<I, B> getService();

    /**
     * Get converter from BO to AO
     * @return converter
     */
    AbstractConverterBOtoAO<B, A> getBOtoAOConverter();

    /**
     * Get converter from AO to BO
     * @return converter
     */
    AbstractConverterAOtoBO<A, B> getAOtoBOConverter();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A get(I id) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().get(id));
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getAll() throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getAll());
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A add(A newItem) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().add(getAOtoBOConverter().toBO(newItem)));
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A update(A updatedItem) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().update(getAOtoBOConverter().toBO(updatedItem)));
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Remove item from the database
     * @param removedItem item to remove
     * @return removed item
     * @throws ApiException if {@link ServiceException} occurred
     */
    default A remove(A removedItem) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().remove(getAOtoBOConverter().toBO(removedItem)));
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Remove item from the database
     * @param id id of the item to remove
     * @return removed item
     * @throws ApiException if {@link ServiceException} occurred or any of nested {@link ApiException} occurred
     */
    default A remove(I id) throws ApiException {
        return remove(get(id));
    }
}