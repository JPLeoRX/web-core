package com.tekleo.recipes.shared.converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        List<DO> doList = new ArrayList<>(boList.size());
        for (BO b : boList)
            doList.add(toDO(b));
        return doList;
    }

    /**
     * Convert a list of DO to BO
     * @param doList list of DO
     * @return list of BO
     */
    public List<BO> toBO(List<DO> doList) {
        List<BO> boList = new ArrayList<>(doList.size());
        for (DO d : doList)
            boList.add(toBO(d));
        return boList;
    }
}