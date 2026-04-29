package com.fitapp.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fitapp.R;
import com.fitapp.util.BMI;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entry);

        Button btnS = findViewById(R.id.buttonSubmit);
        btnS.setOnClickListener(v ->{
            EditText kiloText = findViewById(R.id.editTextNumberKilo);
            EditText groesseText = findViewById(R.id.editTextNumberGroesse);

            String kiloString = kiloText.getText().toString();
            String groesseString = groesseText.getText().toString();

            double kilo = Double.parseDouble(kiloString);
            double groesse = Double.parseDouble(groesseString);

            BMI bmi = new BMI(kilo, groesse);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("bmi", bmi);

            startActivity(intent);
        });

    }
}