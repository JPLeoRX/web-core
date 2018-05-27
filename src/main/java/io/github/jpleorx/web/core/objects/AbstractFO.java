package io.github.jpleorx.web.core.objects;


import io.github.jpleorx.web.core.objects.id.AbstractId;

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