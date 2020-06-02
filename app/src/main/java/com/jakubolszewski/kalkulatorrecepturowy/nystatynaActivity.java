package com.jakubolszewski.kalkulatorrecepturowy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class nystatynaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nystatyna);
    }

    public void goBack(View view) {
        Intent intent = new Intent(nystatynaActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
