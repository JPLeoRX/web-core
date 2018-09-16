package io.github.jpleorx.web.core.converters;

import io.github.jpleorx.web.core.objects.AbstractBO;
import io.github.jpleorx.web.core.objects.AbstractDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert from Database Objects to Business Objects
 *
 * @param <D> database object (DO)
 * @param <B> business object (BO)
 *
 * @author Leo Ertruna
 * @since 17.05.2018 11:55
 */
public interface AbstractConverterDOtoBO<D extends AbstractDO, B extends AbstractBO> extends Converter<D, B> {
    /**
     * Convert single instance from DO to BO
     * @param databaseObject database object
     * @return business object
     */
    public abstract B toBO(D databaseObject);

    /**
     * Convert a collection of DO to BO
     * @param databaseObjectsList collection of database objects
     * @return list of business objects
     */
    default List<B> toBO(Collection<D> databaseObjectsList) {
        // If it is greater than threshold size - run it through a parallel stream
        if (databaseObjectsList.size() > this.getParallelismThreshold()) {
            return databaseObjectsList.parallelStream().map(this::toBO).collect(Collectors.toList());
        }

        // If not - use classic for loop (it will run faster than single threaded stream)
        else {
            ArrayList<B> businessObjects = new ArrayList<>(databaseObjectsList.size());
            for (D databaseObject : databaseObjectsList)
                businessObjects.add(this.toBO(databaseObject));
            return businessObjects;
        }
    }
}