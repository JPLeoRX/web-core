package com.tekleo.recipes.api.example;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.restapi.example.ExampleConverterAORO;
import com.tekleo.recipes.restapi.example.ExampleRO;
import com.tekleo.recipes.shared.id.ExampleId;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Sample API Object
 *
 * It will be used during all interactions with API
 * Can be a pretty complex object with many nested classes
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:32
 */
public class ExampleAO implements Serializable{
    private ExampleId exampleId;
    private String text;
    private Timestamp createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleAO() {

    }

    public ExampleAO(ExampleId exampleId, String text, Timestamp createdAt) {
        this.exampleId = exampleId;
        this.text = text;
        this.createdAt = createdAt;
    }

    public ExampleAO(ExampleAO exampleAO) {
        this(exampleAO.getExampleId(), exampleAO.getText(), exampleAO.getCreatedAt());
    }

    public ExampleAO(ExampleBO exampleBO) {
        this(new ExampleConverterBOAO().toAO(exampleBO));
    }

    public ExampleAO(ExampleRO exampleRO) {
        this(new ExampleConverterAORO().toAO(exampleRO));
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public ExampleId getExampleId() {
        return exampleId;
    }

    public String getText() {
        return text;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Setters
    //------------------------------------------------------------------------------------------------------------------
    public void setExampleId(ExampleId exampleId) {
        this.exampleId = exampleId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------
}