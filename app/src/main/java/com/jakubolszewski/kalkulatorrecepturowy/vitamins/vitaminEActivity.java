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

public class vitaminEActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double amount;
    double volumeHasco, dropsHasco, gramsHasco;
    double volumeMedana, dropsMedana, gramsMedana;
    double volumeFagron, dropsFagron, gramsFagron;

    //-----------------------------text-variables---------------------------\\
    String Company;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerCompany;
    TextView calculation1_TV, calculation2_TV, calculation3_TV;
    TextView calculation4_TV, calculation5_TV, calculation6_TV;
    TextView calculation7_TV, calculation8_TV, calculation9_TV;
    TextView textView_text1, textView_text2, textView_text3, textView_text4, textView_text5, textView_text6;
    TextView textView_vitMain, textView_vitMain2;
    TextView title1_TV, title2_TV, title3_TV;
    TextView title4_TV, title5_TV, title6_TV;
    TextView title7_TV, title8_TV, title9_TV;
    LinearLayout linearLayout1, linearLayout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_e);

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

        //-----------------------------Spinner---------------------------\\
        spinnerCompany = findViewById(R.id.spinner_Company);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerCompany = findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(this, R.array.companySpinner_vit_E, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(adapterCompany);
        spinnerCompany.setOnItemSelectedListener(this);
        final Object Company = spinnerCompany.getSelectedItem();

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

                //------------------------------FAGRON-GRAMY-----------------------------\\
                if (companyChoice == 1) {

                    textView_vitMain.setText("Vit. E Fagron");
                    textView_vitMain2.setText("(0.945 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Medana");
                    textView_text6.setText("(0.93 g/ml)");

                    gramsFagron = amount;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation1_TV.setText(gramsFagron + " g");
                    calculation2_TV.setText(volumeFagron + " ml");
                    calculation3_TV.setText(dropsFagron_String + " kropli");

                    //------------------------------FAGRON-GRAMY-NA-HASCO-----------------------------\\

                    volumeHasco = gramsFagron / 0.3;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;
                    dropsMedana = dropsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation7_TV.setText(gramsMedana + " g");
                    calculation8_TV.setText(volumeMedana + " ml");
                    calculation9_TV.setText(dropsMedana_String + " kropli");

                }

                //------------------------------MEDANA-GRAMY-----------------------------\\
                if (companyChoice == 2) {

                    textView_vitMain.setText("Vit. E Medana");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    gramsMedana = amount;

                    volumeMedana = gramsMedana / 0.93;

                    volumeMedana *= 100;
                    volumeMedana = Math.round(volumeMedana);
                    volumeMedana /= 100;

                    dropsMedana = volumeMedana * 30;

                    dropsMedana = Math.round(dropsMedana);

                    String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                    calculation1_TV.setText(gramsMedana + " g");
                    calculation2_TV.setText(volumeMedana + " ml");
                    calculation3_TV.setText(dropsMedana_String + " kropli");


                    //------------------------------MEDANA-GRAMY-NA-HASCO-----------------------------\\
                    volumeHasco = volumeMedana;
                    gramsHasco = gramsMedana;

                    String dropsHasco_String = dropsMedana_String;

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeMedana * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");


                }

                //-----------------------------MEDANA-MILITRY----------------------------\\
                if (companyChoice == 3) {

                    textView_vitMain.setText("Vit. E Medana");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    volumeMedana = amount;

                    gramsMedana = volumeMedana * 0.93;

                    gramsMedana *= 100;
                    gramsMedana = Math.round(gramsMedana);
                    gramsMedana /= 100;

                    dropsMedana = volumeMedana * 30;
                    String dropsMedana_String = String.valueOf(dropsMedana).replace(".0", "");

                    calculation1_TV.setText(gramsMedana + " g");
                    calculation2_TV.setText(volumeMedana + " ml");
                    calculation3_TV.setText(dropsMedana_String + " kropli");

                    //------------------------------MEDANA-GRAMY-NA-HASCO-----------------------------\\
                    volumeHasco = volumeMedana;
                    gramsHasco = gramsMedana;

                    String dropsHasco_String = dropsMedana_String;

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeMedana * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");
                }

                //-------------------------------HASCO-GRAMY-----------------------------\\
                if (companyChoice == 4) {

                    textView_vitMain.setText("Vit. E Hasco");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Medana");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    gramsHasco = amount;

                    volumeHasco = gramsHasco / 0.93;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation1_TV.setText(gramsHasco + " g");
                    calculation2_TV.setText(volumeHasco + " ml");
                    calculation3_TV.setText(dropsHasco_String);


                    //------------------------------HASCO-GRAMY-NA-MEDANA-----------------------------\\
                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation4_TV.setText(gramsMedana + " g");
                    calculation5_TV.setText(volumeMedana + " ml");
                    calculation6_TV.setText(dropsMedana_String + " kropli");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\

                    gramsFagron = volumeMedana * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                }

                //-----------------------------HASCO-MILILITRY---------------------------\\
                if (companyChoice == 5) {

                    textView_vitMain.setText("Vit. E Hasco");
                    textView_vitMain2.setText("(0.93 g/ml)");

                    textView_text3.setText("Vit. E Medana");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Fagron");
                    textView_text6.setText("(0.945 g/ml)");

                    volumeHasco = amount;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;
                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation1_TV.setText(gramsHasco + " g");
                    calculation2_TV.setText(volumeHasco + " ml");
                    calculation3_TV.setText(dropsHasco_String + " kropli");

                    //------------------------------HASCO-MILITRY-NA-MEDANA-----------------------------\\
                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation4_TV.setText(gramsMedana + " g");
                    calculation5_TV.setText(volumeMedana + " ml");
                    calculation6_TV.setText(dropsMedana_String + " kropli");

                    //------------------------------MEDANA-GRAMY-NA-FAGRON-----------------------------\\
                    gramsFagron = volumeHasco * 0.3;

                    gramsFagron *= 100;
                    gramsFagron = Math.round(gramsFagron);
                    gramsFagron /= 100;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation7_TV.setText(gramsFagron + " g");
                    calculation8_TV.setText(volumeFagron + " ml");
                    calculation9_TV.setText(dropsFagron_String + " kropli");

                }

                //---------------------------------E-GRAMY-------------------------------\\
                if (companyChoice == 6) {
                    textView_vitMain.setText("Vit. E Fagron");
                    textView_vitMain2.setText("(0.945 g/ml)");

                    textView_text3.setText("Vit. E Hasco");
                    textView_text4.setText("(0.93 g/ml)");

                    textView_text5.setText("Vit. E Medana");
                    textView_text6.setText("(0.93 g/ml)");

                    gramsFagron = amount;

                    volumeFagron = gramsFagron / 0.945;

                    volumeFagron *= 100;
                    volumeFagron = Math.round(volumeFagron);
                    volumeFagron /= 100;

                    dropsFagron = gramsFagron / 0.0331;

                    dropsFagron = Math.round(dropsFagron);
                    String dropsFagron_String = String.valueOf(dropsFagron).replace(".0", "");

                    calculation1_TV.setText(gramsFagron + " g");
                    calculation2_TV.setText(volumeFagron + " ml");
                    calculation3_TV.setText(dropsFagron_String + " kropli");

                    //------------------------------FAGRON-GRAMY-NA-HASCO-----------------------------\\

                    volumeHasco = gramsFagron / 0.3;

                    volumeHasco *= 100;
                    volumeHasco = Math.round(volumeHasco);
                    volumeHasco /= 100;

                    gramsHasco = volumeHasco * 0.93;

                    gramsHasco *= 100;
                    gramsHasco = Math.round(gramsHasco);
                    gramsHasco /= 100;

                    dropsHasco = volumeHasco * 30;

                    dropsHasco = Math.round(dropsHasco);

                    String dropsHasco_String = String.valueOf(dropsHasco).replace(".0", "");

                    calculation4_TV.setText(gramsHasco + " g");
                    calculation5_TV.setText(volumeHasco + " ml");
                    calculation6_TV.setText(dropsHasco_String + " kropli");

                    volumeMedana = volumeHasco;
                    gramsMedana = gramsHasco;
                    dropsMedana = dropsHasco;

                    String dropsMedana_String = dropsHasco_String;

                    calculation7_TV.setText(gramsMedana + " g");
                    calculation8_TV.setText(volumeMedana + " ml");
                    calculation9_TV.setText(dropsMedana_String + " kropli");
                }

            }
        });


    }

    //SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinnerCompany = (Spinner) parent;

        if (spinnerCompany.getId() == R.id.spinner_Company) {
            Company = parent.getItemAtPosition(position).toString();

            if (Company.contains("Vit. E Fagron (g)")) {
                companyChoice = 1;
            }
            if (Company.contains("Vit. E Medana liq (g)")) {
                companyChoice = 2;
            }
            if (Company.contains("Vit. E Medana liq (ml)")) {
                companyChoice = 3;
            }
            if (Company.contains("Vit. E Hasco liq (g)")) {
                companyChoice = 4;
            }
            if (Company.contains("Vit. E Hasco liq (ml)")) {
                companyChoice = 5;
            }
            if (Company.contains("Vit. E (g)")) {
                companyChoice = 6;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(View view) {
        Intent intent = new Intent(vitaminEActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
