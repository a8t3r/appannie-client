package ru.effector.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class CategoryPathJsonDeserializer extends JsonDeserializer<List<List<String>>> {
    @Override
    public List<List<String>> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String[] parts = jp.getText().split(",");
        List<List<String>> result = new ArrayList<>();
        for (String part : parts) {
            result.add(Arrays.asList(part.split(" > ")));
        }

        return result;
    }
}
