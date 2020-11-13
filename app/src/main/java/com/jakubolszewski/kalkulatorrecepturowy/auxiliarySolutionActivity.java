package com.jakubolszewski.kalkulatorrecepturowy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.jakubolszewski.kalkulatorrecepturowy.vitamins.*;


public class auxiliarySolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliary_solution);
    }

    public void goBack(View view) {
        Intent intent = new Intent(auxiliarySolutionActivity.this, vitaminAActivity.class);
        startActivity(intent);
    }
}
