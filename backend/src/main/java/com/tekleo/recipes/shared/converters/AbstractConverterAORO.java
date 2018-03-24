package com.tekleo.recipes.shared.converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter to switch between AO and RO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:26
 */
public abstract class AbstractConverterAORO<AO, RO> implements Serializable{
    /**
     * Convert from RO to AO
     * @param x RO
     * @return AO
     */
    public abstract AO toAO(RO x);

    /**
     * Convert from AO to RO
     * @param x AO
     * @return RO
     */
    public abstract RO toRO(AO x);

    /**
     * Convert a list of RO to AO
     * @param roList list of RO
     * @return list of AO
     */
    public List<AO> toAO(List<RO> roList) {
        List<AO> aoList = new ArrayList<>(roList.size());
        for (RO r : roList)
            aoList.add(toAO(r));
        return aoList;
    }

    /**
     * Convert a list of AO to RO
     * @param aoList list of AO
     * @return list of RO
     */
    public List<RO> toRO(List<AO> aoList) {
        List<RO> roList = new ArrayList<>(aoList.size());
        for (AO a : aoList)
            roList.add(toRO(a));
        return roList;
    }
}