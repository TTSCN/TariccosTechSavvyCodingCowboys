package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        Button backToMain = findViewById(R.id.backToMain4);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });
        */
    }

    public void createAccount(View v){
        Account a = new Account();
        EditText text = findViewById(R.id.nameText);
        String str = text.getText().toString();
        a.changeName(str);

        text = findViewById(R.id.passwordText);
        str = text.getText().toString();
        a.changePassword(str);

        text = findViewById(R.id.emailText);
        str = text.getText().toString();
        a.changeEmail(str);

        text = findViewById(R.id.stateText);
        str = text.getText().toString();
        a.getLocation().setState(str);

        text = findViewById(R.id.stateText);
        str = text.getText().toString();
        a.getLocation().setTown(str);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference accounts = ref.child("users");

        accounts.setValue(a);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
