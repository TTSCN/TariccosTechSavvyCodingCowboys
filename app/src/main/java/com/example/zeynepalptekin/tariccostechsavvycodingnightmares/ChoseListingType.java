package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoseListingType extends AppCompatActivity {

Account a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_listing_type);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            a = bundle.getParcelable("account");
        }
        Button service = findViewById(R.id.serviceButton);
        service.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickService(a);
            }
        });


        Button equipment = findViewById(R.id.equipmentButton);
        equipment.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clickEquipment(a);
            }
        });

        Button backToMain = findViewById(R.id.backToMain6);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain(a);
            }
        });
    }

    public void clickService(Account a) {
        Intent intent = new Intent(this, CreateListingService.class);
        intent.putExtra("type","service");
        intent.putExtra("account",a);
        startActivity(intent);
    }

    public void clickEquipment(Account a) {
        Intent intent = new Intent(this, CreateListingEquipment.class);
        intent.putExtra("type","equipment");
        intent.putExtra("account",a);
        startActivity(intent);
    }

    public void backToMain(Account a) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("account",a);
        startActivity(intent);
    }
}