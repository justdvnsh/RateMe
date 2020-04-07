package com.divyansh.rateme.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.divyansh.rateme.R;

import java.util.prefs.Preferences;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.min_range)
    EditText minRange;
    @BindView(R.id.max_range)
    EditText maxRange;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ButterKnife.bind(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Pref", 0);
        editor = sharedPreferences.edit();

        minRange.setText(sharedPreferences.getString("minRange", "0"));
        maxRange.setText(sharedPreferences.getString("maxRange", "9"));

    }

    @OnClick(R.id.settings_save_btn)
    public void saveRange() {

//        if ( ( minRange.getText().toString() == "" ) || ( maxRange.getText().toString() == "" ) ) {
//            Toast.makeText(getApplicationContext(), "Please Fill in the values", Toast.LENGTH_SHORT).show();
//        }
//
//        if ((minRange.getText().toString() == "") && maxRange.getText().toString() == "") {
//            Toast.makeText(getApplicationContext(), "Please fill in the values", Toast.LENGTH_SHORT).show();
//        }

        if (Integer.parseInt(minRange.getText().toString()) < 0 ) {
            Toast.makeText(getApplicationContext(), "Select a value above 0", Toast.LENGTH_SHORT).show();
        }

        if (Integer.parseInt(maxRange.getText().toString()) > 9 ) {
            Toast.makeText(getApplicationContext(), "Select a value below 9", Toast.LENGTH_SHORT).show();
        }

        editor.putString("minRange", minRange.getText().toString());
        editor.putString("maxRange", maxRange.getText().toString());
        editor.commit();

        Toast.makeText(getApplicationContext(), "Saved the ranges !", Toast.LENGTH_SHORT).show();
        finish();
    }
}
