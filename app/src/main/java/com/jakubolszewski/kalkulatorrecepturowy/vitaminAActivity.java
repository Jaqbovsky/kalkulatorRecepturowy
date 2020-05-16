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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class vitaminAActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double  amount;
    double volumeHasco, dropsHasco, massUnitHasco, gramsHasco;
    double volumeMedana, dropsMedana, massUnitMedana, gramsMedana;
    double volumeFagron, dropsFagron, massUnitFagron, gramsFagron;
    //-----------------------------text-variables---------------------------\\
    String Company, Unit, Hasco, Medana, Fargon, gram, jm;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV, calculation4_TV;
    TextView calculation5_TV, calculation6_TV, calculation7_TV, calculation8_TV;
    TextView calculation9_TV,calculation10_TV, calculation11_TV, calculation12_TV;
    TextView textView_text1, textView_text2, textView_text3, textView_text4, textView_text5, textView_text6;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV, title4_TV;
    TextView title5_TV, title6_TV, title7_TV, title8_TV;
    TextView title9_TV, title10_TV, title11_TV, title12_TV;
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
        textView_vitMain2 = findViewById(R.id.textView_mainVit2);

        title1_TV = findViewById(R.id.textView_title1);
        title2_TV = findViewById(R.id.textView_title2);
        title3_TV = findViewById(R.id.textView_title3);
        title4_TV = findViewById(R.id.textView_title4);
        title5_TV = findViewById(R.id.textView_title5);
        title6_TV = findViewById(R.id.textView_title6);
        title7_TV = findViewById(R.id.textView_title7);
        title8_TV = findViewById(R.id.textView_title8);
        title9_TV = findViewById(R.id.textView_title9);
        title10_TV = findViewById(R.id.textView_title10);
        title11_TV = findViewById(R.id.textView_title11);
        title12_TV = findViewById(R.id.textView_title12);

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
                    amount = Double.parseDouble(valueFromET);
                } else {
                    amount_ET.setError("To pole jest wymagane");
                }
                //-----------------------------HASCO---------------------------\\
                if (companyChoice == 1) {

                    textView_vitMain.setText("Vit. A Hasco");
                    textView_vitMain2.setText("(1.148 g/ml)");
                    textView_text3.setText("Vit. A Medana");
                    textView_text4.setText("(1.08 g/ml)");
                    textView_text5.setText("Vit. A Fagron ");
                    textView_text6.setText("(Roztwór pomocniczy)");
                    title10_TV.setVisibility(View.GONE);
                    calculation10_TV.setVisibility(View.GONE);

                    String test = String.valueOf(volumeHasco);


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

                    if (unitChoice == 2) {
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

                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice ==3){

                        volumeHasco = amount;

                        massUnitHasco = volumeHasco * 45000;

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

                    volumeMedana = massUnitHasco / 50000;

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
                    textView_text3.setText("Vit. A Medana");

                    //-----------------------------A-Hasco-na-A-Fagron---------------------------\\

                    massUnitFagron = massUnitHasco;

                    dropsFagron = massUnitFagron / 10000;
                    gramsFagron = dropsFagron * 0.034;
                    volumeFagron = 0; //nie znamy gęstości. Brak mililitrów.

                    dropsFagron = Math.round(dropsFagron);

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");
                    String massUnitFagron_String = String.valueOf(massUnitFagron).replace(".0", "");

                    calculation9_TV.setText(gramsFagron + " g");
                    calculation11_TV.setText(dropsFagron_String + " kropli");
                    calculation12_TV.setText(massUnitFagron_String + " j.m.");


                }
                //-----------------------------MEDANA---------------------------\\
                if (companyChoice == 2) {
                    textView_vitMain.setText("Vit. A Medana");
                    textView_vitMain2.setText("(1.08 g/ml)");
                    textView_text3.setText("Vit. A Hasco");
                    textView_text4.setText("(1.148 g/ml)");
                    textView_text5.setText("Vit. A Fagron ");
                    textView_text6.setText("(Roztwór pomocniczy)");
                    title10_TV.setVisibility(View.GONE);
                    calculation10_TV.setVisibility(View.GONE);

                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        gramsMedana = amount;

                        volumeMedana = gramsMedana / 1.08;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        dropsMedana = volumeMedana * 30;

                        massUnitMedana = volumeMedana * 50000;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");

                    }

                    //-----------------------------J.M.---------------------------\\
                    if (unitChoice == 2) {

                        massUnitMedana = amount;

                        volumeMedana = massUnitMedana / 50000;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        gramsMedana = volumeMedana * 1.08;
                        dropsMedana = volumeMedana * 30;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");
                    }
                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice ==3){

                        volumeMedana = amount;

                        gramsMedana = volumeMedana * 1.08;
                        dropsMedana = volumeMedana * 30;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        massUnitMedana = Math.round(massUnitMedana);

                        String drops_String = String.valueOf(dropsMedana).replace(".0", "");
                        String massUnit_String = String.valueOf(massUnitMedana).replace(".0", "");

                        calculation4_TV.setText(gramsMedana + " g");
                        calculation1_TV.setText(volumeMedana + " ml");
                        calculation2_TV.setText(drops_String + " kropli");
                        calculation3_TV.setText(massUnit_String + " j.m.");

                    }

                    //-----------------------------A-Medana-na-A-Hasco---------------------------\\

                    massUnitHasco = massUnitMedana;

                    volumeHasco = massUnitHasco / 45000;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 1.148;
                    dropsHasco = volumeHasco * 28;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");
                    String massUnitHasco_String = String.valueOf(massUnitHasco).replace(".0", "");

                    calculation5_TV.setText(gramsHasco + " g");
                    calculation6_TV.setText(volumeHasco + " ml");
                    calculation7_TV.setText(dropsHasco_String + " kropli");
                    calculation8_TV.setText(massUnitHasco_String + " j.m.");

                    //-----------------------------A-Medana-na-A-Fagron---------------------------\\
                    massUnitFagron = massUnitMedana;

                    dropsFagron = massUnitFagron / 10000;
                    gramsFagron = dropsFagron * 0.034;
                    volumeFagron = 0; //nie znamy gęstości. Brak mililitrów.

                    dropsFagron = Math.round(dropsFagron);

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");
                    String massUnitFagron_String = String.valueOf(massUnitFagron).replace(".0", "");

                    calculation9_TV.setText(gramsFagron + " g");
                    calculation11_TV.setText(dropsFagron_String + " kropli");
                    calculation12_TV.setText(massUnitFagron_String + " j.m.");

                }

                //-----------------------------FAGRON---------------------------\\
                if (companyChoice == 3) {
                    textView_vitMain.setText("Vit. A Fagron");
                    textView_vitMain2.setText("(roztwór pomocniczy)");
                    textView_text3.setText("Vit. A Hasco");
                    textView_text4.setText("(1.148 g/ml)");
                    textView_text5.setText("Vit. A Medana");
                    textView_text6.setText("(1.08 g/ml)");
                    title10_TV.setVisibility(View.VISIBLE);
                    calculation10_TV.setVisibility(View.VISIBLE);

                    if (unitChoice == 1) {

                        new AlertDialog.Builder(vitaminAActivity.this)
                                .setTitle("Błąd")
                                .setMessage("Zmień na jednostki masy (j.m.)")
                                .show();

                    }

                    if (unitChoice == 2) {

                        massUnitFagron = amount;

                        dropsFagron = massUnitFagron / 10000;
                        gramsFagron = dropsFagron * 0.034;

                        gramsFagron *= 100;
                        gramsFagron = Math.round(gramsFagron);
                        gramsFagron /= 100;

                        dropsFagron = Math.round(dropsFagron);
                        String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                        calculation4_TV.setText(gramsFagron + " g");
                        calculation2_TV.setText(dropsFagron_String + " kropli");
                        calculation3_TV.setText(massUnitFagron + " j.m.");

                        massUnitHasco = massUnitFagron;

                        volumeHasco = massUnitHasco / 45000;

                        volumeHasco *= 100;
                        volumeHasco = Math.round(volumeHasco);
                        volumeHasco /= 100;

                        dropsHasco = volumeHasco * 28;
                        gramsHasco = volumeHasco * 1.148;

                        gramsHasco *= 100;
                        gramsHasco = Math.round(gramsHasco);
                        gramsHasco /= 100;

                        dropsHasco = Math.round(dropsHasco);
                        String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                        calculation5_TV.setText(gramsHasco + " g");
                        calculation6_TV.setText(volumeHasco + " ml");
                        calculation7_TV.setText(dropsHasco_String + " kropli");
                        calculation8_TV.setText(massUnitHasco + " j.m.");

                        massUnitMedana = massUnitFagron;

                        volumeMedana = massUnitMedana / 50000;

                        volumeMedana *= 100;
                        volumeMedana = Math.round(volumeMedana);
                        volumeMedana /= 100;

                        dropsMedana = volumeMedana * 30;
                        gramsMedana = volumeMedana * 1.08;

                        gramsMedana *= 100;
                        gramsMedana = Math.round(gramsMedana);
                        gramsMedana /= 100;

                        dropsMedana = Math.round(dropsMedana);
                        String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                        calculation9_TV.setText(gramsMedana + " g");
                        calculation10_TV.setText(volumeMedana + " ml");
                        calculation11_TV.setText(dropsMedana_String + " kropli");
                        calculation12_TV.setText(massUnitMedana + " j.m.");


                    }
                    //-----------------------------mililitr---------------------------\\
                    if (unitChoice ==3){

                        new AlertDialog.Builder(vitaminAActivity.this)
                                .setTitle("Błąd")
                                .setMessage("Zmień na jednostki masy (j.m.)")
                                .show();

                    }

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
            if (Unit.contains("ml")){
                unitChoice = 3;
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
