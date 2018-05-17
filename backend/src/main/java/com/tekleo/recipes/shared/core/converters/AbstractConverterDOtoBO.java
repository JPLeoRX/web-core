package com.tekleo.recipes.shared.core.converters;

import com.tekleo.recipes.shared.core.objects.AbstractBO;
import com.tekleo.recipes.shared.core.objects.AbstractDO;

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
        return databaseObjectsList.parallelStream().map(this::toBO).collect(Collectors.toList());
    }
}