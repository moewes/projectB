package net.moewes.projectB.pocerp.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public interface HelloService {

    @Path("message")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getHelloMessage();

}
