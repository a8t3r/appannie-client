package ru.effector.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class FeignBuilder {

    public static Feign build(String token) {

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(ModuleBuilder.buildModule())
                .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return Feign.builder()
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .contract(new JAXRSContract())
                .logger(new Slf4jLogger())
                .requestInterceptor(requestFacade -> {
                    requestFacade.header("Authorization", "Bearer " + token);
                    requestFacade.header("Content-Type", "application/json");
                })
                .build();
    }
}
