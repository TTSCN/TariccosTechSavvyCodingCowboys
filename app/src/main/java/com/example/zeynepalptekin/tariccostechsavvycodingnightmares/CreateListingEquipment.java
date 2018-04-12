package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateListingEquipment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_equipment);

        Button backToMain = findViewById(R.id.backToMain7);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
