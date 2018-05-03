package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zeynepalptekin on 3/26/18.
 * class that creates and has methods for access listing objects
 * both for services and equipment listings
 * uses the account and location class
 */

public class Listing {

    /**
     * type: equipment or service
     */
    private String type;
    //Service or equipment
    private String email;
    /**
     * title of equipment or service
     */
    private String title;
    /**
     * user-entered description of equipment or service
     */
    private String description;
    /**
     * if the type is equipment, the type of equipment
     */
  //  public String equipmentType;
    /**
     * the cost, in dollars and cents, to use the service or equipment per hour
     */
    private double cost;
    /**
     * the date the listing was created
     */
   // public Date date;
    /**
     * image uri information
     */
   // public Uri image;
    private String town;

    private String state;

//    String Location;
//    Add Location class info after pulling from Abby
    // the location is part of the account added by Abby 3/27

    public Listing(){
        type = "ech";
        title = "idk";
        description = "none";
      //  equipmentType = "who knows";
        cost = 00.00;
        email = "someone@gmail.com";
        town = "town";
        state = "state";
       // date = getDate();
       // image = null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    /**
     * constructs a listing with the type "service"
     * @param email email of the owner of the listing
     * @param description user-entered description of the listing
     * @param cost the cost, in dollars in cents, per hour of the service
     */
    public Listing(String description, double cost, String type, String email, String town, String state) {
        this.type = type;
        this.cost = cost;
        this.title = type + " in " + town + ", " + state + " for $" + cost;
        this.description = description;
        this.email = email;
        this.town = town;
        this.state = state;
    }
/*
    /**
     * constructs a listing with the type "equipment"
     * @param owner the account of the owner of the listing
     * @param description user-entered description of the listing
     * @param equipmentType type of equipment of the listing
     * @param cost the cost, in dollars and cents, per hour of using the equipment
     */
  /*  public Listing(Account owner, String description, String equipmentType, double cost, Uri image){
        type = "equipment";
       // this.owner = owner;
        this.cost = cost;
        this.title = equipmentType + " in " + owner.getLocationString() + " for $" + cost;
        this.description = description;
       // this.equipmentType = equipmentType;
       // date = new Date();
       // this.image = image;
    }

    /**
     * sets the owner of the listing as an object of the Account class
     * @param owner
     */
    public void setOwner(String owner) {
        //TODO: add this. pull information from account itself
    }

    /**
     *  sets the description\
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets the equipment type
     * @param type
     */
    public void setEquipmentType(String type){
        this.type =type;
    }

    /**
     * sets the cost
     * @param cost
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    /**
     * gets the account of the owner of the listing
     * @return the account of the owner of the listing
     */
   // public Account getOwner() { //return owner;}

    /**
     * gets the cost of the listing per hour
     * @return the cost of the listing, in dollars and cents, per hour
     */
    public double getCost() {return cost;}

    /**
     * gets the type of the listing
     * @return the type of the listing
     */
    public String getType() { return type;}

    /**
     * gets the title of the listing
     * @return the title of the listing
     */
    public String getTitle() { return title;}

  /*  /**
     * gets the equipment type of the listing
     * @return equipment type of the listing
     */
  /*
    public String getEquipmentType() {return equipmentType;}
*/
    /**
     * returns the owner-entered description of the listing
     * @return the owner-entered description of the listing
     */
    public String getDescription() { return description;}

    /**
     * returns the date the listing was created
     * @return returns the date the listing was created
     */
    /*
    public Date getDate() { return date;}
    */

    @Override
    public String toString() {
        return title;
    }
}



