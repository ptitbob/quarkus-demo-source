package org.shipstone.city.controller;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import org.shipstone.city.domain.City;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/villes")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    @GET
    public Response getAll(
        @QueryParam("page") @DefaultValue("0") int page,
        @QueryParam("size") @DefaultValue("20") int pageSize
    ) {
        PanacheQuery<City> cityPanacheQuery = City.findAll(Sort.by("insee")).page(page, pageSize);
        if (cityPanacheQuery.count() == 0) {
            return Response.noContent().build();
        }
        Response.ResponseBuilder response;
        if (cityPanacheQuery.pageCount() == 1) {
            response = Response.ok(cityPanacheQuery.list());
        } else {
            response = Response.status(Response.Status.PARTIAL_CONTENT).entity(cityPanacheQuery.list());
        }
        response.header("x-total-page", cityPanacheQuery.pageCount());
        response.header("x-total-element", cityPanacheQuery.count());
        response.header("x-current-page", cityPanacheQuery.page().index);
        response.header("x-page-size", cityPanacheQuery.page().size);
        return response.build();
    }

    @GET
    @Path("{insee:\\d{5,6}}")
    public City getByInseeId(
        @PathParam("insee") String inseeId
    ) {
        return City.find("insee", inseeId).firstResult();
    }
}
