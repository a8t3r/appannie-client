package ru.effector.responses;

import ru.effector.model.Rating;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductRatingsResponse extends BasicResponse {

    public String productName;
    public int pageIndex;
    public int prevPage;
    public int nextPage;
    public int pageNum;
    public List<Rating> ratings;

}
