package ru.effector.responses;

import ru.effector.model.Product;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class AccountProductResponse extends PageableResponse {

    public List<Product> products;

}
