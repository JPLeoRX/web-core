package com.tekleo.recipes.shared.converters;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter to switch between DO and BO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:26
 */
public abstract class AbstractConverterDOBO<DO, BO> implements Serializable {
    /**
     * Convert from BO to DO
     * @param x BO
     * @return DO
     */
    public abstract DO toDO(BO x);

    /**
     * Convert from DO to BO
     * @param x DO
     * @return BO
     */
    public abstract BO toBO(DO x);

    /**
     * Convert a list of BO to DO
     * @param boList list of BO
     * @return list of DO
     */
    public List<DO> toDO(List<BO> boList) {
        return boList.parallelStream().map(this::toDO).collect(Collectors.toList());
    }

    /**
     * Convert a list of DO to BO
     * @param doList list of DO
     * @return list of BO
     */
    public List<BO> toBO(List<DO> doList) {
        return doList.parallelStream().map(this::toBO).collect(Collectors.toList());
    }
}