package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListingsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference serviceListingsRef = database.getReference("serviceListings");

        serviceListingsRef.orderByChild("serviceListings").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                System.out.println(dataSnapshot.getKey());
            }

            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                System.out.println("The data at for this object has been changed.");
            }
            public void onChildRemoved(DataSnapshot snapshot) {
                System.out.println("This information was removed for security reasons or for violating the Terms of Use.");
            }
            public void onCancelled(DatabaseError error) {
                System.out.println("Unable to retrieve data.");
            }

            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {

            }
        });
    }
}
