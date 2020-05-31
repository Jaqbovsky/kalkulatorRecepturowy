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

public class olejkiActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //-----------------------------numeric-variables---------------------------\\
    int companyChoice, unitChoice;

    double amount;
    double volume, grams, drops;

    //-----------------------------text-variables---------------------------\\
    String Company, Unit;

    //-----------------------------layouts-elements---------------------------\\
    EditText amount_ET;
    Button calc_btn;
    Spinner spinnerOil, spinnerUnit;
    TextView calculation1_TV, calculation2_TV, calculation3_TV;
    TextView textView_oilMain, textView_oilMain2;
    TextView title1_TV, title2_TV, title3_TV;
    LinearLayout linearLayout1, linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olejki);

        //-----------------------------textview---------------------------\\
        calculation1_TV = findViewById(R.id.textView_calculation1);
        calculation2_TV = findViewById(R.id.textView_calculation2);
        calculation3_TV = findViewById(R.id.textView_calculation3);

        textView_oilMain = findViewById(R.id.textView_mainOil);
        textView_oilMain2 = findViewById(R.id.textView_mainOil2);

        title1_TV = findViewById(R.id.textView_title1);
        title2_TV = findViewById(R.id.textView_title2);
        title3_TV = findViewById(R.id.textView_title3);

        //-----------------------------Spinner---------------------------\\
        spinnerOil = findViewById(R.id.spinner_Company);
        spinnerUnit = findViewById(R.id.spinner_unit);

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerOil = findViewById(R.id.spinner_Company);
        ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(this, R.array.olejki, android.R.layout.simple_spinner_item);
        adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOil.setAdapter(adapterCompany);
        spinnerOil.setOnItemSelectedListener(this);
        final Object Company = spinnerOil.getSelectedItem();

        //-----------------------------Spinner---------------------------\\
        Spinner spinnerUnit = findViewById(R.id.spinner_unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.olejkiUnit, android.R.layout.simple_spinner_item);
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


                /*
                 *
                 * Olejek miętowy
                 * - masa kropli: 0.019g
                 * - gęstość: 0.9026 g/ml
                 *
                 * Olejek lawendowy
                 * -masa kropli: 0.019g
                 * -gęstość: 0.8855 g/ml;
                 *
                 * Olejek eukaliptusowy
                 * - masa kropli:
                 * -gęstość:
                 *
                 */


                //-----------------------------OLEJEK-MIĘTOWY---------------------------\\
                if (companyChoice == 1) {

                    textView_oilMain.setText("Olejek miętowy");
                    textView_oilMain2.setText("(0.9026 g/ml)");

                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.9026;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.9026;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.9026;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");

                }

                //-----------------------------OLEJEK-LAWENDOWY---------------------------\\
                if (companyChoice == 2) {
                    textView_oilMain.setText("Olejek lawendowy");
                    textView_oilMain2.setText("(0.8855 g/ml)");
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.8855;
                        drops = grams / 0.019;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.8855;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.8855;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");
                }

                //-----------------------------OLEJEK-EUKALIPTUSOWY---------------------------\\
                if (companyChoice == 3) {
                    textView_oilMain.setText("Olejek eukaliptusowy");
                    textView_oilMain2.setText("(0.885 g/ml)");
                    //-----------------------------GRAM---------------------------\\
                    if (unitChoice == 1) {

                        grams = amount;
                        volume = grams / 0.885;
                        drops = grams / 0.019;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                        drops = Math.round(drops);

                    }

                    //-----------------------------MILILITR---------------------------\\
                    if (unitChoice == 2) {

                        volume = amount;
                        grams = volume * 0.885;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        drops = grams / 0.019;

                        drops = Math.round(drops);

                    }

                    //-----------------------------KROPLE---------------------------\\
                    if (unitChoice == 3) {

                        drops = amount;
                        grams = drops * 0.019;

                        grams *= 100;
                        grams = Math.round(grams);
                        grams /= 100;

                        volume = grams / 0.885;

                        volume *= 100;
                        volume = Math.round(volume);
                        volume /= 100;

                    }

                    calculation1_TV.setText(grams + " g");
                    calculation2_TV.setText(volume + " ml");

                    String drops_String = String.valueOf(drops).replace(".0", "");

                    calculation3_TV.setText(drops_String + " kropli");
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

            if (Company.contains("miętowy")) {
                companyChoice = 1;
            }
            if (Company.contains("lawendowy")) {
                companyChoice = 2;
            }
            if (Company.contains("eukaliptusowy")) {
                companyChoice = 3;
            }

        }
        if (spinnerUnit.getId() == R.id.spinner_unit) {
            Unit = parent.getItemAtPosition(position).toString();

            if (Unit.contains("(g)")) {
                unitChoice = 1;
            }
            if (Unit.contains("(ml)")) {
                unitChoice = 2;
            }
            if (Unit.toLowerCase().contains("krople")) {
                unitChoice = 3;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(View view) {
        Intent intent = new Intent(olejkiActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
