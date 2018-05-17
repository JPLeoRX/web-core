package com.tekleo.skeleton.biz.example;

import com.tekleo.skeleton.shared.core.objects.AbstractBO;
import com.tekleo.skeleton.shared.id.ExampleId;

import java.sql.Timestamp;

/**
 * Sample Business Object
 *
 * It is used as a middle layer between the API and the database
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:59
 */
public class ExampleBO implements AbstractBO<ExampleId> {
    private ExampleId exampleId;
    private String text;
    private Timestamp createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleBO() {

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