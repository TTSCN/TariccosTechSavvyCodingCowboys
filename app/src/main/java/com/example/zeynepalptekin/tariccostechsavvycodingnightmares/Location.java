package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

/**
 * Created by Abby on 3/26/2018.
 * class that creates locations
 */

public class Location {
    /**
     * the US state as an abbreviation
     */
    private String state;

    /**
     * the town
     */
    private String town;

    /**
     * creates a blank location object
     */
    public Location(){
        state = "ST";
        town = "Town";
    }

    /**
     * creates a location given a state abbreviation and a town
     * @param town town of the location
     * @param state state abbreviation of the location
     */
    public Location(String town, String state) {
        this.town = town;
        this.state = state;
    }

    /**
     * returns the town of the location
     * @return the town of the location
     */
    public String getTown() { return town;}

    /**
     * returns the state abbreviation of the location
     * @return the state abbreviation of the location
     */
    public String getState() { return state;}

    /**
     * returns the location object as a string in the form of "Town, ST"
     * @return the location as a string in the form of "Town, St"
     */
    @Override
    public String toString() {
        String str = getTown() + ", " + getState();
        return str;
    }

    /**
     * changes the name of the town of the location object to the town given
     * @param town the new name of the town of the location
     */
    public void setTown(String town){
        this.town = town;
    }

    /**
     * changes the name of the state of the location object to the state given
     * @param state the new name of the state of the location
     */
    public void setState(String state){
        this.state = state;
    }
}
