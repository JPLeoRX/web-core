package com.tekleo.recipes.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverterAORO<AO, RO> {
    public abstract AO toAO(RO x);

    public abstract RO toRO(AO x);

    public List<AO> toAO(List<RO> roList) {
        List<AO> aoList = new ArrayList<>(roList.size());
        for (RO r : roList)
            aoList.add(toAO(r));
        return aoList;
    }

    public List<RO> toRO(List<AO> aoList) {
        List<RO> roList = new ArrayList<>(aoList.size());
        for (AO a : aoList)
            roList.add(toRO(a));
        return roList;
    }
}