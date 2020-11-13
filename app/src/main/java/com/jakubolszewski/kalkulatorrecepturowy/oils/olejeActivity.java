package com.jakubolszewski.kalkulatorrecepturowy.oils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jakubolszewski.kalkulatorrecepturowy.HomeActivity;
import com.jakubolszewski.kalkulatorrecepturowy.R;

public class olejeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double amount, volume, grams, density;

    //-----------------------------text-variables---------------------------\\
    String Company, Unit;


    EditText amount_ET, density_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV;
    TextView textView_oilMain, textView_oilMain2;
    TextView title1_TV, title2_TV;
    LinearLayout linearLayout1, linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oleje);

        //-----------------------------textview---------------------------\\
        calculation1_TV = findViewById(R.id.textView_calculation1);
        calculation2_TV = findViewById(R.id.textView_calculation2);

        textView_oilMain = findViewById(R.id.textView_mainOil);
        textView_oilMain2 = findViewById(R.id.textView_mainOil2);

        title1_TV = findViewById(R.id.textView_title1);
        title2_TV = findViewById(R.id.textView_title2);

        //-----------------------------Spinner---------------------------\\
        spinnerOil = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerOil = findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(this, R.array.oleje, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOil.setAdapter(adapterCompany);
        spinnerOil.setOnItemSelectedListener(this);
        final Object Company = spinnerOil.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.olejeUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();

        //-----------------------------TextEdit---------------------------\\
        amount_ET = findViewById(R.id.editText_amount);
        density_ET = findViewById(R.id.editText_density);
        //-----------------------------Linear-Layout---------------------------\\


        //-----------------------------Button---------------------------\\
        calc_btn = findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String valueFromET = amount_ET.getText().toString();

                String valueFromDensityET = density_ET.getText().toString();


                if (!valueFromET.isEmpty()) {
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }


                //------------------------------OLEUM-RAPE----------------------------\\
                if (companyChoice == 1){
                    textView_oilMain.setText("Oleum rapae");


                    if (!valueFromDensityET.isEmpty()) {
                        density = Double.parseDouble(valueFromDensityET);
                    } else {
                        density = 0.917;
                    }

                    textView_oilMain2.setText("(" + density + " g/ml)");

                    //-------------------------------GRAM-----------------------------\\
                    if (unitChoice == 1){

                        grams = amount;

                        volume = grams / density;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2){

                        volume = amount;

                        grams = volume * density;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");
                }

                //-----------------------------OLEUM-RICINI---------------------------\\
                if (companyChoice == 2){

                    textView_oilMain.setText("Oleum Ricini");

                    density = 0.98;
                    if (!valueFromDensityET.isEmpty()) {
                        density = Double.parseDouble(valueFromDensityET);
                    } else {
                        density = 0.98;
                    }
                    textView_oilMain2.setText("(" + density + " g/ml)");

                    //-------------------------------GRAM-----------------------------\\
                    if (unitChoice == 1){

                        grams = amount;

                        volume = grams / density;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2){

                        volume = amount;

                        grams = volume * density;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");
                }
            }
        });

    }


    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner spinnerCompany = (Spinner) parent;
        Spinner spinnerUnit = (Spinner) parent;

        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();

            if (Company.contains("Rapae")) {
                companyChoice = 1;

                density_ET.setHint("0.917 g/ml");

            }

            if (Company.contains("Ricini")) {
                companyChoice = 2;

                density_ET.setHint("0.98 g/ml");
            }

        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }

            if (Unit.contains("ml")) {
                unitChoice = 2;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(View view) {
        Intent intent = new Intent(olejeActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
