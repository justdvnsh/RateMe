package com.divyansh.rateme.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.divyansh.rateme.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RatingActivity extends AppCompatActivity {

//    @BindView(R.id.rateMe)
    SeekBar rateMe;
    Button rate;

    private SharedPreferences sharedPreferences;
    private String minRange;
    private String maxRange;
    private int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        sharedPreferences = getApplication().getSharedPreferences("Pref", 0);

        minRange = sharedPreferences.getString("minRange", "0");
        maxRange = sharedPreferences.getString("maxRange", "10");
        rateMe = findViewById(R.id.rateMe);
        rate = findViewById(R.id.rate);
        rateMe.setMax(Integer.parseInt(maxRange));

        rateMe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == Integer.parseInt(minRange)) {
                    rating = progress;
                } else if (progress == Integer.parseInt(maxRange)) {
                    rating = progress;
                } else {
                    rating = progress + Integer.parseInt(minRange);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
