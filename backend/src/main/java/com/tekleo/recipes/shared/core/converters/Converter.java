package com.tekleo.recipes.shared.core.converters;

import java.io.Serializable;

/**
 * Converter's jod is to seamlessly switch from one object to another
 *
 * This object stays at highest level of abstraction
 *
 * @param <From> object from
 * @param <To> object to
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:54
 */
public interface Converter<From, To> extends Serializable {

}