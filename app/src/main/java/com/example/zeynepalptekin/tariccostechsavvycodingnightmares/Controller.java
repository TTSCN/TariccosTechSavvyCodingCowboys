package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.app.Application;

import java.util.HashMap;

public class Controller extends Application
{
    private HashMap<String, String> myData = new HashMap<>();

    public HashMap<String, String> getListingMap() {

        return myData;
    }
}