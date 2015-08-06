package ru.effector.interfaces;

import ru.effector.model.Asset;
import ru.effector.model.Interval;
import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.responses.ProductDetailsResponse;
import ru.effector.responses.ProductRanksResponse;
import ru.effector.responses.ProductRatingsResponse;

import javax.ws.rs.*;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
@Path("/{vertical}/{market}/{asset}/{product_id}/")
public interface Products {

    @GET
    @Path("/details")
    ProductDetailsResponse details(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId
    );

    @GET
    @Path("/ranks")
    ProductRanksResponse ranks(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId
    );

    @GET
    @Path("/ranks")
    ProductRanksResponse ranks(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId,
            @QueryParam("start_date") String startDate,
            @QueryParam("end_date") String endDate,
            @QueryParam("interval") Interval interval,
            @QueryParam("contries") String countries
    );

    @GET
    @Path("/ratings")
    ProductRatingsResponse ratings(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId,
            @QueryParam("page_index") @DefaultValue("0") int pageIndex
    );
}
