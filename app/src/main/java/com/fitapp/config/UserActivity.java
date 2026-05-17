// Autor: Selina Weber | Letzte Änderung: 16.05.2026
package com.fitapp.config;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.calculator.EntryActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.rating.LegendActivity;

public class UserActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        menu.findItem(R.id.SettingsActivity).setEnabled(false);
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
        } else if (menuItem.getItemId() == R.id.LegendActivity) {
            startActivity(new Intent(this, LegendActivity.class));
            return true;
        } else if (menuItem.getItemId() == R.id.OverviewActivity) {
            startActivity(new Intent(this, OverviewActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        var prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        var logins = new String[] { "<anonymous>" };

        var loginSpinner = (Spinner) findViewById(R.id.loginSpinner);
        var adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, logins);
        loginSpinner.setAdapter(adapter);

        loginSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs.edit().putString("current-user", logins[position]).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}