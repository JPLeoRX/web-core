package com.tekleo.recipes.restapi.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.api.example.ExampleAPI;
import com.tekleo.recipes.shared.AbstractRestAPI;
import com.tekleo.recipes.shared.exceptions.APIException;
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
public class ExampleRestAPI implements AbstractRestAPI {
    @Autowired
    ExampleAPI api;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ReplyObject getExample(@PathVariable(value = "id") String id) {
        try {
            ExampleRO exampleRO = new  ExampleRO(api.getExample(new ExampleId(id)));
            return ReplyObject.success("example", exampleRO);
        } catch (APIException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ReplyObject getAllExamples() {
        try {
            List<ExampleRO> exampleROList = new ExampleConverterAORO().toRO(api.getAllExamples());
            return ReplyObject.success("examples", exampleROList);
        } catch (APIException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReplyObject addExample(@Valid @RequestBody ExampleFO form) {
        try {
            ExampleRO exampleRO = new ExampleRO(api.addExample(form.getText()));
            return ReplyObject.success("example", exampleRO);
        } catch (APIException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ReplyObject updateExample(@Valid @RequestBody ExampleRO updatedEntity) {
        try {
            ExampleRO exampleRO = new ExampleRO(api.updateExample(new ExampleAO(updatedEntity)));
            return ReplyObject.success("example", exampleRO);
        } catch (APIException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ReplyObject deleteExample(@PathVariable(value = "id") String id) {
        try {
            ExampleRO exampleRO = new ExampleRO(api.deleteExample(new ExampleId(id)));
            return ReplyObject.success("example", exampleRO);
        } catch (APIException e) {
            e.printStackTrace();
            return ReplyObject.error("API Exception");
        }
    }
}