package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Button button = findViewById(R.id.createAccountButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public Account login() {
        EditText user = findViewById(R.id.userNameEdit);
        String userName = user.getText().toString();

        EditText pass = findViewById(R.id.passwordEdit);
        String password = pass.getText().toString();

        //code to find specific account given the username and password from firebase
        //this return statement is just here to prevent the code from giving an error message
        return new Account();
    }

    public void clickCreateAccount() {
        Log.d("clickCreateAccount","clickCreateAccount is running");
        Intent intent = new Intent(this, FirstScreen.class);
        startActivity(intent);
    }
}
