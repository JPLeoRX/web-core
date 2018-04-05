package com.tekleo.recipes.shared.converters;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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
        return roList.parallelStream().map(this::toAO).collect(Collectors.toList());
    }

    /**
     * Convert a list of AO to RO
     * @param aoList list of AO
     * @return list of RO
     */
    public List<RO> toRO(List<AO> aoList) {
        return aoList.parallelStream().map(this::toRO).collect(Collectors.toList());
    }
}