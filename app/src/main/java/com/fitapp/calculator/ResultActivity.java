package com.fitapp.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fitapp.R;
import com.fitapp.util.BMI;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        BMI bmi = (BMI) getIntent().getSerializableExtra("bmi");

        double bmiResult = bmi.berechnen(bmi.kilo, bmi.groesse);
        String bmiString = String.valueOf(bmiResult);

        TextView tv = findViewById(R.id.textViewResult);
        tv.setText(bmiString);


    }
}