package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoseListingType extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_listing_type);

        Intent intent = new Intent(this,Create_Listing.class);

        Button service = findViewById(R.id.serviceButton);
//        service.setOnClickListener(new View.OnClickListener(){
//
//            public void onClick (View v){
//                click();
//            });
//        }
    }
//
//    public void click();
}
