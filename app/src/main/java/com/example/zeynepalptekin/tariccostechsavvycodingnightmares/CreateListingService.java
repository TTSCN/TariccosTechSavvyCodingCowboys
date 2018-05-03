package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CreateListingService extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    Account a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_service);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String[] account = bundle.getStringArray("account");
        }

        Log.d("account","Account in CreateListingService: " + a.getEmail());

        Button backToMain = findViewById(R.id.backToMain7);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });

        Button addImage = findViewById(R.id.addImageButton1);
        addImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addImage();
            }
        });

        Button publish = findViewById(R.id.publishButton1);
        publish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createServiceListing();
            }
        });



    }


    //TODO: this is just a placeholder variable. Not linked to anything
    public void createServiceListing(){

        Log.d("Magnus", "in create service listing");
        String str;

        Account owner = a;

        EditText text = findViewById(R.id.price1);
        str = text.getText().toString();
        Double cost = Double.parseDouble(str);

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        String desc = str;

        Listing serviceL = new Listing(owner, desc, cost, null);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference serviceListingsRef = ref.child("serviceListings");

        serviceListingsRef.push().setValue(serviceL);


    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

    public void addImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}