package com.ideoplex.tutorial;


import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ClientTest {

    public static final String className = ClientTest.class.getName();

    @Parameters({"baseurl"})
    @Test(groups="client")
    public void userCreate( String baseurl )
    {
        final User      sample;
        final String    email;
        final String    url;

        Client          client;
        WebResource     resource;
        ClientResponse  response;

        {
            email    = "test@" + className;
            sample   = new User();
            sample.setEmail(email);
            sample.setGivenName("John Q.");
            sample.setSurname("Public");

            url      = baseurl + "webapi/myresource/user";

            ClientConfig config = new DefaultClientConfig();
            config.getClasses().add(GsonReader.class);
            config.getClasses().add(GsonWriter.class);

            client   = Client.create(config);
        }

        {
            System.out.println("Verify that " + email + " is not available yet");
            resource  = client.resource( url + "/get/" + email );
            response  = resource.accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
            assert( response.getStatus() == 404 );
        }

        {
            System.out.println("Verify that user/post on " + email + " succeeds");
            resource  = client.resource( url + "/post" );
            response  = resource.accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class,sample);
            assert( response.getStatus() == 200 );
            User  rVal  = response.getEntity(User.class);
            assert( email.equals(rVal.getEmail()) );
        }

        {
            System.out.println("Verify that " + email + " is in the userMap");
            resource  = client.resource( url + "/map" );
            response  = resource.accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
            assert( response.getStatus() == 200 );
            UserMap  rVal  = response.getEntity(UserMap.class);
            assert( rVal != null );
            User     look   = rVal.get(email);
            assert( look != null );
        }

        {
            System.out.println("Verify that delete on " + email + " succeeds");
            resource  = client.resource( url + "/delete/" + email );
            response  = resource.accept(MediaType.APPLICATION_JSON)
                .delete(ClientResponse.class);
            assert( response.getStatus() == 200 );
            User  rVal  = response.getEntity(User.class);
            assert( email.equals(rVal.getEmail()) );
        }
    }
}
