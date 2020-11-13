package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.jakubolszewski.kalkulatorrecepturowy.vitamins.vitaminAActivity;
import com.jakubolszewski.kalkulatorrecepturowy.vitamins.vitaminAplusD3Activity;
import com.jakubolszewski.kalkulatorrecepturowy.vitamins.vitaminDevicapActivity;
import com.jakubolszewski.kalkulatorrecepturowy.vitamins.vitaminEActivity;

import com.jakubolszewski.kalkulatorrecepturowy.oils.*;

public class HomeActivity extends AppCompatActivity{

    GridView gridView;

    String[] values = {
            "Witamina A",
            "Witamina E",
            "Witamina A + D3",
            "Devicap",
            "Spirytus",
            "Olejki",
            "Oleje",
            "Nystatyna",
            "Dimeticonum",
            "Informacje"
    };

    int[] images = {
        R.drawable.ic_vit_a,
        R.drawable.ic_vit_e,
        R.drawable.ic_vit_a_d3,
        R.drawable.ic_pills,
        R.drawable.ic_alcohol,
        R.drawable.ic_olejki,
        R.drawable.ic_olejki,
        R.drawable.ic_eyedropper,
        R.drawable.ic_eyedropper,
        R.drawable.ic_info_outline_black_24dp,

    };



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //gridView = (GridView) findViewById(R.id.gridView);

        //GridAdapter gridAdapter = new GridAdapter(this, values, images);

        //gridView.setAdapter(gridAdapter);



    }


    public void goToVItA(View view) {
        Intent intent = new Intent(HomeActivity.this, vitaminAActivity.class);
        startActivity(intent);
    }

    public void goToVitE(View view) {
        Intent intent = new Intent(HomeActivity.this, vitaminEActivity.class);
        startActivity(intent);
    }

    public void goToVitAD3(View view) {
        Intent intent = new Intent(HomeActivity.this, vitaminAplusD3Activity.class);
        startActivity(intent);
    }

    public void goToVitDevicap(View view) {
        Intent intent = new Intent(HomeActivity.this, vitaminDevicapActivity.class);
        startActivity(intent);
    }

    public void goToAlcohol(View view) {
        Intent intent = new Intent(HomeActivity.this, alcoholActivity.class);
        startActivity(intent);
    }

    public void goToOlejki(View view) {
        Intent intent = new Intent(HomeActivity.this, olejkiActivity.class);
        startActivity(intent);
    }

    public void goToInfo(View view) {
        Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void goToDimeticonum(View view) {
        Intent intent = new Intent(HomeActivity.this, dimeticonumActivity.class);
        startActivity(intent);
    }

    public void goToNystatyna(View view) {
        Intent intent = new Intent(HomeActivity.this, nystatynaActivity.class);
        startActivity(intent);
    }

    public void goToOleje(View view) {
        Intent intent = new Intent(HomeActivity.this, olejeActivity.class);
        startActivity(intent);
    }
}
