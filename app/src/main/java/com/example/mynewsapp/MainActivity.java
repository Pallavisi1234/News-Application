package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent ;
                if(FirebaseAuth.getInstance().getCurrentUser() != null){
                    intent = new Intent(MainActivity.this, HomePage.class);
                }else{
                    intent = new Intent(MainActivity.this, SignUp.class);
                }
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}