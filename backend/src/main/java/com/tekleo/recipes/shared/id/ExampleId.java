package com.tekleo.recipes.shared.id;

import com.tekleo.recipes.shared.core.AbstractId;

import java.io.Serializable;
import java.util.Objects;

public class ExampleId extends AbstractId implements Serializable, Cloneable {
    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleId(String internalId) {
        super(internalId);
    }

    public ExampleId() {
        super();
    }
    //------------------------------------------------------------------------------------------------------------------



    // Others
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleId that = (ExampleId) o;
        return Objects.equals(this.getInternalId(), that.getInternalId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getInternalId());
    }

    @Override
    public ExampleId clone() {
        return new ExampleId(this.getInternalId());
    }
    //------------------------------------------------------------------------------------------------------------------
}