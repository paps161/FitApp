// Autor: Selina Weber | Letzte Änderung: 10.05.2026
package com.fitapp.rating;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.calculator.EntryActivity;
import com.fitapp.config.SettingsActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.util.BMI;

public class DetailActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        menu.findItem(R.id.LegendActivity).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.MainActivity) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (menuItem.getItemId() == R.id.EntryActivity) {
            startActivity(new Intent(this, EntryActivity.class));
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
        setContentView(R.layout.activity_detail);

        var index = getIntent().getIntExtra("list-element", 0);
        var kategorie = BMI.kategorien[index];

        var outputTextViewAllgemein = (TextView) findViewById(R.id.textViewAllgemein);
        var outputTextViewSpezifisch = (TextView) findViewById(R.id.textViewSpezifisch);
        var outputTextViewMin = (TextView) findViewById(R.id.textViewMin);
        var outputTextViewMax = (TextView) findViewById(R.id.textViewMax);

        outputTextViewAllgemein.setText(kategorie.allgemein);
        outputTextViewSpezifisch.setText(kategorie.spezifisch);
        outputTextViewMin.setText(kategorie.min == -1 ? "-" : String.valueOf(kategorie.min));
        outputTextViewMax.setText(kategorie.max == -1 ? "-" : String.valueOf(kategorie.max));
    }
}
