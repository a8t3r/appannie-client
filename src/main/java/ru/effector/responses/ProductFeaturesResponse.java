package ru.effector.responses;

import ru.effector.model.Feature;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductFeaturesResponse extends PageableResponse {

    public String productName;
    public List<Feature> features;

}
