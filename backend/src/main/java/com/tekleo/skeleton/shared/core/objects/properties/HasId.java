package com.tekleo.skeleton.shared.core.objects.properties;

import com.tekleo.skeleton.shared.core.objects.id.AbstractId;

/**
 * This is a marker interface. It shows that this object has an ID.
 * In this interface we force the object to provide getters and setters for this property.
 *
 * @param <I> id type of the object
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:50
 */
public interface HasId<I extends AbstractId> {
    /**
     * Getter for id
     * @return id
     */
    I getId();

    /**
     * Setter for id
     * @param id id
     */
    void setId(I id);
}