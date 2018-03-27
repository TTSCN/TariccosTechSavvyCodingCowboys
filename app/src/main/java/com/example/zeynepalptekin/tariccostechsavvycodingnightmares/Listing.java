package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
/**
 * Created by zeynepalptekin on 3/26/18.
 */

public class Listing {

    String type;    //Service or equipment
    String title;
    String description;
    String equipmentType;
    BufferedImage img = null;
try {
        img = ImageIO.read(new File("strawberry.jpg"));
    } catch (IOException e) {
    }

//    String Location;
//    Add Location class info after pulling from Abby

    public Listing(String type, String title, String description){
        type = "service";
        this.title = title;
        this.description = description;
    }

    public Listing(String type, String title, String description, String equipmentType){
        type = "equipment";
        this.title = title;
        this.description = description;
        this.equipmentType = equipmentType;
    }


}
