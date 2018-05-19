package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * class that prompts users to enter parameters for listings to view
 * brings the user to the ViewListings activity
 */
public class SearchForListings extends AppCompatActivity {

    /**
     * account of the user
     */
    Account a;

    /**
     * user-entered parameters to search for listings to view
     */
    String[] parameters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_listings);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String[] account = bundle.getStringArray("account");
            a = new Account(account[0],account[1],account[2],account[3],account[4]);
        }

        Button backToMain = findViewById(R.id.backToMain1);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        Button searchListings = findViewById(R.id.searchButton);
        searchListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parameters = getParameters();
                viewListings();
            }
        });

        Button onlyInMy = findViewById(R.id.onlyButton);
        onlyInMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parameters = getParameters();
                parameters[2] = a.getLocation().getTown();
                parameters[3] = a.getLocation().getState();
                viewListings();
            }
        });
    }

    /**
     * retrieves the user-entered parameters
     * @return the parameters in a string array
     */
    public String[] getParameters(){
        String[] params = new String[5];

        //adds the type to the arraylist of parameters
        EditText text = findViewById(R.id.typeEdit);
       String str = text.getText().toString();
       if(str.isEmpty()) params[0] = "none";
       else params[0] = str;


        //adds the max price to the arraylist of parameters
        text = findViewById(R.id.maxPrice);
        str = text.getText().toString();
        if(str.isEmpty()) params[1] = "none";
        else if(str.toLowerCase()=="e"||str.toLowerCase()=="s") params[1] = str;
        else params[1] = "none";

        //adds the user-defined location to the arraylist of params
        text = findViewById(R.id.locationEdit);
        str = text.getText().toString().toLowerCase();
        if(str.isEmpty()) params[4]=" ";
        else params[4] = str;

        params[2] = "";
        params[3] = "";

        return params;

    }

    /**
     * brings the user back to the main activity
     * passes the account information of the user back to the main activity
     */
    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),
            a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

    /**
     * brings the user to the ViewListings activity
     * passes the account of the user to the ViewListings activity
     * passes the parameters to the ViewListings activity
     */
    public void viewListings(){
        Intent intent = new Intent(this, ListingsView.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),
                    a.getPassword()};
            intent.putExtra("account",account);
        }
        if(parameters!=null) intent.putExtra("parameters",parameters);
        startActivity(intent);
    }
}
