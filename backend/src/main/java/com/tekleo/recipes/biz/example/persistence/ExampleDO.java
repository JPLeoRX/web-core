package com.tekleo.recipes.biz.example.persistence;

import com.tekleo.recipes.biz.example.ExampleBO;
import com.tekleo.recipes.biz.example.ExampleConverterDOBO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 13:59
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "example")
public class ExampleDO implements Serializable {
    @Id @Column(name = "exampleid") private String exampleId;
    @Column private String text;
    @Column(name = "createdat") private long createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleDO() {

    }

    public ExampleDO(String exampleId, String text, long createdAt) {
        this.exampleId = exampleId;
        this.text = text;
        this.createdAt = createdAt;
    }

    public ExampleDO(ExampleDO exampleDO) {
        this(exampleDO.getExampleId(), exampleDO.getText(), exampleDO.getCreatedAt());
    }

    public ExampleDO(ExampleBO exampleBO) {
        this(new ExampleConverterDOBO().toDO(exampleBO));
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