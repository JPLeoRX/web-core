package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractAO;
import io.github.jpleorx.web.core.objects.AbstractFO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Form Objects to Api Objects
 *
 * @param <F> form object (FO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 14:35
 */
public interface AbstractConverterFOtoAO<F extends AbstractFO, A extends AbstractAO> {
    /**
     * Convert single instance from FO to AO
     * @param formObject form object
     * @return api object
     */
    public abstract A toAO(F formObject);

    /**
     * Convert a collection of FO to AO
     * @param formObjectsList collection of form objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<F> formObjectsList) {
        return formObjectsList.parallelStream().map(this::toAO).collect(Collectors.toList());
    }
}