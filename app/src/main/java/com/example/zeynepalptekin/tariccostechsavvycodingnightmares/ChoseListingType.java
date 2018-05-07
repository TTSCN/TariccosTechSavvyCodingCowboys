package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChoseListingType extends AppCompatActivity {

Account a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_listing_type);

        Intent intent = new Intent(this,CreateListingService.class);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            String[] account = bundle.getStringArray("account");
            a = new Account(account[0],account[1],account[2],account[3],account[4]);
            Log.d("account","Account in ChoseListing: " + a.getEmail());
        }

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
        Intent intent = new Intent(this, CreateListingService.class);
        intent.putExtra("type","service");
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

    public void clickEquipment() {
        Intent intent = new Intent(this, CreateListingEquipment.class);
        intent.putExtra("type","equipment");
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }
}