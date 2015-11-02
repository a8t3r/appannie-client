package ru.effector.model;

import java.util.Date;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class Product {

    public Integer productId;
    public String productName;
    public List<String> devices;
    public List<String> deviceCodes;
    public String icon;
    public Boolean status;
    public Date firstSalesDate;
    public Date lastSalesDate;
    public Market market;

}
