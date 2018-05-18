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

/**
 * class that allows user to create an account
 * creating an account will log the user into that account
 * pushes new account to firebase
 */
public class FirstScreen extends AppCompatActivity {
    /**
     * account the user will create
     */
    Account a;

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

    /**
     * creates an account from user-entered information
     * pushes account to firebase
     * @param v xml of the activity
     */
    public void createAccount(View v){
        a = new Account();
        EditText text = findViewById(R.id.nameText);
        String str = text.getText().toString();
        a.changeName(str);

        text = findViewById(R.id.passwordText);
        str = text.getText().toString();
        a.setPassword(str);

        text = findViewById(R.id.emailText);
        str = text.getText().toString();
        a.setEmail(str);

        text = findViewById(R.id.stateText);
        str = text.getText().toString();
        a.getLocation().setState(str);

        text = findViewById(R.id.cityText);
        str = text.getText().toString();
        a.getLocation().setTown(str);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference accounts = ref.child("users");

        accounts.push().setValue(a);
        backToMain();
    }


    /**
     * brings the user back to the main activity
     * passes the account of the user back to the main activity
     */
    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null) {
           String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),
                   a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
        }
        startActivity(intent);
    }

}
