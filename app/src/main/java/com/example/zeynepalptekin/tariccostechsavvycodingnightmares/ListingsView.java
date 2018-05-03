package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.app.IntentService;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class ListingsView extends ListActivity {

    Account a;
    HashMap<String, String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String[] account = bundle.getStringArray("account");
            a = new Account(account[0],account[1],account[2],account[3],account[4]);
        }

//        Log.d("account","Account in ListingsView: " + a.getEmail());

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setClickable(true);

        //This hashmap is just a hardcoded in thing used to test the project. You can replace this with stuff from the
        //firebase
        items = new HashMap<>();

        //items and subtitles are coming from resources xml file called listings items. should be replaced with firebase
        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.listings_items,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.titles, R.id.descriptions});

        Log.d("Zeynep", "made it to iterator");
        //iterates through listitems to put in listview
        Iterator iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            //pairing "first line" string to titles and "second line" string to descriptions
            HashMap<String, String> resultsMap = new HashMap<String, String>();
            //Says that we just want the key-value pair
            Map.Entry pair = (Map.Entry) iterator.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        Log.d("Zeynep", "finished iterator");
        listView.setAdapter(adapter);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference serviceListingsRef = database.getReference("serviceListings");

        // Read from the database
        serviceListingsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Listing listing;
               for(DataSnapshot newListing: dataSnapshot.getChildren()){
                    listing = newListing.getValue(Listing.class);
                    Log.d("listingsView", listing.getTitle() + " " + listing.getDescription() + " " + listing.getEmail() + " " + listing.getTown() + " " + listing.getState());
                   Log.d("listingsView", "putting title and description into listview");
                    items.put(listing.getTitle(), listing.getDescription());
                    Log.d("listingsView",listing.getTitle() + " " + listing.getDescription());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       /* serviceListingsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Listing serviceListing = dataSnapshot.getValue(Listing.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
               Listing changedServiceListing = dataSnapshot.getValue(Listing.class);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

  */
    }
}

