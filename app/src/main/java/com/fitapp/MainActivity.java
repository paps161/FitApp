// Autor: Selina Weber | Letzte Änderung: 29.04.2026
package com.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fitapp.calculator.EntryActivity;
import com.fitapp.config.SettingsActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.rating.LegendActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        menu.findItem(R.id.MainActivity).setEnabled(false);
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
            
        }else if (menuItem.getItemId() == R.id.LegendActivity) {
            startActivity(new Intent(this, LegendActivity.class));
            return true;

        }else if (menuItem.getItemId() == R.id.OverviewActivity) {
            startActivity(new Intent(this, OverviewActivity.class));
            return true;

        }else if (menuItem.getItemId() == R.id.SettingsActivity) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, EntryActivity.class));
        });
    }



}