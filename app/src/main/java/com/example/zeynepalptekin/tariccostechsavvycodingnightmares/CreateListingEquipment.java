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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.zeynepalptekin.tariccostechsavvycodingnightmares.CreateListingService.PICK_IMAGE;

public class CreateListingEquipment extends AppCompatActivity {
    public static final int PICK_IMAGE = 100;
    Uri imageUri;

    Account a;

    Listing listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            a = bundle.getParcelable("account");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_equipment);

        Button backToMain = findViewById(R.id.backToMain8);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain(a);
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

    //TODO: this is just a placeholder variable. Not linked to anything
    public void createEquipmentListing(){

        Log.d("Magnus", "in create equipment listing");
        String str;

        Account owner = a;

        EditText text = findViewById(R.id.price2);
        str = text.getText().toString();
        Double cost = Double.parseDouble(str);

        text = findViewById(R.id.typeText2);
        str = text.getText().toString();
        String type = str;

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        String desc = str;

       // Listing equipL = new Listing(owner, desc, type, cost, null);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference equipmentListingsRef = ref.child("equipmentListings");

       // equipmentListingsRef.push().setValue(equipL);
    }

    public void backToMain(Account a) {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null) {
            //intent.putExtra("account",a);
        }
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
