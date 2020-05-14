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
            "TEST"
    };

    int[] images = {
        R.drawable.ic_home,
        R.drawable.ic_eyedropper,
        R.drawable.ic_milk,
        R.drawable.ic_milk,
        R.drawable.ic_milk,
        R.drawable.ic_pharmacy,
        R.drawable.ic_milk
    };

    String[] activity = {
        "vitaminAActivity",
        "vitaminEActivity",
        "vitaminAplusD3Activity",
        "vitaminDevicapActivity"
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
