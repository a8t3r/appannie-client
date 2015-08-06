package ru.effector.responses;

import ru.effector.model.Rating;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductRatingsResponse extends PageableResponse {

    public String productName;
    public List<Rating> ratings;

}
