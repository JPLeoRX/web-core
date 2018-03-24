package com.tekleo.recipes.biz.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.api.example.ExampleConverterBOAO;
import com.tekleo.recipes.biz.example.persistence.ExampleDO;
import com.tekleo.recipes.shared.id.ExampleId;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Sample Business Object
 *
 * It is used as a middle layer between the API and the database
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:59
 */
public class ExampleBO implements Serializable {
    private ExampleId exampleId;
    private String text;
    private Timestamp createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleBO() {

    }

    public ExampleBO(ExampleId exampleId, String text, Timestamp createdAt) {
        this.exampleId = exampleId;
        this.text = text;
        this.createdAt = createdAt;
    }

    public ExampleBO(ExampleBO exampleBO) {
        this(exampleBO.getExampleId(), exampleBO.getText(), exampleBO.getCreatedAt());
    }

    public ExampleBO(ExampleDO exampleDO) {
        this(new ExampleConverterDOBO().toBO(exampleDO));
    }

    public ExampleBO(ExampleAO exampleAO) {
        this(new ExampleConverterBOAO().toBO(exampleAO));
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