package com.divyansh.rateme.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.divyansh.rateme.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{


    private SharedPreferences sharedPreferences;

    @BindView(R.id.rate_btn)
    Button saveBtn;

    private String minRange;
    private String maxRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        sharedPreferences = getApplication().getSharedPreferences("Pref", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        minRange = sharedPreferences.getString("minRange", "0");
        maxRange = sharedPreferences.getString("maxRange", "9");
        saveBtn.setText("Rate " + minRange + " - " + maxRange);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RatingActivity.class));
            }
        });
    }



    @Override
    protected void onPause() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.saved_ratings) {
            startActivity(new Intent(this, SavedRatingsActivity.class));
        }

        if (id == R.id.settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("minRange")) {
            minRange = sharedPreferences.getString("minRange", "0");
            saveBtn.setText("Rate " + minRange + " - " + maxRange);
        }

        if (key.equals("maxRange")) {
            maxRange = sharedPreferences.getString("maxRange", "9");
            saveBtn.setText("Rate " + minRange + " - " + maxRange);
        }
    }
}
