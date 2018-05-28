package io.github.jpleorx.web.core.searching;

import io.github.jpleorx.web.core.objects.properties.HasDateUpdated;

import java.util.Date;

/**
 * Generic search by date updated range
 * @param <E> generic type of object, must have a date updated
 *
 * @author Leo Ertuna
 * @since 28.05.2018 16:42
 */
public class SearchByDateUpdatedRange<E extends HasDateUpdated> implements Search<E>  {
    private Date start;
    private Date end;

    /**
     * Constructor
     * @param start min date
     * @param end max date
     */
    public SearchByDateUpdatedRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Search criteria
     * @param e analyzed object
     * @return true if the object's date created falls into the given range, false otherwise
     */
    @Override
    public boolean criteria(E e) {
        return start.getTime() < e.getUpdatedAt().getTime() && e.getUpdatedAt().getTime() < end.getTime();
    }
}