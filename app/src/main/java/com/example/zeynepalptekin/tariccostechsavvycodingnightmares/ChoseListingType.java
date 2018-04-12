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

        Button service = findViewById(R.id.serviceButton);
        service.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickService();
            }
        });

        
        Button equipment = findViewById(R.id.equipmentButton);
        equipment.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clickEquipment();
            }
        });

        Button backToMain = findViewById(R.id.backToMain6);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });
    }

    public void clickService() {
        Intent intent = new Intent(this, Create_Listing.class);
        intent.putExtra("type","service");
        startActivity(intent);
    }

    public void clickEquipment() {
        Intent intent = new Intent(this, Create_Listing.class);
        intent.putExtra("type","equipment");
        startActivity(intent);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}