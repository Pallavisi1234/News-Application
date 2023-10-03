package com.example.mynewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class contactus extends AppCompatActivity {

    CardView cardprerna;
    CardView cardpallavi;
    CardView cardaryan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);

        cardprerna=findViewById(R.id.cardprerna);
        cardpallavi=findViewById(R.id.cardpallavi);
        cardaryan=findViewById(R.id.cardaryan);

        cardprerna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contactus.this, " PRERNA PANDEY WELCOMES YOU", Toast.LENGTH_SHORT).show();
                Intent inu=new Intent(contactus.this , PrernaActivity.class);
                startActivity(inu);

            }
        });
        cardpallavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contactus.this, "PALLAVI SINGH WELCOMES YOU", Toast.LENGTH_SHORT).show();
                Intent ino= new Intent(contactus.this , PallaviActivity.class);
                startActivity(ino);

            }
        });
        cardaryan.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Toast.makeText(contactus.this, "ARYAN SRIVASTAV WELCOMES YOU", Toast.LENGTH_SHORT).show();
                                             Intent ino= new Intent(contactus.this , AryanActivity.class);
                                             startActivity(ino);

                                         }
                                     }
        );




    }
}

