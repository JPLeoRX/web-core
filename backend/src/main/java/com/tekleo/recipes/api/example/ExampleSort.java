package com.tekleo.recipes.api.example;

import com.tekleo.recipes.shared.AbstractSort;

/**
 * Sample sorting class
 *
 * @author Leo Ertuna
 * @since 25.03.2018 19:24
 */
public class ExampleSort extends AbstractSort<ExampleAO> {
    @Override
    protected int compareByName(ExampleAO o1, ExampleAO o2) {
        return 0;
    }

    @Override
    protected int compareByContent(ExampleAO o1, ExampleAO o2) {
        return 0;
    }

    @Override
    protected int compareByDateCreated(ExampleAO o1, ExampleAO o2) {
        long d1 = o1.getCreatedAt().getTime();
        long d2 = o2.getCreatedAt().getTime();
        return -Long.compare(d1, d2);
    }

    @Override
    protected int compareByDateUpdated(ExampleAO o1, ExampleAO o2) {
        return 0;
    }
}