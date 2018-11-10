package io.github.jpleorx.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Util class to ease time related operations
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:02
 */
public final class Time {
    /**
     * Private default constructor
     * Prevents instantiation of this class
     */
    private Time() {
        throw new IllegalAccessError();
    }

    /**
     * Current time
     */
    public final static class Current {
        /**
         * Private default constructor
         * Prevents instantiation of this class
         */
        private Current() {
            throw new IllegalAccessError();
        }

        /**
         * Get current time as {@link Timestamp} object
         * @return timestamp
         */
        public static Timestamp getAsTimestamp() {
            return new Timestamp(System.currentTimeMillis());
        }

        /**
         * Get current time as timestamp but in {@link Long} format
         * @return timestamp as long
         */
        public static long getAsLong() {
            return getAsTimestamp().getTime();
        }

        /**
         * Get current time as {@link Date} object
         * @return timestamp as date
         */
        public static Date getAsDate() {
            return new Date(getAsLong());
        }
    }
}