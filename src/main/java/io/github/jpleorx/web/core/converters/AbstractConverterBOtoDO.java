package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractBO;
import io.github.jpleorx.web.core.objects.AbstractDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Business Objects to Database Objects
 *
 * @param <B> business object (BO)
 * @param <D> database object (DO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 13:26
 */
public interface AbstractConverterBOtoDO<B extends AbstractBO, D extends AbstractDO> extends Converter<B, D> {
    /**
     * Convert single instance from BO to DO
     * @param businessObject business object
     * @return database object
     */
    public abstract D toDO(B businessObject);

    /**
     * Convert a collection of BO to DO
     * @param businessObjectsList collection of business objects
     * @return list of database objects
     */
    default List<D> toDO(Collection<B> businessObjectsList) {
        // If it is greater than threshold size - run it through a parallel stream
        if (businessObjectsList.size() > this.getParallelismThreshold()) {
            return businessObjectsList.parallelStream().map(this::toDO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<D> databaseObjects = new ArrayList<>(businessObjectsList.size());
            for (B businessObject : businessObjectsList)
                databaseObjects.add(this.toDO(businessObject));
            return databaseObjects;
        }
    }
}