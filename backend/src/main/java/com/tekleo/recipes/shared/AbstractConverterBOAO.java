package com.tekleo.recipes.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverterBOAO<BO, AO> {
    public abstract BO toBO(AO x);

    public abstract AO toAO(BO x);

    public List<BO> toBO(List<AO> doList) {
        List<BO> boList = new ArrayList<>(doList.size());
        for (AO a : doList)
            boList.add(toBO(a));
        return boList;
    }

    public List<AO> toAO(List<BO> boList) {
        List<AO> aoList = new ArrayList<>(boList.size());
        for (BO b : boList)
            aoList.add(toAO(b));
        return aoList;
    }
}