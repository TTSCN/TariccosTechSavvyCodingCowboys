package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;


public class CreateListingEquipment extends AppCompatActivity {
    public static final int PICK_IMAGE = 100;
    Uri imageUri;

    Listing listing;
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
               Listing newListing = createEquipmentListing();
               listing.ListingsList.put(equipL.getOwner(), equipL);
            }
        });
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    Listing equipL;
    public Listing createEquipmentListing(){

        String str;

        Account owner = FirstScreen.Accounts.get(a.getEmail());
        //TODO: test to make sure that imageUri is not null
        equipL = new Listing(owner, "blank", "type", 0, imageUri);

        EditText text = findViewById(R.id.price2);
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

    private void addImage() {
        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(image, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
        }
    }
}
