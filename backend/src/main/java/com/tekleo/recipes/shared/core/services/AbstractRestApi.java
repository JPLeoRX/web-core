package com.tekleo.recipes.shared.core.services;

import com.tekleo.recipes.shared.core.AbstractId;
import com.tekleo.recipes.shared.core.converters.AbstractConverterAOtoRO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterFOtoAO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterROtoAO;
import com.tekleo.recipes.shared.core.exceptions.ApiException;
import com.tekleo.recipes.shared.core.exceptions.RestApiException;
import com.tekleo.recipes.shared.core.objects.AbstractAO;
import com.tekleo.recipes.shared.core.objects.AbstractFO;
import com.tekleo.recipes.shared.core.objects.AbstractRO;

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
 *
 * @author Leo Ertuna
 * @since 17.05.2018 15:00
 */
public interface AbstractRestApi<I extends AbstractId, A extends AbstractAO<I>, R extends AbstractRO<I>, F extends AbstractFO<I>> {
    /**
     * Get a pointer to the api
     * When implementing change the return type to your API
     * @return api
     */
    AbstractApi<I, ?, A> getApi();

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
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws RestApiException if {@link ApiException} occurred
     */
    default R get(I id) throws RestApiException {
        try {
            return getAOtoROConverter().toRO(getApi().get(id));
        } catch (ApiException e) {
            throw new RestApiException(e);
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
            throw new RestApiException(e);
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
            throw new RestApiException(e);
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
            throw new RestApiException(e);
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
            return getAOtoROConverter().toRO(getApi().remove(id));
        } catch (ApiException e) {
            throw new RestApiException(e);
        }
    }
}