package com.example.codinginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SHPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_h_p);
    }



    public void writeShP(View view) {
        //Writing in SharedPreferences
        SharedPreferences shp = getSharedPreferences("coding_in_flow",MODE_PRIVATE);
        shp.edit().putString("BCA","Bachelor Of Computer Application").apply();

    }

    public void readShp(View view) {
        //Reading from SharedPreferences
        SharedPreferences shp = getSharedPreferences("coding_in_flow",MODE_PRIVATE);
        String fullform = shp.getString("BCA","a");
        Toast.makeText(this, fullform,Toast.LENGTH_SHORT).show();

    }
}