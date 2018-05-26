package com.tekleo.skeleton.shared.core.objects;

import com.tekleo.skeleton.shared.core.objects.id.AbstractId;

/**
 * This is the parent class for all Api Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractAO<I extends AbstractId> extends Entity<I> {
    /**
     * Getter for id
     * @return
     */
    I getId();

    /**
     * Setter for id
     * @param newId
     */
    void setId(I newId);
}