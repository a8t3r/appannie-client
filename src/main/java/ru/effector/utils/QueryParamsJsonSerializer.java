package ru.effector.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import feign.Param;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class QueryParamsJsonSerializer extends JsonSerializer<Object> implements Param.Expander {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        StringBuilder builder = getStringBuilder(value);
        gen.writeString(builder.toString());
    }

    public static StringBuilder getStringBuilder(Object value) {
        Map<String, Object> map = getValuesMap(value);
        StringBuilder builder = new StringBuilder();
        for (String fieldName : map.keySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }

            builder.append(fieldName).append("=").append(String.valueOf(map.get(fieldName)));
        }

        return builder;
    }

    public static Map<String, Object> getValuesMap(Object value) {
        Field[] declaredFields = value.getClass().getDeclaredFields();
        Map<String, Object> values = new HashMap<>();
        for (Field field : declaredFields) {
            if ((field.getModifiers() | Modifier.PUBLIC) > 0) {
                try {
                    Object fieldValue = field.get(value);
                    if (fieldValue != null) {
                        values.put(field.getName(), fieldValue);
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        return values;
    }

    public static Map<String, ?> of(String serialized) {
        Map<String, Object> result = new HashMap<>();
        String[] parts = serialized.split("&");
        for (String part : parts) {
            String[] queryPair = part.split("=");
            result.put(queryPair[0], queryPair[1]);
        }

        return result;
    }

    @Override
    public String expand(Object value) {
        return getStringBuilder(value).toString();
    }
}
