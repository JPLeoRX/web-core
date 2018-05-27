package io.github.jpleorx.web.core.objects.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class contains a core functionality of an ID
 *
 * Extend any IDs from this class, for most use cases it doesn't need any changes
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:54
 */
public abstract class AbstractId implements Serializable, Comparable<AbstractId> {
    private String internalId;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Create an ID from a given internal id string
     * @param internalId
     */
    public AbstractId(String internalId) {
        if (internalId == null || internalId.isEmpty())
            throw new IllegalArgumentException();
        this.internalId = internalId;
    }

    /**
     * Create an ID with a newly generated internal id string
     */
    public AbstractId() {
        this(IdGenerator.generateUniqueRandomId());
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getInternalId() {
        return internalId;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Others
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(AbstractId o) {
        return this.getInternalId().compareTo(o.getInternalId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractId that = (AbstractId) o;
        return Objects.equals(internalId, that.internalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalId);
    }

    @Override
    public String toString() {
        return internalId;
    }
    //------------------------------------------------------------------------------------------------------------------
}