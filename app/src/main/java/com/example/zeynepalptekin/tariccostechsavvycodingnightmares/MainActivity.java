package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
        Account a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            a = bundle.getParcelable("account");
            TextView log = findViewById(R.id.loginBanner);
            log.setText("You are logged in as " + a.getName());
        }

        Button button = findViewById(R.id.viewListingButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    clickView(a);
            }
        });

        Button buttonTwo = findViewById(R.id.createListingButton);
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clickCreateListing(a);
            }
        });

        Button buttonThree = findViewById(R.id.mainLoginButton);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

        public void clickView(Account a) {
        Log.d("clickView", "clickView is running");
        Intent intent = new Intent(this, SearchForListings.class);
        if(a != null) {
            intent.putExtra("account",a);
        }
        startActivity(intent);
        }

        public void clickCreateListing(Account a) {
        Log.d("clickCreate","clickCreate is running");
        Intent intent = new Intent(this, ChoseListingType.class);
        if(a != null) {
            intent.putExtra("account",a);
        }
        startActivity(intent);
        }

        public void clickLogin() {
        Log.d("clickLogin","clickLogin is running");
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
        }
}



