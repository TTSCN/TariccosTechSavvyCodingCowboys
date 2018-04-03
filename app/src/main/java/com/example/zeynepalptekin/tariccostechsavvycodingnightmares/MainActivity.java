package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent(this, CreateListing.class);
        Button button1 = findViewById(R.id.createListingButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                startActivity(intent1);
            }
        });
    }
}


