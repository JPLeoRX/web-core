package com.tekleo.skeleton.restapi.example;

import com.tekleo.skeleton.shared.core.objects.AbstractFO;
import com.tekleo.skeleton.shared.id.ExampleId;

/**
 * Sample Form Object
 *
 * It is used to transfer data from frontend to backend via REST api
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:50
 */
public class ExampleFO implements AbstractFO<ExampleId> {
    private String text;

    public String getText() {
        return text;
    }
}