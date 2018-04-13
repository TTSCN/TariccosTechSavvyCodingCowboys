package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchForListings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_listings);

        Button backToMain = findViewById(R.id.backToMain1);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
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

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
