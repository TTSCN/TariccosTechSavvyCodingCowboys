package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

/**
 * Created by Abby on 3/26/2018.
 */

public class Account {
    /**
     * name of the owner of the account
     */
    private String name;

    /**
     * email of the owner of the account
     */
    private String email;

    /**
     * location of the owner of the account
     */
    private Location loc;

    /**
     * constructs an empty account with a fake name and a fake email
     */
    public Account() {
        name = "name";
        email = "user@email.com";
    }

    /**
     * constructs an account with the given name, email, town, and state
     * @param name name of the owner of the account
     * @param email email of the owner of the account
     * @param town town of the location of the owner of the account
     * @param state state of the location of the owner of the account
     */
    public Account(String name, String email, String town, String state) {
        this.name = name;
        this.email = email;
        loc = new Location(town, state);
    }

    /**
     * returns the name of the owner of the account
     * @return name of the owner of the account
     */
    public String getName() {
        return name;
    }

    /**
     * returns the email of the owner of the account
     * @return the email of the owner of the account
     */
    public String getEmail() {
        return email;
    }

    /**
     * return the location of the owner of the account
     * @return the location of the owner of the account
     */
    public Location getLocation() { return loc;}
}
