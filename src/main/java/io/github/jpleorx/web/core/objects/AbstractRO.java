package io.github.jpleorx.web.core.objects;

import io.github.jpleorx.web.core.objects.id.AbstractId;

/**
 * This is the parent class for all Rest Api Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractRO<I extends AbstractId> extends Entity<I> {
    /**
     * Getter for id
     * @return
     */
    String getId();

    /**
     * Setter for id
     * @param newId
     */
    void setId(String newId);
}