package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class vitaminSelectActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Navigation
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    //Buttons
    Button vitaminA_btn, vitamine_E_btn, vitaminA_plus_D3_btn, vitaminDevicap_btn;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_select);

        //-----------------------------Navigation---------------------------\\
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);

        //-------------------------------Buttons-----------------------------\\
        vitaminA_btn = findViewById(R.id.button_vit_A);
        vitamine_E_btn = findViewById(R.id.button_vit_E);
        vitaminA_plus_D3_btn = findViewById(R.id.button_vit_A_plus_D3);
        vitaminDevicap_btn = findViewById(R.id.button_devicap);

        vitaminA_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(vitaminSelectActivity.this, vitaminAActivity.class);
                startActivity(intent);

            }
        });

        vitamine_E_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        vitaminA_plus_D3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        vitaminDevicap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.menu_homePage:
                Toast.makeText(vitaminSelectActivity.this, "Strona główna", Toast.LENGTH_SHORT).show();
                moveHomeActivity();
                break;

            case R.id.menu_vitamin:
                Toast.makeText(vitaminSelectActivity.this, "Wybór witaminy", Toast.LENGTH_SHORT).show();
                moveToVitamin();
                break;
        }
        return false;
    }

    public void moveHomeActivity(){
        Intent intent = new Intent(vitaminSelectActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void moveToVitamin(){
        Intent intent = new Intent(vitaminSelectActivity.this, vitaminSelectActivity.class);
        startActivity(intent);
    }
}
