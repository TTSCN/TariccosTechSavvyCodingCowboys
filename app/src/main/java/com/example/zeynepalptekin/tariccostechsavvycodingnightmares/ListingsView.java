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

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListingsView extends ListActivity {

    Account a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String[] account = bundle.getStringArray("account");
            a = new Account(account[0],account[1],account[2],account[3],account[4]);
        }

        Log.d("account","Account in ListingsView: " + a.getEmail());

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setClickable(true);

        //This hashmap is just a hardcoded in thing used to test the project. You can replace this with stuff from the
        //firebase
        HashMap<String, String> items = new HashMap<>();
        items.put("tomatoes", "i love");
        items.put("food", "gimme");
        items.put("i want", "a tamale");
        items.put("signature", "beverage");
        items.put("insert list of old pop songs", "insert list of corresponding artists");
        items.put("katy perry isnt even", "relevant anymore");


        //items and subtitles are coming from resources xml file called listings items. should be replaced with firebase
        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.listings_items,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.titles,R.id.descriptions});

        Log.d("Zeynep", "made it to iterator");
        //iterates through listitems to put in listview
       Iterator iterator = items.entrySet().iterator();
       while(iterator.hasNext()){
           //pairing "first line" string to titles and "second line" string to descriptions
           HashMap<String, String> resultsMap = new HashMap<>();
           //Says that we just want the key-value pair
           Map.Entry pair = (Map.Entry)iterator.next();
           resultsMap.put("First Line", pair.getKey().toString());
           resultsMap.put("Second Line", pair.getValue().toString());
           listItems.add(resultsMap);
       }
        Log.d("Zeynep","finished iterator");
       listView.setAdapter(adapter);

    //commented out to make hardcoding easier
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference serviceListingsRef = database.getReference("serviceListings");
//
//        serviceListingsRef.orderByChild("serviceListings").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                System.out.println(dataSnapshot.getKey());
//            }
//
//            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
//                System.out.println("The data at for this object has been changed.");
//            }
//            public void onChildRemoved(DataSnapshot snapshot) {
//                System.out.println("This information was removed for security reasons or for violating the Terms of Use.");
//            }
//            public void onCancelled(DatabaseError error) {
//                System.out.println("Unable to retrieve data.");
//            }
//
//            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
//
//            }
//        });


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(this, ListingTemplate.class);
    }

}
