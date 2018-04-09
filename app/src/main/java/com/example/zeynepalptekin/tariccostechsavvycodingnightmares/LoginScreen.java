package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
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
}
