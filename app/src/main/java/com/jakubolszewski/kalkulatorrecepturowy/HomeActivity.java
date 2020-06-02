package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

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

        gridView = (GridView) findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(this, values, images);

        gridView.setAdapter(gridAdapter);



    }


}
