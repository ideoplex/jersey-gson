package com.ideoplex.tutorial;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    /**
     * HashMap<String,User> containing all Users known to the system
     */
    protected static UserMap users = new UserMap();

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
     */
    @GET
    @Path("user/map")
    @Produces(MediaType.APPLICATION_JSON)
    public UserMap getUserMap(@QueryParam("sleep") int sleep)
    {
        if ( sleep > 0 ) {
            try {
                Thread.sleep(sleep);
            } catch ( InterruptedException e ) { ; }
        }
        return users;
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
        user.setSurname("Doe");
        user.setGivenName("John");
        return user;
    }

    @POST
    @Path("user/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public User postUser(User user) {
        String email = user.getEmail();
        if ( users.containsKey(email) ) {
            throw new WebApplicationException(Response
                                              .status(Response.Status.BAD_REQUEST)
                                              .type(MediaType.TEXT_PLAIN)
                                              .entity("User email \"" + email + "\" already exists")
                                              .build());
        }
        else {
            users.put(email, user);
            return user;
        }
    }

    @POST
    @Path("user/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public User editUser(User user) {
        String email = user.getEmail();
        if ( !users.containsKey(email) ) {
            throw new WebApplicationException(Response
                                              .status(Response.Status.BAD_REQUEST)
                                              .type(MediaType.TEXT_PLAIN)
                                              .entity("User email \"" + email + "\" does not exist")
                                              .build());
        }
        else {
            users.put(email, user);
            return user;
        }
    }
}
