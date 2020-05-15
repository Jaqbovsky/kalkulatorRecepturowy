package com.jakubolszewski.kalkulatorrecepturowy;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class vitaminAActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int amount, companyChoice, unitChoice;

    double volumeHasco, dropsHasco, massUnitHasco, gramsHasco;
    double volumeMedana, dropsMedana, massUnitMedana, gramsMedana;
    //-----------------------------text-variables---------------------------\\
    String Company, Unit, Hasco, Medana, Fargon, gram, jm;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV, calculation4_TV;
    TextView calculation5_TV, calculation6_TV, calculation7_TV, calculation8_TV;
    TextView calculation9_TV, calculation10_TV, calculation11_TV, calculation12_TV;
    TextView textView_text1, textView_text2 , textView_text3, textView_text4, textView_text5, textView_text6;
    TextView textView_vitMain;
    LinearLayout linearLayout1, linearLayout2;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_a);

        spinnerCompany = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

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
        calculation4_TV = findViewById(R.id.textView_calculation4);
        calculation5_TV = findViewById(R.id.textView_calculation5);
        calculation6_TV = findViewById(R.id.textView_calculation6);
        calculation7_TV = findViewById(R.id.textView_calculation7);
        calculation8_TV = findViewById(R.id.textView_calculation8);
        calculation9_TV = findViewById(R.id.textView_calculation9);
        calculation10_TV = findViewById(R.id.textView_calculation10);
        calculation11_TV = findViewById(R.id.textView_calculation11);
        calculation12_TV = findViewById(R.id.textView_calculation12);

        textView_text1 = findViewById(R.id.textView_text1);
        textView_text2 = findViewById(R.id.textView_text2);
        textView_text3 = findViewById(R.id.textView_text3);
        textView_text4 = findViewById(R.id.textView_text4);
        textView_text5 = findViewById(R.id.textView_text5);
        textView_text6 = findViewById(R.id.textView_text6);

        textView_vitMain = findViewById(R.id.textView_mainVit);



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
                    amount = Integer.parseInt(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }
                //-----------------------------HASCO---------------------------\\
                if (companyChoice == 1) {

                    textView_vitMain.setText("Vit A Hasco");
                    textView_text3.setText("Vit A Medana");
                    textView_text5.setText("Vit A Fargon");

                    String test = String.valueOf(volumeHasco);

                    Toast.makeText(vitaminAActivity.this, test, Toast.LENGTH_SHORT).show();
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {
                        gramsHasco = amount;

                        volumeHasco = gramsHasco / 1.148;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        massUnitHasco = volumeHasco * 45000;

                        dropsHasco = Math.round(dropsHasco);
                        String drops_String = String.valueOf(dropsHasco);
                        drops_String = drops_String.replace(".0", "");

                        massUnitHasco = Math.round(massUnitHasco);
                        String massUnit_String = String.valueOf(massUnitHasco).replace(".0", "");

                        calculation1_TV.setText(volumeHasco + "ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                        calculation4_TV.setText(gramsHasco + "g");
                        
                    }
                    //-----------------------------J.M.---------------------------\\

                    if (unitChoice == 2){
                        massUnitHasco = amount;

                        volumeHasco = massUnitHasco / 45000;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        gramsHasco = volumeHasco * 1.148;

                        dropsHasco = Math.round(dropsHasco);
                        String drops_String = String.valueOf(dropsHasco).replace(".0", "");

                        massUnitHasco = Math.round(massUnitHasco);
                        String massUnit_String = String.valueOf(massUnitHasco).replace(".0", "");

                        gramsHasco *= 100;
                        gramsHasco = Math.round(gramsHasco);
                        gramsHasco /= 100;

                        calculation1_TV.setText(volumeHasco + "ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                        calculation4_TV.setText(gramsHasco + "g");

                    }
                    //-----------------------------A-Hasco-na-A-Medana---------------------------\\
                    massUnitMedana = massUnitHasco;

                    volumeMedana = massUnitHasco/50000;

                    volumeMedana *= 100;
                    volumeMedana = Math.round(volumeMedana);
                    volumeMedana /= 100;

                    dropsMedana = volumeMedana * 30;
                    gramsMedana = volumeMedana * 1.08;

                    gramsMedana *= 100;
                    gramsMedana = Math.round(gramsMedana);
                    gramsMedana /= 100;

                    dropsMedana = Math.round(dropsMedana);
                    String drops_String = String.valueOf(dropsMedana).replace(".0", "");

                    massUnitHasco = Math.round(massUnitMedana);
                    String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                    calculation5_TV.setText(gramsMedana + " g");
                    calculation6_TV.setText(volumeMedana + " ml");
                    calculation7_TV.setText(drops_String + " kropli");
                    calculation8_TV.setText(massUnit_String + " j.m.");
                    textView_text3.setText("Vit A Medana");

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

    public void goBack(View view) {
        Intent intent = new Intent(vitaminAActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
