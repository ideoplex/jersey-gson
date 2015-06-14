package com.ideoplex.tutorial;


public class User {
    public static final String EMPTY_STRING = "";

    protected String   email;
    protected String   surname;
    protected String   givenName;

    public User() {
        email      = EMPTY_STRING;
        surname    = EMPTY_STRING;
        givenName  = EMPTY_STRING;
    }

    public String getEmail()                        { return email; }
    public void setEmail(String em)                 { email = em; }

    public String getSurname()                      { return surname; }
    public void setSurname(String name)             { surname = name; }

    public String getGivenName()                    { return givenName; }
    public void setGivenName(String name)           { givenName = name; }
}
