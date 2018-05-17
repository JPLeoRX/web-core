package com.tekleo.recipes.restapi.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.api.example.ExampleAPI;
import com.tekleo.recipes.converters.example.ExampleConverterAOtoRO;
import com.tekleo.recipes.converters.example.ExampleConverterFOtoAO;
import com.tekleo.recipes.converters.example.ExampleConverterROtoAO;
import com.tekleo.recipes.shared.core.converters.AbstractConverterROtoAO;
import com.tekleo.recipes.shared.core.exceptions.ApiException;
import com.tekleo.recipes.shared.core.exceptions.RestApiException;
import com.tekleo.recipes.shared.core.services.AbstractRestApi;
import com.tekleo.recipes.shared.rest.ReplyObject;
import com.tekleo.recipes.shared.id.ExampleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Sample REST api implementation
 *
 * This class is a Spring rest controller {@link RestController}
 * To manage the data we access the API layer here, which should be {@link Autowired} to work correctly
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:50
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestAPI implements AbstractRestApi<ExampleId, ExampleAO, ExampleRO, ExampleFO> {
    @Autowired
    ExampleAPI api;

    @Override
    public ExampleAPI getApi() {
        return api;
    }

    @Override
    public ExampleConverterAOtoRO getAOtoROConverter() {
        return new ExampleConverterAOtoRO();
    }

    @Override
    public ExampleConverterFOtoAO getFOtoAOConverter() {
        return new ExampleConverterFOtoAO();
    }

    @Override
    public AbstractConverterROtoAO<ExampleRO, ExampleAO> getROtoAOConverter() {
        return new ExampleConverterROtoAO();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ReplyObject getExample(@PathVariable(value = "id") String id) {
        try {
            return ReplyObject.success("example", get(new ExampleId(id)));
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.error("REST API Exception");
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ReplyObject getAllExamples() {
        try {
            return ReplyObject.success("examples", getAll());
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.error("REST API Exception");
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReplyObject addExample(@Valid @RequestBody ExampleFO form) {
        try {
            return ReplyObject.success("example", add(form));
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.error("REST API Exception");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ReplyObject deleteExample(@PathVariable(value = "id") String id) {
        try {
            return ReplyObject.success("example", remove(new ExampleId(id)));
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }
}