package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractAO;
import io.github.jpleorx.web.core.objects.AbstractRO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Rest Api Objects to Api Objects
 *
 * @param <R> rest api object (RO)
 * @param <A> api object (AO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterROtoAO<R extends AbstractRO, A extends AbstractAO> extends Converter<R, A>  {
    /**
     * Convert single instance from RO to AO
     * @param restApiObject business object
     * @return api object
     */
    public abstract A toAO(R restApiObject);

    /**
     * Convert a collection of RO to AO
     * @param restApiObjectsList collection of rest api objects
     * @return list of api objects
     */
    default List<A> toAO(Collection<R> restApiObjectsList) {
        // If it is greater than threshold size - run it through a parallel stream
        if (restApiObjectsList.size() > this.getParallelismThreshold()) {
            return restApiObjectsList.parallelStream().map(this::toAO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<A> apiObjects = new ArrayList<>(restApiObjectsList.size());
            for (R restApiObject : restApiObjectsList)
                apiObjects.add(this.toAO(restApiObject));
            return apiObjects;
        }
    }
}