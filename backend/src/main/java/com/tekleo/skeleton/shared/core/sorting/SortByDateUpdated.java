package com.tekleo.skeleton.shared.core.sorting;

import com.tekleo.skeleton.shared.core.objects.properties.HasDateUpdated;

/**
 * Generic sorting by date updated
 * @param <E> generic type of object, must have a date updated
 *
 * @author Leo Ertuna
 * @since 26.05.2018 17:54
 */
public class SortByDateUpdated<E extends HasDateUpdated> implements Sort<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getUpdatedAt().compareTo(o2.getUpdatedAt());
    }
}