package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Abby on 3/26/2018.
 * class that creates accounts for users
 * uses the location class
 */

public class Account implements Parcelable{
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
   /* private Location loc; */

   private String town;

   private String state;

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
        town = "town";
        state = "state";
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
        this.town = town;
        this.state = state;
        password = Password;
    }

    /**
     * creates account object from parcel
     * @param p parcel object
     */
    public Account(Parcel p) {
        String[] data = new String[5];

        p.readStringArray(data);

        this.name = data[0];
        this.email = data[1];
        this.town = data[2];
        this.state = data[3];
        this.password = data[4];


    }


    /**
     * writes account object into a parcel object
     * @param dest parcel the account information is being written into
     * @param flags
     */
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name,this.email, this.town,this.state,
                this.password});
    }

    public int describeContents() {
        return 0;
    }

    //error here after clicking create account
    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>() {
        //error here after clicking create account
        public Account createFromParcel(Parcel p) {
            return new Account(p);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };


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
    public String[] getLocation() {
        return new String[] {town,state} ;
    }

    public String getLocationString() {
       return town + ", " + state;
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
        this.town = Town;
        this.state = State;
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
        this.state = state;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString(){
        return getEmail();
    }
}