// Autor: Selina Weber | Letzte Änderung: 31.05.2026
package com.fitapp.calculator;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.config.SettingsActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.rating.LegendActivity;
import com.fitapp.util.BMI;
import com.fitapp.util.DatabaseConnection;

import java.time.LocalDate;

public class ResultActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        menu.findItem(R.id.EntryActivity).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.MainActivity) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (menuItem.getItemId() == R.id.LegendActivity) {
            startActivity(new Intent(this, LegendActivity.class));
            return true;
        } else if (menuItem.getItemId() == R.id.OverviewActivity) {
            startActivity(new Intent(this, OverviewActivity.class));
            return true;
        } else if (menuItem.getItemId() == R.id.SettingsActivity) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        var bmi = (BMI) getIntent().getSerializableExtra("bmi");
        var result = bmi.berechnen(bmi.kilo, bmi.groesse);

        var textViewBMI = (TextView) findViewById(R.id.textViewBMI);
        textViewBMI.setText("BMI: " + result);

        var buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v -> {
            var login = getSharedPreferences("prefs", MODE_PRIVATE)
                    .getString("current-user", "<anonymous>");
            var values = new ContentValues();
            values.put("date", LocalDate.now().toString());
            values.put("login", login);
            values.put("height", bmi.groesse);
            values.put("weight", bmi.kilo);
            values.put("bmi", result);
            try (var dbHelper = new DatabaseConnection(this)) {
                dbHelper.getWritableDatabase().insert("measurement", null, values);
            }
        });
    }
}
