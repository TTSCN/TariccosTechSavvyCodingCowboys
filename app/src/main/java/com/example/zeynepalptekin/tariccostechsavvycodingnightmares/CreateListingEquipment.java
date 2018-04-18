package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.zeynepalptekin.tariccostechsavvycodingnightmares.CreateListingService.PICK_IMAGE;

public class CreateListingEquipment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_equipment);

        Button backToMain = findViewById(R.id.backToMain8);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });

        Button addImage = findViewById(R.id.addImageButton1);
        addImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addImage();
            }
        });

        Button publish = findViewById(R.id.publishButton2);
        publish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               Listing newListing =  createEquipmentListing();
            }
        });
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public Listing createEquipmentListing(){

        String str;

        Account owner = FirstScreen.Accounts.get(a.getEmail());

        Listing equipL = new Listing(owner, "blank", "type", 0);

        EditText text = findViewById(R.id.priceText1);
        str = text.getText().toString();
        equipL.setCost(Double.parseDouble(str));

        text = findViewById(R.id.typeText2);
        str = text.getText().toString();
        equipL.setEquipmentType(str);

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        equipL.setDescription(str);

        return equipL;
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}
