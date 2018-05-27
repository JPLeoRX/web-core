package io.github.jpleorx.web.core.sorting;

import io.github.jpleorx.web.core.objects.properties.HasId;

/**
 * Generic sorting by ID
 * @param <E> generic type of object, must have an ID
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:54
 */
public class SortById<E extends HasId> implements Sort<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getId().compareTo(o2.getId());
    }
}