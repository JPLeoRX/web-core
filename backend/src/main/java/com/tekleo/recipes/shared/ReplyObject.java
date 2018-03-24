package com.tekleo.recipes.shared;

import java.io.Serializable;
import java.util.HashMap;

public class ReplyObject implements Serializable {
    private boolean success;
    private String errorMessage;
    private HashMap<String, Object> results = new HashMap<>();

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

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HashMap<String, Object> getResults() {
        return results;
    }

    public static ReplyObject success(String name, Object result) {
        return new ReplyObject(name, result);
    }

    public static ReplyObject error(String errorMessage){
        return new ReplyObject(errorMessage);
    }
}
