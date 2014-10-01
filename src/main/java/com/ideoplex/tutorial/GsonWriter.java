package com.ideoplex.tutorial;

/*
 * Courtesy of
 * http://www.larsmichael.net/?p=140
 */


import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.StringWriter;

import javax.inject.Singleton;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Provider
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class GsonWriter<T> implements MessageBodyWriter<T> {
    protected static Gson gson = new GsonBuilder()
        .registerTypeAdapter(UserMap.class,new UserMapMarshall())
        .create();
 
    @Override
    public void writeTo(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream)
            throws IOException, WebApplicationException {
        httpHeaders.get("Content-Type").add("charset=UTF-8");
        entityStream.write(gson.toJson(t).getBytes("UTF-8"));
    }
 
    @Override
    public long getSize(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
 
    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return true;
    }
}
