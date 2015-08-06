package ru.effector.model;

import java.util.Date;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class Account {

    public Integer accountId;
    public Vertical vertical;
    public Date lastSalesDate;
    public AccountStatus accountStatus;
    public Date firstSalesDate;
    public String publisherName;
    public String accountName;
    public Market market;

}
