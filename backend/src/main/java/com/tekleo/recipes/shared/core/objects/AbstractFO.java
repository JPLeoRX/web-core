package com.tekleo.recipes.shared.core.objects;


import com.tekleo.recipes.shared.core.AbstractId;

/**
 * This is the parent class for all Form Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractFO<I extends AbstractId> extends Entity<I> {

}