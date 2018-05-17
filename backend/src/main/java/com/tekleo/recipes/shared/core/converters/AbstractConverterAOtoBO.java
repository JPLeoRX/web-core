package com.tekleo.recipes.shared.core.converters;

import com.tekleo.recipes.shared.core.objects.AbstractAO;
import com.tekleo.recipes.shared.core.objects.AbstractBO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Api Objects to Business Objects
 *
 * @param <A> api object (AO)
 * @param <B> business object (BO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 12:44
 */
public interface AbstractConverterAOtoBO<A extends AbstractAO, B extends AbstractBO> extends Converter<A, B> {
    /**
     * Convert single instance from AO to BO
     * @param apiObject api object
     * @return business object
     */
    public abstract B toBO(A apiObject);

    /**
     * Convert a collection of AO to BO
     * @param apiObjectsList collection of api objects
     * @return list of business objects
     */
    default List<B> toBO(Collection<A> apiObjectsList) {
        return apiObjectsList.parallelStream().map(this::toBO).collect(Collectors.toList());
    }
}