package io.github.jpleorx.web.core.objects;

import io.github.jpleorx.web.core.objects.id.AbstractId;
import io.github.jpleorx.web.core.objects.properties.HasId;

/**
 * This is the parent class for all Api Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractAO<I extends AbstractId> extends Entity<I>, HasId<I> {
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