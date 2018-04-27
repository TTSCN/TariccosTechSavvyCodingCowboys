package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.Currency;

public class ListingsView extends ListActivity {
   ArrayList<String> items = new ArrayList<String>();

    ArrayAdapter<String> itemsAdapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_view);

        items.add("Plantfood");
        items.add("lawnmower");
        items.add("grass");
        items.add("tomatoplants");
        items.add("tiger");

        ListView listView = (ListView) findViewById(R.id.sampleList);
        listView.setAdapter(itemsAdapter);
    }
}
