package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * Created by zeynepalptekin on 3/26/18.
 */

public class Listing {
    /**
     * type: equipment or service
     */
    String type;    //Service or equipment
    /**
     * title of equipment or service
     */
    String title;
    /**
     * user-entered description of equipment or service
     */
    String description;
    /**
     * if the type is equipment, the type of equipment
     */
    String equipmentType;
    /**
     * the account of the owner of the listing
     */
    Account owner;

    /**
     * the image associated with the listing
     */
    BufferedImage img;
    
try {
        img = ImageIO.read(new File("strawberry.jpg"));
    } catch (IOException e) {
    }

//    String Location;
//    Add Location class info after pulling from Abby
    // the location is part of the account added by Abby 3/27

    /**
     * constructs a listing with the type "service"
     * @param owner account of the owner of the listing
     * @param type type of the listing; this constructor sets type to "service"
     * @param title title of the listing
     * @param description user-entered description of the listing
     */
    public Listing(Account owner, String type, String title, String description) {
        type = "service";
        this.title = title;
        this.description = description;
    }

    /**
     * constructs a listing with the type "equipment"
     * @param type type of the listing; this constructor sets type to "equipment"
     * @param title title of the listing
     * @param description user-entered description of the listing
     * @param equipmentType type of equipment of the listing
     */
    public Listing(String type, String title, String description, String equipmentType){
        type = "equipment";
        this.title = title;
        this.description = description;
        this.equipmentType = equipmentType;
    }


}
