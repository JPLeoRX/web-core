package io.github.jpleorx.web.core.searching;

import io.github.jpleorx.web.core.objects.id.AbstractId;
import io.github.jpleorx.web.core.objects.properties.HasId;

/**
 * Generic search by ID
 * @param <E> generic type of object, must have an ID
 *
 * @author Leo Ertuna
 * @since 28.05.2018 16:42
 */
public class SearchById<E extends HasId> implements Search<E> {
    private AbstractId id;

    /**
     * Constructor
     * @param id id
     */
    public SearchById(AbstractId id) {
        this.id = id;
    }

    /**
     * Search criteria
     * @param e analyzed object
     * @return true if the IDs are the same, false otherwise
     */
    @Override
    public boolean criteria(E e) {
        return e.getId().equals(id);
    }
}