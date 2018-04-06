package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Account a = createAccount();
    }

    public Account createAccount(){
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


        return a;
    }

}
