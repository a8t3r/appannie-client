package ru.effector.utils.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
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
    public List<List<String>> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        List<List<String>> result = new ArrayList<>();
        if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
            while (jp.getCurrentToken() != JsonToken.END_ARRAY) {
                String part = jp.nextTextValue();
                if (part != null) {
                    result.add(Arrays.asList(part.split(" > ")));
                }
            }
        } else {
            String[] parts = jp.getText().split(",");
            for (String part : parts) {
                result.add(Arrays.asList(part.split(" > ")));
            }
        }

        return result;
    }
}
