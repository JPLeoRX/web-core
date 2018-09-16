package io.github.jpleorx.web.core.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Converter's jod is to seamlessly switch from one object to another
 *
 * This object stays at highest level of abstraction
 *
 * Converters must take full responsibility for changing entity's type. They can become quite complicated too.
 * If you need any additional APIs/services to make the conversion - {@link Autowired} them here.
 * Converters can be considered services, so for better performance you can mark them as {@link Service} and make them {@link Autowired} in your services/APIs.
 *
 * @param <From> object from
 * @param <To> object to
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:54
 */
interface Converter<From, To> extends Serializable {
    /**
     * If our collection is larger than this value - parallelized conversions will take place
     * Override this method if you need to tweak performance
     * @return
     */
    default int getParallelismThreshold() {
        return 10000;
    }
}