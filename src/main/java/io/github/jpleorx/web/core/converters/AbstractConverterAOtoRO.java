package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractAO;
import io.github.jpleorx.web.core.objects.AbstractRO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Api Objects to Rest Api Objects
 *
 * @param <A> api object (AO)
 * @param <R> rest api object (RO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterAOtoRO<A extends AbstractAO, R extends AbstractRO> extends Converter<A, R> {
    /**
     * Convert single instance from AO to RO
     * @param apiObject api object
     * @return rest api object
     */
    public abstract R toRO(A apiObject);

    /**
     * Convert a collection of AO to RO
     * @param apiObjectsList collection of api objects
     * @return list of rest api objects
     */
    default List<R> toRO(Collection<A> apiObjectsList) {
        // If it is greater than threshold size - run it through a parallel stream
        if (apiObjectsList.size() > this.getParallelismThreshold()) {
            return apiObjectsList.parallelStream().map(this::toRO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<R> restApiObjects = new ArrayList<>(apiObjectsList.size());
            for (A apiObject : apiObjectsList)
                restApiObjects.add(this.toRO(apiObject));
            return restApiObjects;
        }
    }
}