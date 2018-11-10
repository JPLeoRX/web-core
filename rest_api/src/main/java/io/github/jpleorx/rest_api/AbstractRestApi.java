package io.github.jpleorx.rest_api;

import io.github.jpleorx.webcore.converters.AbstractConverterAOtoRO;
import io.github.jpleorx.webcore.converters.AbstractConverterFOtoAO;
import io.github.jpleorx.webcore.converters.AbstractConverterROtoAO;
import io.github.jpleorx.webcore.entities.ApiObject;
import io.github.jpleorx.webcore.entities.FormObject;
import io.github.jpleorx.webcore.entities.RestApiObject;
import io.github.jpleorx.webcore.entities.id.AbstractId;
import io.github.jpleorx.webcore.exceptions.ExceptionManager;
import io.github.jpleorx.webcore.exceptions.tier_exceptions.ApiException;
import io.github.jpleorx.webcore.exceptions.tier_exceptions.RestApiException;
import io.github.webcore.api.AbstractApi;

import java.util.List;

/**
 * This class will represent a REST API
 *
 * This abstraction only provides binding to converters and regular API for now
 *
 * @param <I> id of this entity
 * @param <A> api object
 * @param <R> rest api object
 * @param <F> form object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 15:00
 */
public interface AbstractRestApi<I extends AbstractId, A extends ApiObject<I>, R extends RestApiObject<I>, F extends FormObject<I>, E extends ExceptionManager<? extends RestApiException>> {
    /**
     * Get a pointer to the api
     * When implementing change the return type to your API
     * @return api
     */
    AbstractApi<I, ?, A, ?> getApi();

    /**
     * Get converter from AO to RO
     * @return converter
     */
    AbstractConverterAOtoRO<A, R> getAOtoROConverter();

    /**
     * Get converter from RO to AO
     * @return converter
     */
    AbstractConverterROtoAO<R, A> getROtoAOConverter();

    /**
     * Get converter from FO to AO
     * @return converter
     */
    AbstractConverterFOtoAO<F, A> getFOtoAOConverter();

    /**
     * Get exception manager
     * @return exception manager
     */
    E getExceptionManager();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws RestApiException if {@link ApiException} occurred
     */
    default R get(I id) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().get(id));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getByProperty(String columnName, String value) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getByProperty(columnName, value));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getByProperty(String columnName, Object value) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getByProperty(columnName, value));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getByProperty(String columnName, long value) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getByProperty(columnName, value));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getByProperty(String columnName, double value) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getByProperty(columnName, value));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getByProperty(String columnName, boolean value) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getByProperty(columnName, value));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default List<R> getAll() throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().getAll());
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws RestApiException if {@link ApiException} occurred
     */
    default R add(F newItem) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().add(getFOtoAOConverter().toAO(newItem)));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws RestApiException if {@link ApiException} occurred
     */
    default R update(R updatedItem) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().update(getROtoAOConverter().toAO(updatedItem)));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove item from the database
     * @param id id of the item to remove
     * @return removed item
     * @throws RestApiException if {@link ApiException} occurred
     */
    default R remove(I id) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().remove(getApi().get(id)));
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws RestApiException if {@link ApiException} occurred
     */
    default int removeAll() throws RestApiException {
        try {
            return getApi().removeAll();
        } catch (ApiException e) {
            throw getExceptionManager().create(e);
        }
    }
}