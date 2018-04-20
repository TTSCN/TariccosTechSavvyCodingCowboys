package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateListingService extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    Uri imageUri;

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
                Listing newListing =  createServiceListing();
            }
        });

    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public Listing createServiceListing(){

        String str;
        //TODO: test to make sure that imageUri is not null
        Account owner = FirstScreen.Accounts.get(a.getEmail());
        Listing serviceL = new Listing(owner, "blank", 0, imageUri);

        EditText text = findViewById(R.id.priceText1);
        str = text.getText().toString();
        serviceL.setCost(Double.parseDouble(str));

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        serviceL.setDescription(str);

        return serviceL;
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