package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Abby on 3/26/2018.
 * class that creates accounts for users
 * uses the location class
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
     * password for the account
     */
    private String password;

    /**
     * constructs an empty account with a fake name, a fake email, and a default location
     * default password is 0000
     */
    public Account() {
        name = "name";
        email = "user@email.com";
        loc = new Location("town","state");
        password = "0000";
    }

    /**
     * constructs an account with the given name, email, town, state, and password
     * @param name name of the owner of the account
     * @param email email of the owner of the account
     * @param town town of the location of the owner of the account
     * @param state state of the location of the owner of the account
     * @param Password password for the account
     */
    public Account(String name, String email, String town, String state, String Password) {
        this.name = name;
        this.email = email;
        loc = new Location(town,state);
        password = Password;
    }




    /**
     * returns the name of the owner of the account
     * @return name of the owner of the account
     */
    public String getName()
    {
        return name;
    }

    /**
     * returns the email of the owner of the account
     * @return the email of the owner of the account
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * return the location of the owner of the account
     * @return the location of the owner of the account
     */
    public Location getLocation() {
        return loc;
    }


    /**
     * returns the password for the account
     * @return the password for the account
     */
    public String getPassword() {return password;}

    /**
     * change the account name to the name given as a parameter
     * @param name new name for the account
     */
    public void changeName(String name){
        this.name = name;
    }

    /**
     * changes the location to have the town and state given
     * @param Town the new town of the location
     * @param State the new state of the location
     */
    public void changeLocation(String Town, String State){
        loc.setTown(Town);
        loc.setState(State);
    }

    /**
     * changes the email of the account to the email given
     * @param email the new email of the account
     */
    public void changeEmail(String email){
        this.email = email;
    }

    /**
     * changes the password of the account to the password given
     * @param password the new password of the account
     */
    public void changePassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        loc.setState(state);
    }

    public void setTown(String town) {
        loc.setTown(town);
    }

    @Override
    public String toString(){
        return getEmail();
    }
}