package ru.effector.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.RequestTemplate;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;

import java.util.Collection;
import java.util.Map;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class FeignBuilder {

    public static final String EXPAND = "__expand";

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
                    expandQueryParameters(requestFacade);

                    requestFacade.header("Authorization", "Bearer " + token);
                    requestFacade.header("Content-Type", "application/json");
                })
                .build();
    }

    /**
     * feign doesn't support bean param expanding
     */
    private static void expandQueryParameters(RequestTemplate requestFacade) {
        Map<String, Collection<String>> queries = requestFacade.queries();
        Collection<String> internalView = queries.get(EXPAND);
        if (internalView != null) {
            PropertyNamingStrategy.PropertyNamingStrategyBase strategy = (PropertyNamingStrategy.PropertyNamingStrategyBase)
                    PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES;

            String value = internalView.iterator().next();
            if (value.length() > 0) {
                Map<String, String> map = QueryParamsJsonSerializer.of(value);
                requestFacade.query(EXPAND);
                for (String paramName : map.keySet()) {
                    requestFacade.query(strategy.translate(paramName), map.get(paramName));
                }
            }
        }
    }
}
