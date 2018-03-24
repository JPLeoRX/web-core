package com.tekleo.recipes.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverterDOBO<DO, BO> {
    public abstract DO toDO(BO x);

    public abstract BO toBO(DO x);

    public List<DO> toDO(List<BO> boList) {
        List<DO> doList = new ArrayList<>(boList.size());
        for (BO b : boList)
            doList.add(toDO(b));
        return doList;
    }

    public List<BO> toBO(List<DO> doList) {
        List<BO> boList = new ArrayList<>(doList.size());
        for (DO d : doList)
            boList.add(toBO(d));
        return boList;
    }
}