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
                    clickCreateAccount();
            }
        });

        Button button2 = findViewById(R.id.loginButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        Button button3 = findViewById(R.id.backToMain3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });
    }

    public void login() {
        EditText user = findViewById(R.id.userNameEdit);
        String userName = user.getText().toString();

        EditText pass = findViewById(R.id.passwordEdit);
        String password = pass.getText().toString();

        //code to find specific account given the username and password from firebase
        //this return statement is just here to prevent the code from giving an error message


        //this is temporary hard code logging in as magnus until we get firebase up and running
        Account magnus = new Account("Magnus Thoroddsen", "makosokothorodds@wpi.edu","Worcester",
                "MA","password3");
        backToMain(magnus);
    }

    public void clickCreateAccount() {
        Log.d("clickCreateAccount","clickCreateAccount is running");
        Intent intent = new Intent(this, FirstScreen.class);
        startActivity(intent);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void backToMain(Account a) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("name",a.getName());
        startActivity(intent);
    }
}
