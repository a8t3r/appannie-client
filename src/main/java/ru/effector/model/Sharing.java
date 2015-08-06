package ru.effector.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class Sharing  {

    public Vertical vertical;
    public Market market;

    @JsonProperty("owner_account_id")
    public Integer ownerAccountId;

    @JsonProperty("owner_name")
    public Integer ownerName;

    public List<Product> products;

}
