package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchForListings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_listings);
        getParameters();
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
}
