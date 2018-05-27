package io.github.jpleorx.web.core.rest;

import java.io.Serializable;
import java.util.HashMap;

/**
 * JSON REST response wrapper
 *
 * This object will indicate whether response was successful or not as well as pass the results of the response
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:38
 */
public class ReplyObject implements Serializable {
    private boolean success;
    private String errorMessage;
    private HashMap<String, Object> results = new HashMap<>();

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    private ReplyObject(String name, Object result) {
        this.success = true;
        this.results.put(name, result);
        this.errorMessage = "";
    }

    private ReplyObject(String errorMessage) {
        this.success = false;
        this.results = new HashMap<>();
        this.errorMessage = errorMessage;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HashMap<String, Object> getResults() {
        return results;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Factory methods
    //------------------------------------------------------------------------------------------------------------------
    public static ReplyObject success(String name, Object result) {
        return new ReplyObject(name, result);
    }

    public static ReplyObject error(String errorMessage){
        return new ReplyObject(errorMessage);
    }
    //------------------------------------------------------------------------------------------------------------------
}