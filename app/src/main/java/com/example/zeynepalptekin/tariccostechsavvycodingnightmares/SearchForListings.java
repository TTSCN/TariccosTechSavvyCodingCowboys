package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchForListings extends AppCompatActivity {
    Account a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            a = bundle.getParcelable("account");
        }
        setContentView(R.layout.activity_search_for_listings);

        Button backToMain = findViewById(R.id.backToMain1);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain(a);
            }
        });

        Button searchListings = findViewById(R.id.searchButton);
        searchListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewListings(a);
            }
        });
    }

    public ArrayList<Object> getParameters(){
        ArrayList<Object> parameters = new ArrayList<>();

        //adds the keywords to the arraylist of parameters
        EditText text = findViewById(R.id.kewWordsEdit);
        String str = text.getText().toString();
        parameters.add(str);

        //adds the type to the arraylist of parameters
        text = findViewById(R.id.typeEdit);
        str = text.getText().toString();
        parameters.add(str);

        //adds the max price to the arraylist of parameters
        text = findViewById(R.id.maxPriceEdit);
        str = text.getText().toString();
        Double price = Double.parseDouble(str);
        parameters.add(price);

        return parameters;

    }

    public void backToMain(Account a) {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
           // intent.putExtra("account",a);
        }
        startActivity(intent);
    }

    public void viewListings(Account a){
        Intent intent = new Intent(this, ListingsView.class);
        if(a != null) {
         //   intent.putExtra("account",a);
        }
        startActivity(intent);
    }
}
