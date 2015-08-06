package ru.effector.responses;

import ru.effector.model.Review;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductReviewsResponse extends PageableResponse {

    public String productName;
    public List<Review> reviews;

}
