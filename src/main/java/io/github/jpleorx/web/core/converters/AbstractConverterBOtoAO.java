package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractAO;
import io.github.jpleorx.web.core.objects.AbstractBO;

import java.util.ArrayList;
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
        // If it is greater than threshold size - run it through a parallel stream
        if (businessObjectsList.size() > this.getParallelismThreshold()) {
            return businessObjectsList.parallelStream().map(this::toAO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<A> apiObjects = new ArrayList<>(businessObjectsList.size());
            for (B businessObject : businessObjectsList)
                apiObjects.add(this.toAO(businessObject));
            return apiObjects;
        }
    }
}