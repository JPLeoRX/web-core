package com.tekleo.recipes.restapi.example;

import com.tekleo.recipes.api.example.ExampleAO;

import java.io.Serializable;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 15:53
 */
public class ExampleRO implements Serializable {
    private String exampleId;
    private String text;
    private long createdAt;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleRO() {

    }

    public ExampleRO(String exampleId, String text, long createdAt) {
        this.exampleId = exampleId;
        this.text = text;
        this.createdAt = createdAt;
    }

    public ExampleRO(ExampleRO exampleDO) {
        this(exampleDO.getExampleId(), exampleDO.getText(), exampleDO.getCreatedAt());
    }

    public ExampleRO(ExampleAO exampleAO) {
        this(new ExampleConverterAORO().toRO(exampleAO));
    }
    //------------------------------------------------------------------------------------------------------------------


    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getExampleId() {
        return exampleId;
    }

    public String getText() {
        return text;
    }

    public long getCreatedAt() {
        return createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Setters
    //------------------------------------------------------------------------------------------------------------------
    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------
}