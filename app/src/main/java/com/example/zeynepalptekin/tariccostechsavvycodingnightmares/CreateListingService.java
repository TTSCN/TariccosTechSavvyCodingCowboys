package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class CreateListingService extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Listing createServiceListing(Account owner, String description, double cost){
        Listing serviceL = new Listing(owner, description, cost);
        String str;
        //TODO: create account owner by pulling from account information

        EditText text = findViewById(R.id.titleText);
        //TODO: make sure title is automatically filled in in the .xml
        str = text.getText().toString();
//        serviceL.
//
//        text = findViewById(R.id.priceText);
        str = text.getText().toString();
        return serviceL;
    }

    public Listing createEquipmentListing(Account owner, String description, String equipmentType, double cost){
        Listing equipL = new Listing(owner, description, equipmentType, cost);
        String str;

        //TODO: create account owner by pulling from account information

        EditText text = findViewById(R.id.titleText);
        str = text.getText().toString();


        text = findViewById(R.id.priceText);
        str = text.getText().toString();

        return equipL;
    }

}