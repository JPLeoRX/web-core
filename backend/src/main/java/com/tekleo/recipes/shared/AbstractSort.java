package com.tekleo.recipes.shared;

import java.util.Comparator;
import java.util.List;

/**
 * Helper base class for sorting
 *
 * For any complex object you will have to write your own inner classes and list method
 * But for the most use cases this will be more than enough
 *
 * @author Leo Ertuna
 * @since 25.03.2018 19:22
 */
public abstract class AbstractSort<E> {
    // Abstract comparisons.
    //------------------------------------------------------------------------------------------------------------------
    protected abstract int compareByName(E o1, E o2);

    protected abstract int compareByContent(E o1, E o2);

    protected abstract int compareByDateCreated(E o1, E o2);

    protected abstract int compareByDateUpdated(E o1, E o2);
    //------------------------------------------------------------------------------------------------------------------



    // List sorting methods
    //------------------------------------------------------------------------------------------------------------------
    public List<E> sortByName(List<E> originalList) {
        originalList.sort(new NameComparator());
        return originalList;
    }

    public List<E> sortByContent(List<E> originalList) {
        originalList.sort(new ContentComparator());
        return originalList;
    }

    public List<E> sortByDateCreated(List<E> originalList) {
        originalList.sort(new DateCreatedComparator());
        return originalList;
    }

    public List<E> sortByDateUpdated(List<E> originalList) {
        originalList.sort(new DateUpdatedComparator());
        return originalList;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Comparator objects as inner classes
    //------------------------------------------------------------------------------------------------------------------
    private class NameComparator implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return compareByName(o1, o2);
        }
    }

    private class ContentComparator implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return compareByContent(o1, o2);
        }
    }

    private class DateCreatedComparator implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return compareByDateCreated(o1, o2);
        }
    }

    private class DateUpdatedComparator implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return compareByDateUpdated(o1, o2);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}