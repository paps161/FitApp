// Autor: Selina Weber | Letzte Änderung: 10.05.2026
package com.fitapp.rating;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.calculator.EntryActivity;
import com.fitapp.config.SettingsActivity;
import com.fitapp.history.OverviewActivity;
import com.fitapp.util.BMI;

public class LegendActivity extends AppCompatActivity {

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

        setContentView(R.layout.activity_legend);

        var categoryList = (ListView) findViewById(R.id.categoryList);
        String[] categories = new String[BMI.kategorien.length];
        for (int i = 0; i < BMI.kategorien.length; i++) {
            var k = BMI.kategorien[i];
            categories[i] = k.spezifisch.isEmpty() ? k.allgemein : k.allgemein + " – " + k.spezifisch;
        }

        var adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        categoryList.setAdapter(adapter);

        categoryList.setOnItemClickListener((parent, view, position, id) -> {
            var intent = new Intent(this, DetailActivity.class);
            intent.putExtra("list-element", position);
            startActivity(intent);
        });
    }
}
