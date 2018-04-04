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
        final Button button = findViewById(R.id.viewListingButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    clickView();
            }
        });
    }

        public void clickView() {
        Log.d("clickView", "clickView is running");
        Intent intent = new Intent(this, SearchForListings.class);
        startActivity(intent);
        }
}



