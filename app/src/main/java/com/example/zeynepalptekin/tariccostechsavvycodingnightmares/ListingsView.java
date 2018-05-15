package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

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

public class ListingsView extends Activity {
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Account a;
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

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference listingsRef = database.getReference("serviceListings");
            final DatabaseReference listingsRef2 = database.getReference("equipmentListings");

            final RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            final MyAdapter mAdapter = new MyAdapter();
//            myRecyclerView.setAdapter(mAdapter);

            listingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot listings : dataSnapshot.getChildren()) {
                        String emails = listings.child("email").getValue(String.class);
                        String descript = listings.child("description").getValue(String.class);
                        String titles = listings.child("title").getValue(String.class);
                        Log.d("help",descript);
                        itemsList.add(titles + " by " + emails + " : " + descript);
                    }
                    mAdapter.setItems(itemsList);
                    myRecyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            listingsRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot listings : dataSnapshot.getChildren()) {
                        String emails = listings.child("email").getValue(String.class);
                        String descript = listings.child("description").getValue(String.class);
                        String titles = listings.child("title").getValue(String.class);
                        Log.d("help",descript);
                        itemsList.add(titles + " by " + emails + " : " + descript);
                    }
                    mAdapter.setItems(itemsList);
                    myRecyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            List<String> list = new ArrayList<>();
            list.addAll(itemsList);

            mAdapter.setItems(list);

        }
    }

    public void searchBar() {
        EditText searchBar = findViewById(R.id.searchInput);
        searchBar.getText().toString();

    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String charString = charSequence.toString();
//                if (charString.isEmpty()) {
//                    contactListFiltered = contactList;
//                } else {
//                    List<Contact> filteredList = new ArrayList<>();
//                    for (Contact row : contactList) {
//
//                        // name match condition. this might differ depending on your requirement
//                        // here we are looking for name or phone number match
//                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getPhone().contains(charSequence)) {
//                            filteredList.add(row);
//                        }
//                    }
//
//                    contactListFiltered = filteredList;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = contactListFiltered;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                contactListFiltered = (ArrayList<Contact>) filterResults.values;
//
//                // refresh the list with filtered data
//                notifyDataSetChanged();
//            }
//        };
//    }
}


