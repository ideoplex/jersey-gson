package com.ideoplex.tutorial;


import java.lang.reflect.Type;

import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSerializationContext;


public class UserMapMarshall implements JsonSerializer<UserMap> {
    private static Gson gson = new Gson();

    @Override
    public JsonElement serialize(UserMap map , Type typeOfSrc, JsonSerializationContext context) {
        JsonArray   array  = new JsonArray();
        for ( User user : map.values() ) {
            array.add( gson.toJsonTree(user) );
        }

        JsonObject  object = new JsonObject();
        object.add("data",array);
            
        return object;
    }

}
