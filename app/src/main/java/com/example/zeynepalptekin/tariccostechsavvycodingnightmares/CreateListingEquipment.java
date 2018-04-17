package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateListingEquipment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_equipment);

        Button backToMain = findViewById(R.id.backToMain7);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public Listing createEquipmentListing(Account owner, String description, String equipmentType, double cost){
        Listing equipL = new Listing(owner, description, equipmentType, cost);
        String str;

        owner = FirstScreen.Accounts.get(a.getEmail());

        EditText text = findViewById(R.id.titleText);
        String title = equipL.getTitle();
        TextView titleLabel = (TextView)findViewById(R.id.titleText);
        titleLabel.setText(title);

        text = findViewById(R.id.priceText);
        str = text.getText().toString();

        text = findViewById(R.id.typeText);
        str = text.getText().toString();

        text = findViewById(R.id.descriptionText);
        str = text.getText().toString();

        return equipL;
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
