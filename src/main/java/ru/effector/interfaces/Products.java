package ru.effector.interfaces;

import ru.effector.condition.BaseCondition;
import ru.effector.condition.RankCondition;
import ru.effector.condition.ReviewCondition;
import ru.effector.model.Asset;
import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.responses.ProductDetailsResponse;
import ru.effector.responses.ProductFeaturesResponse;
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
    @Path("/ranks?")
    ProductRanksResponse ranks(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId,
            @QueryParam("__expand") RankCondition condition
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

    @GET
    @Path("/reviews")
    ProductRanksResponse reviews(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId,
            @QueryParam("__expand") ReviewCondition condition
    );

    @GET
    @Path("/features")
    ProductFeaturesResponse features(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("asset") Asset asset,
            @PathParam("product_id") Integer productId,
            @QueryParam("__expand") BaseCondition condition
    );
}
