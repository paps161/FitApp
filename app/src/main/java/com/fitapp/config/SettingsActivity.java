// Autor: Selina Weber | Letzte Änderung: 16.05.2026
package com.fitapp.config;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.calculator.EntryActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.rating.LegendActivity;

public class SettingsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_settings);

        Button btn = findViewById(R.id.UserActivityButton);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, UserActivity.class));
        });

        Button btn2 = findViewById(R.id.newLoginButton);
        btn2.setOnClickListener(v -> {
            //Popup2
        });

    }
}
