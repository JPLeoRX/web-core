package io.github.jpleorx.web.core.searching;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple search interface. It'll provide easy plug-and-play searching options.
 * We will use parallel streams and filters to achieve adequate performance without getting our hands dirty.
 *
 * @param <E> generic type of the searched object
 *
 * @author Leo Ertuna
 * @since 28.05.2018 16:42
 */
public interface Search<E> {
    /**
     * Search criteria
     * @param e analyzed object
     * @return true if this object matches your desired search criteria, false otherwise
     */
    boolean criteria(E e);

    /**
     * Find all objects that match a given criteria in the list
     * @param list list of objects
     * @return list of all objects that matched
     */
    default List<E> search(List<E> list) {
        return list.parallelStream().filter(this::criteria).collect(Collectors.toList());
    }
}