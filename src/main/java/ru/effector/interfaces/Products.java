package ru.effector.interfaces;

import ru.effector.model.Asset;
import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.responses.ProductDetailsResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public interface Products {

    @GET
    @Path("/{vertical}/{market}/{asset}/{product_id}/details")
    ProductDetailsResponse details(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId
    );

}
