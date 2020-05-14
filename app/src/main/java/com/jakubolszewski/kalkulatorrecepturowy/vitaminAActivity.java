package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class vitaminAActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    //-----------------------------Navigation---------------------------\\
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    //-----------------------------numeric-variables---------------------------\\
    int amount, density, companyChoice, unitChoice;

    double volume, drops, massUnit;
    //-----------------------------text-variables---------------------------\\
    String Company, Unit, Hasco, Medana, Fargon, gram, jm;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_a);

        spinnerCompany = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

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

        //-----------------------------text-variables---------------------------\\
        Hasco = "Vitaminimum A Hasco 45000 j/ml";
        Medana = "Vitaminimum A Medana 50000 j/ml";
        Fargon = "Vitaminimum A Fagron";
        gram = "Vit liq \"XX\" g";
        jm = "VIT A \"XX\" j.m.";

        //-----------------------------textview---------------------------\\
        calculation1_TV = findViewById(R.id.textView_calculation1);
        calculation2_TV = findViewById(R.id.textView_calculation2);
        calculation3_TV = findViewById(R.id.textView_calculation3);

        //-----------------------------Spinner---------------------------\\
        spinnerCompany = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerCompany = findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(this, R.array.companySpinner_vit_A, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(adapterCompany);
        spinnerCompany.setOnItemSelectedListener(this);
        final Object Company = spinnerCompany.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();

        //-----------------------------TextEdit---------------------------\\
        amount_ET = findViewById(R.id.editText_amount);

        //-----------------------------Button---------------------------\\
        calc_btn = findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String valueFromET = amount_ET.getText().toString();

                if (!valueFromET.isEmpty()) {
                    amount = Integer.parseInt(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }
                //-----------------------------HASCO---------------------------\\
                if (companyChoice == 1) {


                    String test = String.valueOf(volume);

                    Toast.makeText(vitaminAActivity.this, test, Toast.LENGTH_SHORT).show();
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {
                        volume = amount / 1.148;
                        drops = volume * 28;
                        massUnit = volume * 45000;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops *= 100;
                        drops = Math.round(drops);
                        drops /= 100;

                        massUnit = Math.round(massUnit);


                        calculation1_TV.setText(volume + "ml");
                        calculation2_TV.setText(drops + " kropli");
                        calculation3_TV.setText(massUnit + " j.m.");
                    }
                    //-----------------------------J.M.---------------------------\\


                }
                //-----------------------------MEDANA---------------------------\\
                if (companyChoice == 2) {

                }

                //-----------------------------FARGON---------------------------\\
                if (companyChoice == 3) {

                }
            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.menu_homePage:
                Toast.makeText(vitaminAActivity.this, "Strona główna", Toast.LENGTH_SHORT).show();
                moveHomeActivity();
                break;

            case R.id.menu_vitamin:
                Toast.makeText(vitaminAActivity.this, "Wybór witaminy", Toast.LENGTH_SHORT).show();
                moveToVitamin();
                break;
        }
        return false;
    }

    public void moveHomeActivity() {
        Intent intent = new Intent(vitaminAActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void moveToVitamin() {
        Intent intent = new Intent(vitaminAActivity.this, vitaminSelectActivity.class);
        startActivity(intent);
    }


    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner spinnerCompany = (Spinner) parent;
        Spinner spinnerUnit = (Spinner) parent;


        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();
            //Toast.makeText(vitaminAActivity.this, Company, Toast.LENGTH_SHORT).show();

            if (Company.contains("Hasco")) {
                companyChoice = 1;
                Toast.makeText(vitaminAActivity.this, "1", Toast.LENGTH_SHORT).show();


            }
            if (Company.contains("Medana")) {
                companyChoice = 2;
                Toast.makeText(vitaminAActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
            if (Company.contains("Fagron")) {
                companyChoice = 3;
                Toast.makeText(vitaminAActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();
            Toast.makeText(vitaminAActivity.this, Unit, Toast.LENGTH_SHORT).show();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }
            if (Unit.contains("j.m.")) {
                unitChoice = 2;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
