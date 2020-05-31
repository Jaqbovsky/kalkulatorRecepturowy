package com.jakubolszewski.kalkulatorrecepturowy.vitamins;

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

public class vitaminDevicapActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double amount;
    double volume, grams, drops, massUnit;

    //-----------------------------text-variables---------------------------\\
    String Unit;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV, calculation4_TV;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV;
    LinearLayout linearLayout1, linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_devicap);

        //-----------------------------textview---------------------------\\
        calculation1_TV = findViewById(R.id.textView_calculation1);
        calculation2_TV = findViewById(R.id.textView_calculation2);
        calculation3_TV = findViewById(R.id.textView_calculation3);
        calculation4_TV = findViewById(R.id.textView_calculation4);

        textView_vitMain = findViewById(R.id.textView_mainVit);
        textView_vitMain2 = findViewById(R.id.textView_mainVit2);

        title1_TV = findViewById(R.id.textView_title1);
        title2_TV = findViewById(R.id.textView_title2);
        title3_TV = findViewById(R.id.textView_title3);

        //-----------------------------Spinner---------------------------\\
        spinnerOil = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.devicapUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);
        spinnerUnit.setOnItemSelectedListener(this);
        final Object Unit = spinnerUnit.getSelectedItem();
        //-----------------------------TextEdit---------------------------\\
        amount_ET = findViewById(R.id.editText_amount);

        //-----------------------------Linear-Layout---------------------------\\
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);

        linearLayout1.setVisibility(View.GONE);
        linearLayout2.setVisibility(View.GONE);

        //-----------------------------Button---------------------------\\
        calc_btn = findViewById(R.id.button_calc);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String valueFromET = amount_ET.getText().toString();

                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);

                if (!valueFromET.isEmpty()) {
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }

                textView_vitMain.setText("Devicap");
                textView_vitMain2.setText("(1.1 g/ml)");
                //-----------------------------GRAM---------------------------\\
                if (unitChoice == 1) {

                    grams = amount;

                    volume = grams / 1.1;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    drops = volume * 30;

                    drops = Math.round(drops);

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------MILILITR---------------------------\\
                if (unitChoice == 2) {

                    volume = amount;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;

                    drops = volume * 30;

                    drops = Math.round(drops);

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------KROPLE---------------------------\\
                if (unitChoice == 3) {

                    drops = amount;

                    volume = drops / 30;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;

                    massUnit = volume * 15000;

                    massUnit = Math.round(massUnit);

                }

                //-----------------------------J.M.---------------------------\\
                if (unitChoice == 4){

                    massUnit = amount;

                    volume = massUnit / 15000;

                    volume *= 100;
                    volume = Math.round(volume);
                    volume /= 100;

                    grams = volume * 1.1;

                    grams *= 100;
                    grams = Math.round(grams);
                    grams /= 100;
                    
                    drops = volume * 30;

                    drops = Math.round(drops);


                }


                calculation1_TV.setText(grams + " g");
                calculation2_TV.setText(volume + " ml");

                String drops_String = String.valueOf(drops).replace(".0", "");

                calculation3_TV.setText(drops_String + " kropli");

                String massUnit_String = String.valueOf(massUnit).replace(".0", "");

                calculation4_TV.setText(massUnit_String + " j.m.");

            }
        });
    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinnerUnit = (Spinner) parent;

        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("g")) {
                unitChoice = 1;
            }
            if (Unit.contains("ml")) {
                unitChoice = 2;
            }
            if (Unit.contains("Krople")){
                unitChoice = 3;
            }
            if (Unit.contains("j.m.")){
                unitChoice = 4;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(View view) {
        Intent intent = new Intent(vitaminDevicapActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
