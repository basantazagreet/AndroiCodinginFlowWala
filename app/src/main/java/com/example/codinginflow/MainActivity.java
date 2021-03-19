package com.example.codinginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gotoSound(View view) {
        Intent i = new Intent(this, SoundActivity.class);
        startActivity(i);
    }

    public void gotoCamera(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 100);
    }

    public void gotoSharedPreferences(View view) {
        Intent i = new Intent(this, SHPActivity.class);
        startActivity(i);
    }


    public void gotoLoginActivity(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void gotosignupActivity(View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }


}