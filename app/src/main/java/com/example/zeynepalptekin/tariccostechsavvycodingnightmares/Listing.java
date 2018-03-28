package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import java.util.Date;

/**
 * Created by zeynepalptekin on 3/26/18.
 */

public class Listing {
    /**
     * type: equipment or service
     */
    private String type;
    //Service or equipment
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
    private String equipmentType;
    /**
     * the account of the owner of the listing
     */
    private Account owner;
    /**
     * the cost, in dollars and cents, to use the service or equipment per hour
     */
    private Double cost;
    /**
     * the date the listing was created
     */
    private Date date;

//    String Location;
//    Add Location class info after pulling from Abby
    // the location is part of the account added by Abby 3/27

    /**
     * constructs a listing with the type "service"
     * @param owner account of the owner of the listing
     * @param description user-entered description of the listing
     * @param cost the cost, in dollars in cents, per hour of the service
     */
    public Listing(Account owner, String description, double cost) {
        type = "service";
        this.owner = owner;
        this.cost = cost;
        title = type + " in " + owner.getLocation() + " for $" + cost;
        this.description = description;
        equipmentType = null;
        date = new Date();
    }

    /**
     * constructs a listing with the type "equipment"
     * @param owner the account of the owner of the listing
     * @param description user-entered description of the listing
     * @param equipmentType type of equipment of the listing
     * @param cost the cost, in dollars and cents, per hour of using the equipment
     */
    public Listing(Account owner, String description, String equipmentType, double cost){
        type = "equipment";
        this.owner = owner;
        this.cost = cost;
        this.title = equipmentType + " in " + owner.getLocation() + " for $" + cost;
        this.description = description;
        this.equipmentType = equipmentType;
        date = new Date();
    }

    /**
     * gets the account of the owner of the listing
     * @return the account of the owner of the listing
     */
    public Account getOwner() { return owner;}

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

    /**
     * gets the equipment type of the listing
     * @return equipment type of the listing
     */
    public String getEquipmentType() {return equipmentType;}

    /**
     * returns the owner-entered description of the listing
     * @return the owner-entered description of the listing
     */
    public String getDescription() { return description;}

    /**
     * returns the date the listing was created
     * @return returns the date the listing was created
     */
    public Date getDate() { return date;}
}
