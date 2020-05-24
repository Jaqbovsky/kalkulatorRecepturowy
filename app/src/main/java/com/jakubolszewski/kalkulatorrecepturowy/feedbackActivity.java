package com.jakubolszewski.kalkulatorrecepturowy;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.firebase.client.Firebase;
import com.google.android.material.navigation.NavigationView;

public class feedbackActivity extends AppCompatActivity {

    EditText nameData;
    EditText emailData;
    EditText messageData;
    Button send;
    Button details;
    Firebase firebase;

    //SIDEBAR MENU
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //FEEDBACK
        nameData = findViewById(R.id.editText_nameData);
        emailData = findViewById(R.id.editText_emailData);
        messageData = findViewById(R.id.editText_messageData);

        send = findViewById(R.id.button_send);
        details = findViewById(R.id.button_details);

        Firebase.setAndroidContext(this);

        String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://kalkulator-recepturowy.firebaseio.com/feedback/" + UniqueID);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setEnabled(true);
                final String name = nameData.getText().toString();
                final String email = emailData.getText().toString();
                final String message = messageData.getText().toString();

                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()) {
                    nameData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    nameData.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty()) {
                    emailData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    emailData.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (message.isEmpty()) {
                    messageData.setError("To pole jest wymagane!");
                    send.setEnabled(false);

                } else {
                    messageData.setError(null);
                    send.setEnabled(true);
                }
                Toast.makeText(feedbackActivity.this, "Wiadomość zostałą wysłana", Toast.LENGTH_SHORT).show();

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(feedbackActivity.this)
                                .setTitle("Szczegoły wiadomości:")
                                .setMessage("Imię - " + name + "\n\nEmail - " + email + "\n\nWiadomość - " + message)
                                .show();
                    }
                });
            }
        });
    }
}
