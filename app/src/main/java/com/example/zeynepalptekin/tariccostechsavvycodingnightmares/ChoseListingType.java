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
        Button equip = findViewById(R.id.equipmentButton);

        service.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                toCreateService();
            }
            });
        service.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                toCreateEquip();
            }
        });

    }

    public void toCreateService(){
        Intent serviceIntent = new Intent(this,CreateListingService.class);
        startActivity(serviceIntent);
    }
    public void toCreateEquip(){
        Intent equipIntent = new Intent(this, CreateListingEquipment.class);
        startActivity(equipIntent);
    }

}
