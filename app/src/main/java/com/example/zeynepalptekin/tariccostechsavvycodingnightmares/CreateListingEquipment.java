package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.example.zeynepalptekin.tariccostechsavvycodingnightmares.CreateListingService.PICK_IMAGE;

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
               createEquipmentListing();


            }
        });
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public void createEquipmentListing(){

        Log.d("Magnus", "in create equipment listing");
        String str;

        Account owner = new Account();

        Listing equipL = new Listing(owner, "blank", "type", 0, null);

        EditText text = findViewById(R.id.priceText2);
        str = text.getText().toString();
        equipL.setCost(Double.parseDouble(str));

        text = findViewById(R.id.typeText2);
        str = text.getText().toString();
        equipL.setEquipmentType(str);

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        equipL.setDescription(str);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference equipmentListingsRef = ref.child("equipmentListings");

        equipmentListingsRef.setValue(equipL);
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
