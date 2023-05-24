package com.mendix.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/greeting/{name}")
public class CategoryResource {
    @GET
    public String greeting(@PathParam("name") String name) {
        return "Hello" + name + "!";
    }
}
