package com.tekleo.skeleton.shared.core.converters;

import com.tekleo.skeleton.shared.core.objects.AbstractAO;
import com.tekleo.skeleton.shared.core.objects.AbstractBO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Business Objects to Api Objects
 *
 * @param <B> business object (BO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterBOtoAO<B extends AbstractBO, A extends AbstractAO> extends Converter<B, A> {
    /**
     * Convert single instance from BO to AO
     * @param businessObject business object
     * @return api object
     */
    public abstract A toAO(B businessObject);

    /**
     * Convert a collection of BO to AO
     * @param businessObjectsList collection of business objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<B> businessObjectsList) {
        return businessObjectsList.parallelStream().map(this::toAO).collect(Collectors.toList());
    }
}