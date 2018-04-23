package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        Button button = findViewById(R.id.viewListingButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    clickView();
            }
        });

        Button buttonTwo = findViewById(R.id.createListingButton);
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clickCreateListing();
            }
        });

        Button buttonThree = findViewById(R.id.mainLoginButton);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

        public void clickView() {
        Log.d("clickView", "clickView is running");
        Intent intent = new Intent(this, SearchForListings.class);
        startActivity(intent);
        }

        public void clickCreateListing() {
        Log.d("clickCreate","clickCreate is running");
        Intent intent = new Intent(this, ChoseListingType.class);
        startActivity(intent);
        }

        public void clickLogin() {
        Log.d("clickLogin","clickLogin is running");
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
        }
}



