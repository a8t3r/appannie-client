package ru.effector.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.effector.model.AccountStatus;
import ru.effector.model.Market;

import java.io.IOException;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ModuleBuilder {

    public static Module buildModule() {
        SimpleModule module = new SimpleModule("CustomAppannieModule", new Version(1, 0, 0, null));

        module.addDeserializer(Market.class, new JsonDeserializer<Market>() {
            @Override
            public Market deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                String rawString = jp.getText().replace("-", "_");
                return Market.valueOf(rawString);
            }
        });

        module.addSerializer(Market.class, new JsonSerializer<Market>() {
            @Override
            public void serialize(Market value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                String rawString = value.name().replace("_", "-");
                jgen.writeString(rawString);
            }
        });

        module.addDeserializer(AccountStatus.class, new JsonDeserializer<AccountStatus>() {
            @Override
            public AccountStatus deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                String rawString = jp.getText().replace(" ", "_");
                return AccountStatus.valueOf(rawString);
            }
        });

        return module;
    }
}
