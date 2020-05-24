package com.jakubolszewski.kalkulatorrecepturowy;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView feedback_TV;

    String change1 = "-Naprawiono obliczenia do olejki";
    String change2 = "-Dodano zakładke \"Informacje\"";
    String change3 = "-Dodano obliczenia do witaminy A + D3";
    String change4 = "-Dodano powiadomienia";

    String feedback= "Znalazłeś błąd lub chcesz zasugerować zmainę, \nkliknij TUTAJ.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        feedback_TV = findViewById(R.id.report);

        //ANNOTATION feedback
        SpannableString spannableString_feedback = new SpannableString(feedback);
        ClickableSpan clickableSpan_feedback = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                moveToFeedbackActivity();
            }
        };

        spannableString_feedback.setSpan(clickableSpan_feedback,55,60, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        feedback_TV.setText(spannableString_feedback);
        feedback_TV.setMovementMethod(LinkMovementMethod.getInstance());


    }

    private void moveToFeedbackActivity() {
        Intent intent = new Intent(InfoActivity.this, feedbackActivity.class);
        startActivity(intent);
    }

    public void changeLog(View view) {

        new AlertDialog.Builder(InfoActivity.this)
                .setTitle("Ostatnio dodano:")
                .setMessage(change1 + "\n\n"
                        + change2 + "\n\n"
                        + change3 + "\n\n"
                        + change4)
                .show();

    }

    public void goBack(View view) {
        Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
