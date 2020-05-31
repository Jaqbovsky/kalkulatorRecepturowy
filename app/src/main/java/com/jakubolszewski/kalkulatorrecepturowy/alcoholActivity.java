package com.jakubolszewski.kalkulatorrecepturowy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class alcoholActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int selectedTypeOf, concentrationValue;

    double possessedConcentration, howMuchToRecive, outcome, outcomeWater, concentrationValueDegree;

    //-----------------------------text-variables---------------------------\\
    String selectedConcentration, typeOfConcentration;

    //-----------------------------layouts-elements---------------------------\\
    Spinner concentrationSpinner, selectTypeOfConcentrationSpinner;
    EditText concentrationValue_ET, howMuchToRecive_ET;
    TextView alcohol_TV, water_TV;
    Button calc_btn;

    HashMap<String, Double> hMConcentration = new HashMap<String, Double>();
    HashMap<Integer, Double> hMDegree = new HashMap<Integer, Double>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol);

        //-----------------------------hashMap---------------------------\\
        hMConcentration.put("96.9° (95.16 m/m)", 95.16);
        hMConcentration.put("96.8° (95.01 m/m)", 95.01);
        hMConcentration.put("96.7° (94.86 m/m)", 94.86);
        hMConcentration.put("96.6° (94.71 m/m)", 94.71);
        hMConcentration.put("96.5° (94.57 m/m)", 94.57);
        hMConcentration.put("96.4° (94.42 m/m)", 94.42);
        hMConcentration.put("96.3° (94.27 m/m)", 94.27);
        hMConcentration.put("96.2° (94.13 m/m)", 94.13);
        hMConcentration.put("96.1° (93.98 m/m)", 93.98);
        hMConcentration.put("96° (93.84 m/m)", 93.84);
        hMConcentration.put("95.9° (93.69 m/m)", 93.69);
        hMConcentration.put("95.8° (93.55 m/m)", 93.55);
        hMConcentration.put("95.7° (93.41 m/m)", 93.41);
        hMConcentration.put("95.6° (93.26 m/m)", 93.26);
        hMConcentration.put("95.5° (93.12 m/m)", 93.12);
        hMConcentration.put("95.4° (92.98 m/m)", 92.98);
        hMConcentration.put("95.3° (92.83 m/m)", 92.83);
        hMConcentration.put("95.2° (92.69 m/m)", 92.69);
        hMConcentration.put("95.1° (92.55 m/m)", 92.55);
        hMConcentration.put("70.6° (63.03 m/m)", 63.23);
        hMConcentration.put("70.5° (62.92 m/m)", 62.92);
        hMConcentration.put("70.4° (62.81 m/m)", 62.81);
        hMConcentration.put("70.3° (62.71 m/m)", 62.71);
        hMConcentration.put("70.2° (62.6 m/m)", 62.6);
        hMConcentration.put("70° (62.39 m/m)", 62.39);
        hMConcentration.put("69.9° (62.28 m/m)", 62.28);
        hMConcentration.put("69.8° (62.17 m/m)", 62.17);

        //-----------------------------hashMap---------------------------\\
        hMDegree.put(1, 0.86);
        hMDegree.put(2, 1.61);
        hMDegree.put(3, 2.39);
        hMDegree.put(4, 3.18);
        hMDegree.put(5, 3.99);
        hMDegree.put(6, 4.84);
        hMDegree.put(7, 5.89);
        hMDegree.put(8, 6.49);
        hMDegree.put(9, 7.28);
        hMDegree.put(10, 8.09);
        hMDegree.put(11, 8.90);
        hMDegree.put(12, 9.73);
        hMDegree.put(13, 10.58);
        hMDegree.put(14, 11.30);
        hMDegree.put(15, 12.18);
        hMDegree.put(16, 12.91);
        hMDegree.put(17, 13.82);
        hMDegree.put(18, 14.59);
        hMDegree.put(19, 15.53);
        hMDegree.put(20, 16.31);
        hMDegree.put(21, 17.09);
        hMDegree.put(22, 18.01);
        hMDegree.put(23, 18.76);
        hMDegree.put(24, 19.67);
        hMDegree.put(25, 20.41);
        hMDegree.put(26, 21.30);
        hMDegree.put(27, 22.16);
        hMDegree.put(28, 23.03);
        hMDegree.put(29, 23.88);
        hMDegree.put(30, 24.72);
        hMDegree.put(31, 25.53);
        hMDegree.put(32, 36.33);
        hMDegree.put(33, 27.24);
        hMDegree.put(34, 28.12);
        hMDegree.put(35, 28.99);
        hMDegree.put(36, 29.83);
        hMDegree.put(37, 30.65);
        hMDegree.put(38, 31.58);
        hMDegree.put(39, 32.49);
        hMDegree.put(40, 33.38);
        hMDegree.put(41, 34.26);
        hMDegree.put(42, 35.12);
        hMDegree.put(43, 36.07);
        hMDegree.put(44, 36.90);
        hMDegree.put(45, 37.82);
        hMDegree.put(46, 38.72);
        hMDegree.put(47, 39.72);
        hMDegree.put(48, 40.61);
        hMDegree.put(49, 41.58);
        hMDegree.put(50, 42.44);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);
        hMDegree.put(,);



        //-----------------------------textview---------------------------\\
        alcohol_TV = findViewById(R.id.textView_alcohol);
        water_TV = findViewById(R.id.textView_water);

        //-----------------------------Spinner---------------------------\\
        concentrationSpinner = findViewById(R.id.spinner_concentration);
        selectTypeOfConcentrationSpinner = findViewById(R.id.spinner_select_concentration);

        //-----------------------------Spinner---------------------------\\
        Spinner selectTypeOfConcentrationSpinner = findViewById(R.id.spinner_select_concentration);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(this, R.array.type_of_concentration, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectTypeOfConcentrationSpinner.setAdapter(adapterCompany);
        selectTypeOfConcentrationSpinner.setOnItemSelectedListener(this);

        //-----------------------------Spinner---------------------------\\
        Spinner concentrationSpinner = findViewById(R.id.spinner_concentration);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.concentration, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        concentrationSpinner.setAdapter(adapter);
        concentrationSpinner.setOnItemSelectedListener(this);

        //-----------------------------Edittext---------------------------\\
        concentrationValue_ET = findViewById(R.id.editText_concentration_value);
        howMuchToRecive_ET = findViewById(R.id.editText_how_much);

        //------------------------------Button---------------------------\\
        calc_btn = findViewById(R.id.button_calc);

        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String concentrationValue_ET_value = concentrationValue_ET.getText().toString();
                final String howMuchToRecive_ET_value = howMuchToRecive_ET.getText().toString();

                if (!concentrationValue_ET_value.isEmpty()) {
                    concentrationValue = Integer.parseInt(concentrationValue_ET_value);
                } else {
                    concentrationValue_ET.setError("To pole jest wymagane");
                }

                if (!howMuchToRecive_ET_value.isEmpty()) {
                    howMuchToRecive = Double.parseDouble(howMuchToRecive_ET_value);
                } else {
                    howMuchToRecive_ET.setError("To pole jest wymagane");
                }


                //------------------------------v/v---------------------------\\
                if (selectedTypeOf == 1) {

                    possessedConcentration = hMConcentration.get(selectedConcentration);

                    concentrationValueDegree = hMDegree.get(concentrationValue);

                    outcome = howMuchToRecive * concentrationValueDegree / possessedConcentration;

                    outcome *= 100;
                    outcome = Math.round(outcome);
                    outcome /= 100;

                    outcomeWater = howMuchToRecive - outcome;

                    outcomeWater *= 100;
                    outcomeWater = Math.round(outcomeWater);
                    outcomeWater /= 100;

                    alcohol_TV.setText("- " + outcome + " g etanolu");
                    water_TV.setText("- " + outcomeWater + " g wody");
                }

                //------------------------------m/m---------------------------\\
                if (selectedTypeOf == 2) {

                    possessedConcentration = hMConcentration.get(selectedConcentration);

                    outcome = howMuchToRecive * concentrationValue / possessedConcentration;

                    outcome *= 100;
                    outcome = Math.round(outcome);
                    outcome /= 100;

                    outcomeWater = howMuchToRecive - outcome;

                    outcomeWater *= 100;
                    outcomeWater = Math.round(outcomeWater);
                    outcomeWater /= 100;

                    alcohol_TV.setText("- " + outcome + " g etanolu");
                    water_TV.setText("- " + outcomeWater + " g wody");

                }




            }
        });

    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String value1, value2;

        Spinner selectTypeOfConcentrationSpinner = (Spinner) parent;
        Spinner concentrationSpinner = (Spinner) parent;

        if (selectTypeOfConcentrationSpinner.getId() == R.id.spinner_select_concentration) {
            typeOfConcentration = parent.getItemAtPosition(position).toString();

            if (typeOfConcentration.contains("v/v")) {
                selectedTypeOf = 1;
            }

            if (typeOfConcentration.contains("m/m")) {
                selectedTypeOf = 2;
            }

        }
        if (concentrationSpinner.getId() == R.id.spinner_concentration) {
            selectedConcentration = parent.getItemAtPosition(position).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(View view) {
        Intent intent = new Intent(alcoholActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
