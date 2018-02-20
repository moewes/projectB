package net.moewes.projectB.erpmock.jaxrs;


import net.moewes.projectB.pocerp.rest.api.HelloResource;
import net.moewes.projectB.pocerp.rest.api.HelloService;

import javax.ws.rs.core.Response;


public class HelloServiceImpl implements HelloService {

    public Response getHelloMessage() {

        HelloResource result = new HelloResource();
        result.setSystem("pocerp");
        result.setMessage("Hallo aus dem ERP-System");

        return Response.ok(result).build();

    }


}
