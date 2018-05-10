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
import android.widget.LinearLayout;
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
import java.util.Arrays;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static android.content.ContentValues.TAG;

public class ListingsView extends ListActivity {
    Account a;
//    ArrayList<String>keys=new ArrayList<>();
    ArrayList <Listing> listings = new ArrayList<>();

    private ArrayList<Listing> arrayList = new ArrayList<>();

//    private ArrayAdapter<Listing> adapter;
    SimpleAdapter adapter;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        ListView listView = (ListView) findViewById(android.R.id.list);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String[] account = bundle.getStringArray("account");
            a = new Account(account[0], account[1], account[2], account[3], account[4]);
            Log.d("account", "Account in ListingsView " + a.getEmail());
        }

//        final Controller aController = (Controller) getApplicationContext();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference listingsRef = database.getReference("serviceListings");

        listingsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Listing listing = dataSnapshot.getValue(Listing.class);
                System.out.println(listing.getTitle() + " /n  " + listing.getDescription());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

/*        listingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot listings : dataSnapshot.getChildren()) {
                    String descript = listings.child("description").getValue(String.class);
                    String titles = listings.child("title").getValue(String.class);
                    addCard(descript, titles);
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

        // Read from the database
//        listingsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                final Controller aController = (Controller) getApplicationContext();
//                Listing listing;
//                HashMap<String,String> ultimate = aController.getListingMap();
//
//                for(DataSnapshot newListing: dataSnapshot.getChildren()){
//                    listing = newListing.getValue(Listing.class);
//                    ultimate.put(listing.getTitle(),listing.getDescription());
////                    HashMap<String,String> value = (HashMap<String, String>)newListing.getValue();
////                    String title = newListing.getKey().toString();
////                    String desc = value.get(title).toString();
////
////                    System.out.println(title + " " + desc);
//
//                    Log.d("listingsView", listing.getTitle() + " " + listing.getDescription() + " " + listing.getEmail() + " " + listing.getTown() + " " + listing.getState());
//                    Log.d("listingsView", "putting title and description into listview");
//                    Log.d("listingsView",listing.getTitle() + " " + listing.getDescription());
//                }
//                for(String key: ultimate.keySet()){
//                    keys.add(key.toString());
//                }
//            }

//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        Controller aController = (Controller) getApplicationContext();
//        ListView listView = (ListView) findViewById(android.R.id.list);
//        ArrayList<String> listings = new ArrayList<>();
//        listings.addAll(aController.getListingMap().values());
//        Log.d("help",keys.toString());
//        listAdapter = new ArrayAdapter<String>(this,R.layout.listings_items, keys);

//        ArrayList<HashMap<String, String>> listItems = new ArrayList<>();
//        adapter = new SimpleAdapter(this, listItems, R.layout.listings_items,
//                new String[]{"First Line", "Second Line"},
//                new int[]{R.id.titles, R.id.descriptions});
//

//        Log.d("Zeynep", "made it to iterator");
//        //iterates through listitems to put in listview
//        Iterator iterator = aController.getListingMap().entrySet().iterator();
//        while (iterator.hasNext()) {
//            //pairing "first line" string to titles and "second line" string to descriptions
//            HashMap<String, String> resultsMap = new HashMap<>();
//            //Says that we just want the key-value pair
//            Map.Entry pair = (Map.Entry) iterator.next();
//            resultsMap.put("First Line", pair.getKey().toString());
//            resultsMap.put("Second Line", pair.getValue().toString());
//            listItems.add(resultsMap);
//        }

//        Log.d("Zeynep", "finished iterator");

//        listingsRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        listView.setAdapter(listAdapter);
//
//    }
    }
 /*       private void addCard (String desc, String titles) {
           // LinearLayout.generateViewId()


    }
    */
}

