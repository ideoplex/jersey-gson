package com.ideoplex.tutorial;


public class User {
    public static final String EMPTY_STRING = "";

    protected String   email;
    protected String   surName;
    protected String   givenName;

    public User() {
        email      = EMPTY_STRING;
        surName    = EMPTY_STRING;
        givenName  = EMPTY_STRING;
    }

    public String getEmail()                        { return email; }
    public void setEmail(String em)                 { email = em; }

    public String getSurName()                      { return surName; }
    public void setSurName(String name)             { surName = name; }

    public String getGivenName()                    { return givenName; }
    public void setGivenName(String name)           { givenName = name; }
}
