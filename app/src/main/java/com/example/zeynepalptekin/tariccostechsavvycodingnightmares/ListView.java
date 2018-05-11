package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListView extends AppCompatActivity {

    Account a;

    //Firebase
    private DatabaseReference nDatabase;

    //Android Layout
    private Button search;
    private EditText etDatabase;
    private android.widget.ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        nDatabase = FirebaseDatabase.getInstance().getReference();

        search = (Button) findViewById(R.id.search);
        etDatabase = (EditText) findViewById(R.id.etDatabase);
        listView = findViewById(R.id.database_list_view);


    }
}
