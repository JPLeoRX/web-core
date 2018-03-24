package com.tekleo.recipes.restapi.example;

import java.io.Serializable;

/**
 * Sample Form Object
 *
 * It is used to transfer data from frontend to backend via REST api
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:50
 */
public class ExampleFO implements Serializable {
    private String text;

    public String getText() {
        return text;
    }
}