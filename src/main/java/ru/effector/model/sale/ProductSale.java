package ru.effector.model.sale;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.effector.utils.deserializers.CustomDateDeserializer;

import java.util.Date;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductSale {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date date;

    public String country;
    public Sale units;
    public Revenue revenue;

}
