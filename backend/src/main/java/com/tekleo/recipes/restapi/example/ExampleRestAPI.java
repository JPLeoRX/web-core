package com.tekleo.recipes.restapi.example;

import com.tekleo.recipes.api.example.ExampleAO;
import com.tekleo.recipes.api.example.ExampleAPI;
import com.tekleo.recipes.shared.APIException;
import com.tekleo.recipes.shared.ReplyObject;
import com.tekleo.recipes.shared.id.ExampleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/example")
public class ExampleRestAPI {
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
    public ReplyObject addExample(@Valid @RequestBody ExampleRO newEntity) {
        try {
            ExampleRO exampleRO = new ExampleRO(api.addExample(new ExampleAO(newEntity)));
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