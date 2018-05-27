package io.github.jpleorx.web.core.sorting;

import io.github.jpleorx.web.core.objects.properties.HasDateCreated;

/**
 * Generic sorting by date created
 * @param <E> generic type of object, must have a date created
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:54
 */
public class SortByDateCreated<E extends HasDateCreated> implements Sort<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }
}