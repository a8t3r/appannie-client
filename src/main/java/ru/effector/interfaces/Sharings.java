package ru.effector.interfaces;

import ru.effector.responses.AccountSharingProductResponse;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
@Path("/sharing")
public interface Sharings {

    @GET
    @Path("/products")
    AccountSharingProductResponse getSharingProducts(@QueryParam("page_index") @DefaultValue("0") int pageIndex);

}
