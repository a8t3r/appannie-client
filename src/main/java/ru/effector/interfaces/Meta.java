package ru.effector.interfaces;

import ru.effector.model.Market;
import ru.effector.model.Vertical;
import ru.effector.responses.CategoriesResponse;
import ru.effector.responses.CountriesResponse;
import ru.effector.responses.MarketsResponse;

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

}
