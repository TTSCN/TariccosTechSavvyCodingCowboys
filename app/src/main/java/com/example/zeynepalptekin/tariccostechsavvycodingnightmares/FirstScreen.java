package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FirstScreen extends AppCompatActivity {

    /**
     * hashmap of emails to accounts
     */
   // static HashMap<String,Account> Accounts = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

      /*  Button button = findViewById(R.id.createAccountButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });
    */

        Button backToMain = findViewById(R.id.backToMain4);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

    }
        Account a;
    public void createAccount(View v){
        EditText text = findViewById(R.id.nameText);
        String name = text.getText().toString();


        text = findViewById(R.id.passwordText);
        String password = text.getText().toString();

        text = findViewById(R.id.emailText);
        String email = text.getText().toString();


        text = findViewById(R.id.stateText);
        String state = text.getText().toString();

        text = findViewById(R.id.cityText);
        String city = text.getText().toString();

        a = new Account(name,email,city,state,password);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference accounts = ref.child("users");

        Log.d("account","account is made " + a.toString());
        accounts.push().setValue(a);

        backToMain();
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null) {
            intent.putExtra("account",a);
        }
        startActivity(intent);
    }

}
