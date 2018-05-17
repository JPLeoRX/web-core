package com.tekleo.skeleton.shared.core.objects;

import com.tekleo.skeleton.shared.core.AbstractId;

/**
 * This is the parent class for all Business Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractBO<I extends AbstractId> extends Entity<I> {

}