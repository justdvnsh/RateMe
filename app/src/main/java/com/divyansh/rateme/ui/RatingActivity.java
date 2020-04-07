package com.divyansh.rateme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.divyansh.rateme.R;
import com.divyansh.rateme.data.Rating;
import com.divyansh.rateme.viewModels.addRatingViewModel;

import java.time.LocalDateTime;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RatingActivity extends AppCompatActivity {

    @BindView(R.id.rateMe)
    SeekBar rateMe;
    @BindView(R.id.rate)
    Button rate;
    @BindView(R.id.name)
    EditText name;

    private SharedPreferences sharedPreferences;
    private String minRange;
    private String maxRange;
    private int rating;
    private addRatingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ButterKnife.bind(this);

        sharedPreferences = getApplication().getSharedPreferences("Pref", 0);

        minRange = sharedPreferences.getString("minRange", "0");
        maxRange = sharedPreferences.getString("maxRange", "10");

        viewModel = ViewModelProviders.of(this).get(addRatingViewModel.class);

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
                rateMe.setProgress(0);
                viewModel.insertRating(new Rating(rating, name.getText().toString(), new Date()));
                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
