package com.divyansh.rateme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.divyansh.rateme.R;
import com.divyansh.rateme.adapters.RecyclerViewAdapter;
import com.divyansh.rateme.data.Rating;
import com.divyansh.rateme.viewModels.ratingViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRatingsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ratingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_ratings);


        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(new ArrayList<Rating>());
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ratingViewModel.class);
        viewModel.getAllRatings().observe(this, new Observer<List<Rating>>() {
            @Override
            public void onChanged(List<Rating> ratings) {
                adapter.addRatings(ratings);
            }
        });
    }
}
