package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DatabaseInitialization {

    Account god = new Account();
    Listing what = new Listing(god, "ech", 19.87);

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("https://toolspitch.firebaseio.com/");

    DatabaseReference serviceListingsRef = ref.child("service listings");

    Map<Listing, Account> serviceListings = new HashMap<>();
    serviceListings.put(what, god);


}
