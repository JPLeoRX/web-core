package com.tekleo.recipes.biz.example.persistence;

import com.tekleo.recipes.shared.core.objects.AbstractDO;
import com.tekleo.recipes.shared.id.ExampleId;

import javax.persistence.*;

/**
 * Sample Database Object
 *
 * It is used to interact with the database
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:59
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "example")
public class ExampleDO implements AbstractDO<ExampleId> {
    // Due to postgreSQL limitations we have to specify lowercase column names of camel case data fields
    @Id @Column(name = "exampleid") private String exampleId;
    @Column private String text;
    @Column(name = "createdat") private long createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleDO() {

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