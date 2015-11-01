package com.ideoplex.tutorial;


import java.lang.reflect.Type;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;


public class UserMapUnmarshall implements JsonDeserializer<UserMap> {
    private static Gson gson = new Gson();

    @Override
    public UserMap deserialize(JsonElement mapFormat, Type typeOfSrc, JsonDeserializationContext context) {
        Iterator<JsonElement>  iterate = mapFormat.getAsJsonObject()
            .get("data")
            .getAsJsonArray()
            .iterator();

        UserMap  users = new UserMap();
        while( iterate.hasNext() ) {
            JsonObject user     = ((JsonElement) iterate.next()).getAsJsonObject();
            String     email    = user.get("email").getAsString();
            User       add      = new User();
            add.setEmail( email );
            add.setSurname( user.get("surname").getAsString() );
            add.setGivenName( user.get("givenName").getAsString() );
            users.put( email, add );
        }

        return users;
    }
}
