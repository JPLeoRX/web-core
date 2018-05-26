package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.shared.core.objects.AbstractAO;
import com.tekleo.skeleton.shared.core.objects.properties.HasDateCreated;
import com.tekleo.skeleton.shared.id.ExampleId;

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
public class ExampleAO implements AbstractAO<ExampleId>, HasDateCreated<Timestamp> {
    private ExampleId exampleId;
    private String text;
    private Timestamp createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleAO() {

    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public ExampleId getId() {
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
    public void setId(ExampleId exampleId) {
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