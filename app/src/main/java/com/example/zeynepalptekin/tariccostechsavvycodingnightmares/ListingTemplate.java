package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListingTemplate extends AppCompatActivity {
    Account a;
    Listing l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_template);

        TextView listingTitle = (TextView)findViewById(R.id.listingTitle);
//        listingTitle.setText(l.getTitle());
        listingTitle.setText("FOod");

        TextView listingDescription = (TextView)findViewById(R.id.listingDescription);
//        listingDescription.setText(l.getDescription());
        listingDescription.setText("taco burrrrrrrrrrritos");

        TextView ownerEmail = (TextView)findViewById(R.id.ownerEmail);
//        ownerEmail.setText("Contact " + a.getEmail() + " for more information");
        ownerEmail.setText("contact meeee");
    }
}
