package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CreateListingService extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_service);

        Button backToMain = findViewById(R.id.backToMain7);
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

        Button publish = findViewById(R.id.publishButton1);
        publish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createServiceListing();
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                // Log.d(TAG, String.valueOf(bitmap));
//
//                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public void createServiceListing(){

        Log.d("Magnus", "in create service listing");
        String str;

        Account owner = new Account();
        Listing serviceL = new Listing(owner, "blank", 0, null);

        EditText text = findViewById(R.id.priceText1);
        str = text.getText().toString();
        serviceL.setCost(Double.parseDouble(str));

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        serviceL.setDescription(str);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference serviceListingsRef = ref.child("serviceListings");

        serviceListingsRef.push().setValue(serviceL);


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