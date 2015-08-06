package ru.effector.responses;

import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.model.sale.IAPSale;
import ru.effector.model.sale.ProductSale;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductSalesResponse extends PageableResponse {

    public String currency;
    public Vertical vertical;
    public Market market;
    public List<ProductSale> salesList;
    public List<IAPSale> iapSalesList;

}
