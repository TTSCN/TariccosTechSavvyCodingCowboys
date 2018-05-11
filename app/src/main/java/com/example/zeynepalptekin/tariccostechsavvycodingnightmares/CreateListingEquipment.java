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
import android.widget.TextView;

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

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_equipment);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String[] account = bundle.getStringArray("account");
          if(account != null)  a = new Account(account[0],account[1],account[2],account[3],account[4]);
            Log.d("account","Account in CreateListingEquipment: " + a.getEmail());
        }

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
/*                //Get Global Controller Class object (see application tag in AndroidManifest.xml)
                final Controller aController = (Controller) getApplicationContext();

                TextView textView = findViewById(R.id.createListingTitle2);
                String title = textView.getText().toString();
                System.out.println(title);

                EditText editText = findViewById(R.id.descriptionText1);
                String description = editText.getText().toString();
                System.out.println(description);
*/

                createEquipmentListing();
//                aController.getListingMap().put(title, description);

                createEquipmentListing();
                backToMain();

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
        if(str.isEmpty()) str = "0";
        double cost = Double.parseDouble(str);

        text = findViewById(R.id.typeText2);
        str = text.getText().toString();
        String type = str;

        text = findViewById(R.id.descriptionText1);
        str = text.getText().toString();
        String desc = str;

        Listing equipL = new Listing(desc, cost, type, "email", "town", "state");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference equipmentListingsRef = ref.child("equipmentListings");

        equipmentListingsRef.push().setValue(equipL);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if(a != null){
            String[] account = {a.getName(),a.getEmail(),a.getLocation().getTown(),a.getLocation().getState(),a.getPassword()};
            intent.putExtra("account",account);
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
