// Autor: Selina Weber | Letzte Änderung: 31.05.2026
package com.fitapp.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitapp.MainActivity;
import com.fitapp.R;
import com.fitapp.calculator.EntryActivity;
import com.fitapp.config.SettingsActivity;
import com.fitapp.rating.LegendActivity;
import com.fitapp.util.DatabaseConnection;

import java.util.ArrayList;

public class OverviewActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        menu.findItem(R.id.OverviewActivity).setEnabled(false);
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
        } else if (menuItem.getItemId() == R.id.SettingsActivity) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        var selectedLogins = getIntent().getStringArrayExtra("selected-logins");

        var measurementList = (ListView) findViewById(R.id.measurementList);
        loadMeasurements(measurementList, selectedLogins);

        var buttonFilter = (Button) findViewById(R.id.buttonFilter);
        buttonFilter.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, FilterActivity.class), 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            var selectedLogins = data.getStringArrayExtra("selected-logins");
            var measurementList = (ListView) findViewById(R.id.measurementList);
            loadMeasurements(measurementList, selectedLogins);
        }
    }

    private void loadMeasurements(ListView measurementList, String[] selectedLogins) {
        var db = new DatabaseConnection(this).getReadableDatabase();

        String selection = null;
        String[] selectionArgs = null;
        if (selectedLogins != null && selectedLogins.length > 0) {
            var placeholders = new StringBuilder();
            for (int i = 0; i < selectedLogins.length; i++) {
                placeholders.append(i == 0 ? "?" : ",?");
            }
            selection = "login IN (" + placeholders + ")";
            selectionArgs = selectedLogins;
        }

        var cursor = db.query("measurement",
                new String[]{"date", "login", "height", "weight", "bmi"},
                selection, selectionArgs, null, null, "date DESC");

        var items = new ArrayList<String>();
        while (cursor.moveToNext()) {
            items.add(cursor.getString(0) + " | " + cursor.getString(1) +
                    " | " + cursor.getDouble(2) + "cm" +
                    " | " + cursor.getDouble(3) + "kg" +
                    " | BMI: " + cursor.getDouble(4));
        }
        cursor.close();

        var adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        measurementList.setAdapter(adapter);
    }
}
