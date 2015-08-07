package ru.effector.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.effector.utils.deserializers.CategoryPathJsonDeserializer;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 07.08.2015
 */
public class CategoriesResponse extends BasicResponse {

    @JsonDeserialize(using = CategoryPathJsonDeserializer.class)
    List<List<String>> categories;

    @Deprecated
    public String appannieCategories;

}
