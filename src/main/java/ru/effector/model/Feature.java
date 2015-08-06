package ru.effector.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.effector.utils.StringListJsonDeserializer;

import java.util.Date;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class Feature {

    public Date date;
    public String country;
    public Device device;
    public Integer level;

    @JsonDeserialize(using = StringListJsonDeserializer.class)
    public List<String> section;
    public Integer position;

}
