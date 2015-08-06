package ru.effector.interfaces;

import ru.effector.condition.SaleCondition;
import ru.effector.responses.AccountConnectionSalesResponse;
import ru.effector.responses.AccountProductResponse;
import ru.effector.responses.AccountResponse;
import ru.effector.responses.ProductSalesResponse;

import javax.ws.rs.*;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
@Path("/accounts")
public interface Accounts {

    @GET
    AccountResponse accounts(@QueryParam("page_index") @DefaultValue("0") int pageIndex);

    @GET
    @Path("/{account_id}/products")
    AccountProductResponse accountProducts(
            @PathParam("account_id") Integer accountId,
            @QueryParam("page_index") @DefaultValue("0") int pageIndex);

    @GET
    @Path("/{account_id}/sales")
    AccountConnectionSalesResponse accountSales(
            @PathParam("account_id") Integer accountId,
            @QueryParam("page_index") @DefaultValue("0") int pageIndex
    );

    @GET
    @Path("/{account_id}/products/{product_id}/sales")
    ProductSalesResponse sales(
            @PathParam("account_id") Integer accountId,
            @PathParam("product_id") Integer productId,
            @QueryParam("__expand") SaleCondition condition
    );
}
