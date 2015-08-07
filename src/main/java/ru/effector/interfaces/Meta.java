package ru.effector.interfaces;

import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.responses.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Alexandr Kolosov
 * @since 07.08.2015
 */
@Path("/meta")
public interface Meta {

    @GET
    @Path("/countries")
    CountriesResponse countries();

    @GET
    @Path("/{vertical}/{market}/categories")
    CategoriesResponse categories(@PathParam("vertical") Vertical vertical, @PathParam("market") Market market);

    @GET
    @Path("/markets")
    MarketsResponse markets();

    @GET
    @Path("/currencies")
    CurrenciesResponse currencies();

    @GET
    @Path("/{vertical}/{market}/devices")
    DevicesResponse devices(@PathParam("vertical") Vertical vertical, @PathParam("market") Market market);

    @GET
    @Path("/{vertical}/{market}/feeds")
    FeedResponse feeds(@PathParam("vertical") Vertical vertical, @PathParam("market") Market market);

    @GET
    @Path("/{vertical}/{market}/package-codes2ids?package_codes={package_codes}")
    TranslateResponse translate(
            @PathParam("vertical") Vertical vertical,
            @PathParam("market") Market market,
            @PathParam("package_codes") String packageCodes);

}
