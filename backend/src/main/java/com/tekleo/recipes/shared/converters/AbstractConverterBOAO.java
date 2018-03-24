package com.tekleo.recipes.shared.converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter to switch between BO and AO objects
 *
 * Converters on this stage can become quite complicated if they need to read additional data from the database
 * Inject all the required additional services to BO-AO converter
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:26
 */
public abstract class AbstractConverterBOAO<BO, AO> implements Serializable {
    /**
     * Convert from AO to BO
     * @param x AO
     * @return BO
     */
    public abstract BO toBO(AO x);

    /**
     * Convert from BO to AO
     * @param x BO
     * @return AO
     */
    public abstract AO toAO(BO x);

    /**
     * Convert a list of AO to BO
     * @param aoList list of AO
     * @return list of BO
     */
    public List<BO> toBO(List<AO> aoList) {
        List<BO> boList = new ArrayList<>(aoList.size());
        for (AO a : aoList)
            boList.add(toBO(a));
        return boList;
    }

    /**
     * Convert a list of BO to AO
     * @param boList list of BO
     * @return list of AO
     */
    public List<AO> toAO(List<BO> boList) {
        List<AO> aoList = new ArrayList<>(boList.size());
        for (BO b : boList)
            aoList.add(toAO(b));
        return aoList;
    }
}