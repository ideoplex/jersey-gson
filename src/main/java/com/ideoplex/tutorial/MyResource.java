package com.ideoplex.tutorial;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    /**
     * Methods to get and post a json User object
     */
    @GET
    @Path("user/template")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserTemplate() {
        User  user  = new User();
        user.setEmail("noone@example.com");
        user.setSurName("Doe");
        user.setGivenName("John");
        return user;
    }

    @POST
    @Path("user/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public User postUser(User user) {
        return user;
    }
}
