package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractAO;
import io.github.jpleorx.web.core.objects.AbstractBO;

import java.util.ArrayList;
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
        // If it is greater than threshold size - run it through a parallel stream
        if (apiObjectsList.size() > this.getParallelismThreshold()) {
            return apiObjectsList.parallelStream().map(this::toBO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<B> businessObjects = new ArrayList<>(apiObjectsList.size());
            for (A apiObject : apiObjectsList)
                businessObjects.add(this.toBO(apiObject));
            return businessObjects;
        }
    }
}