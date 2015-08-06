package ru.effector.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class RatingEntry {

    public Float average;
    public Integer ratingCount;

    @JsonProperty("star_5_count")
    public Integer fiveStarCount;

    @JsonProperty("star_4_count")
    public Integer fourStarCount;

    @JsonProperty("star_3_count")
    public Integer threeStarCount;

    @JsonProperty("star_2_count")
    public Integer twoStarCount;

    @JsonProperty("star_1_count")
    public Integer oneStarCount;

}
