package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

/**
 * used
 https://stackoverflow.com/questions/37291606/how-do-i-populate-a-listview-with-data-from-firebase?noredirect=1
 and https://developer.android.com/guide/topics/ui/layout/recyclerview
 and https://www.youtube.com/watch?v=uTVu3HsRIEE
 */

import android.app.Activity;
import android.app.IntentService;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

/**
 * class that prints listing information from firebase to show user
 * takes parameters from SearchForListings activity to filter out
 * listings the user does not want to view
 */
public class ListingsView extends Activity {
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * account of the user who is viewing listings
     */
    Account a;

    /**
     * the type of listing that the user is looking for
     * "s" for service, "e" for equipment, or "none" for no specific type
     */
    String type;

    /**
     * the maximum cost of the listings the user is looking for
     */
    double mCost;

    /**
     * the town where the user is looking for a listing
     */
    String tTown;

    /**
     * the state where the user is looking for a listing
     */
    String tState;

    ArrayList<String>keys=new ArrayList<>();
    ;
    private ArrayList<Listing> arrayList = new ArrayList<>();
    //    private ArrayAdapter<Listing> adapter;
    SimpleAdapter adapter;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        final List<String> itemsList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            final String[] account = bundle.getStringArray("account");
            a = new Account(account[0], account[1], account[2], account[3], account[4]);
            Log.d("account", "Account in ListingsView " + a.getEmail());

            String[] parameters = bundle.getStringArray("parameters");
            type = parameters[0];
            Log.d("parameters",parameters[1]);
            if(parameters[1].equals("none")) mCost = -1;
            else mCost = Double.parseDouble(parameters[1]);
            tTown = parameters[2];
            tState = parameters[3];
            final String tLoc = parameters[4];

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference listingsRef = database.getReference("serviceListings");
            final DatabaseReference listingsRef2 = database.getReference("equipmentListings");

            final RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            final MyAdapter mAdapter = new MyAdapter();
//            myRecyclerView.setAdapter(mAdapter);

            if(type.equals("none")||type.equals("s")||type.equals("S")) {
                listingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot listings : dataSnapshot.getChildren()) {
                            String emails = listings.child("email").getValue(String.class);
                            String descript = listings.child("description").getValue(String.class);
                            String titles = listings.child("title").getValue(String.class);
                            double cost = listings.child("cost").getValue(double.class);
                            String town = listings.child("town").getValue(String.class);
                            Log.d("town",tTown + " " + town);
                            String state = listings.child("state").getValue(String.class);
                            Log.d("state",tState + " " + state);
                            if(tState.toLowerCase().equals(state.toLowerCase())) {
                                Log.d("stateBoolean","true");
                            }

                            Log.d("help", descript);
                            if((mCost==-1 && tTown.isEmpty())){
                                itemsList.add(titles + " by " + emails + " in "+ town +","+ state+ " : " + descript);
                            }
                            if((mCost==-1 && tTown.isEmpty())&&(state.contains(tLoc)||
                                    town.contains(tLoc))){
                                itemsList.add(titles + " by " + emails + " in "+ town +","+state+ " : " + descript);
                            }
                            else if(tTown.isEmpty() && cost != -1){
                                if(cost<=mCost) itemsList.add(titles + " by " + emails + " : " + descript);
                            }
                            else if((mCost == -1 && !tTown.isEmpty())) {
                                Log.d("in conditional","in conditional");
                                if(tTown.toLowerCase().equals(town.toLowerCase())
                                        && tState.toLowerCase().equals(state.toLowerCase())){
                                    itemsList.add(titles + " by " + emails + " : " + descript);
                                }
                            }
                            else if((mCost!=-1 && !tTown.isEmpty())) {
                                Log.d("in conditional","in conditional");
                                if(cost<=mCost && tTown.toLowerCase().equals(town.toLowerCase())
                                && tState.toLowerCase().equals(state.toLowerCase())){
                                    itemsList.add(titles + " by " + emails + " : " + descript);
                                }
                            }

                        }
                        mAdapter.setItems(itemsList);
                        myRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            if(type.equals("none")||type.equals("e")||type.equals("E")) {
                listingsRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot listings : dataSnapshot.getChildren()) {
                            String emails = listings.child("email").getValue(String.class);
                            String descript = listings.child("description").getValue(String.class);
                            String titles = listings.child("title").getValue(String.class);
                            double cost = listings.child("cost").getValue(double.class);
                            String state = listings.child("state").getValue(String.class);
                            String town = listings.child("town").getValue(String.class);
                            if(tTown.toLowerCase().equals(town.toLowerCase())
                                    && tState.toLowerCase().equals(state.toLowerCase())) {
                                Log.d("locationBoolean","true");
                            }
                            Log.d("help", descript);
                            if((mCost==-1 && tTown.isEmpty())){
                                itemsList.add(titles + " by " + emails + " in "+ town +","+ state+ " : " + descript);
                            }
                            if((mCost==-1 && tTown.isEmpty())&&(state.contains(tLoc)||
                                    town.contains(tLoc))){
                                itemsList.add(titles + " by " + emails + " in "+ town +","+state+ " : " + descript);
                            }
                            else if(tTown.isEmpty() && cost != -1){
                                if(cost<=mCost) itemsList.add(titles + " by " + emails + " : " + descript);
                            }
                            else if((mCost == -1 && !tTown.isEmpty())) {
                                Log.d("in conditional","in conditional");
                                if(tTown.toLowerCase().equals(town.toLowerCase())
                                        && tState.toLowerCase().equals(state.toLowerCase())){
                                    itemsList.add(titles + " by " + emails + " : " + descript);
                                }
                            }
                            else if((mCost!=-1 && !tTown.isEmpty())) {
                                Log.d("in conditional","in conditional");
                                if(cost<=mCost && tTown.toLowerCase().equals(town.toLowerCase())
                                        && tState.toLowerCase().equals(state.toLowerCase())){
                                    itemsList.add(titles + " by " + emails + " : " + descript);
                                }
                            }

                        }
                        mAdapter.setItems(itemsList);
                        myRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            List<String> list = new ArrayList<>();
            list.addAll(itemsList);

            mAdapter.setItems(list);

        }
    }

}


