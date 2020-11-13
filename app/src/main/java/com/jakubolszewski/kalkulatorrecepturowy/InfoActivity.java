package com.jakubolszewski.kalkulatorrecepturowy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView feedback_TV;

    String change1 = "-dodano obliczenia do spirytusu/etanolu";

    String feedback= "Znalazłeś błąd lub chcesz zasugerować zmainę, \nkliknij TUTAJ.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    }


    public void goBack(View view) {
        Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void moveToFeedback(View view) {
        Intent intent = new Intent(InfoActivity.this, feedbackActivity.class);
        startActivity(intent);
    }

    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "j.olszewski05@gmail.com" });
        startActivity(Intent.createChooser(intent, ""));
    }

    public void openDiscord(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://discord.gg/2UxCgT")));
    }

    public void openLinkedin(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jakub-olszewski-926b4b175")));
    }

}
