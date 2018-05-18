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

/**
 * the class allows the user to create a service listing
 * listing is pushed to firebase
 */
public class CreateListingService extends AppCompatActivity {
    /**
     * image code is not used by the user in the app
     */
    public static final int PICK_IMAGE = 1;

    /**
     * account of the user
     */
    Account a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_service);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String[] account = bundle.getStringArray("account");

            a = new Account(account[0],account[1],account[2],account[3],account[4]);
            Log.d("Account","Account in CreateListingService "  + a.getEmail());
        }

        //Log.d("account","Account in CreateListingService: " + a.getEmail());

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
                //Get Global Controller Class object (see application tag in AndroidManifest.xml)
                final Controller aController = (Controller) getApplicationContext();

                TextView textView = findViewById(R.id.createListingTitle1);
                String title = textView.getText().toString();
                System.out.println(title);

                EditText editText = findViewById(R.id.descriptionText1);
                String description = editText.getText().toString();
                System.out.println(description);

                aController.getListingMap().put(title, description);

                createServiceListing();
                backToMain();
            }
        });



    }


    /**
     * creates a service listing from user-entered information
     * pushes the listing to firebase
     */
    public void createServiceListing(){

        Log.d("Magnus", "in create service listing");
        String str;

        EditText text = findViewById(R.id.price1);
        str = text.getText().toString();
        if(str.isEmpty()) str = "0";
        Double cost = Double.parseDouble(str);

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        String desc = str;

        text = findViewById(R.id.typeText2);
        str = text.getText().toString();
        String type = str;

        Listing serviceL = new Listing(desc, cost, type, a.getEmail(), a.getLocation().getTown(),
                a.getLocation().getState());

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference serviceListingsRef = ref.child("serviceListings");

        serviceListingsRef.push().setValue(serviceL);


    }

    /**
     * brings the use back to the main activity
     * passes the user account information to the main activity
     */
    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

    /**
     * not used in the app
     */
    public void addImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}