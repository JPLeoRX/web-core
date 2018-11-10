package io.github.webcore.api;

import io.github.jpleorx.webcore.biz.AbstractService;
import io.github.jpleorx.webcore.converters.AbstractConverterAOtoBO;
import io.github.jpleorx.webcore.converters.AbstractConverterBOtoAO;
import io.github.jpleorx.webcore.entities.ApiObject;
import io.github.jpleorx.webcore.entities.BusinessObject;
import io.github.jpleorx.webcore.entities.id.AbstractId;
import io.github.jpleorx.webcore.exceptions.ExceptionManager;
import io.github.jpleorx.webcore.exceptions.tier_exceptions.ApiException;
import io.github.jpleorx.webcore.exceptions.tier_exceptions.ServiceException;

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
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 13:05
 */
public interface AbstractApi<I extends AbstractId, B extends BusinessObject<I>, A extends ApiObject<I>, E extends ExceptionManager<? extends ApiException>> {
    /**
     * Get a pointer to the service
     * @return service
     */
    AbstractService<I, B, ?> getService();

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
     * Get exception manager
     * @return exception manager
     */
    E getExceptionManager();

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
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, String value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, Object value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, long value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, double value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default List<A> getByProperty(String columnName, boolean value) throws ApiException {
        try {
            return getBOtoAOConverter().toAO(getService().getByProperty(columnName, value));
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
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
            throw getExceptionManager().create(e);
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
            throw getExceptionManager().create(e);
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
            throw getExceptionManager().create(e);
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
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws ApiException if {@link ServiceException} occurred
     */
    default int removeAll() throws ApiException {
        try {
            return getService().removeAll();
        } catch (ServiceException e) {
            throw getExceptionManager().create(e);
        }
    }
}