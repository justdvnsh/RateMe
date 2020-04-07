package com.divyansh.rateme.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.divyansh.rateme.data.AppDatabase;
import com.divyansh.rateme.data.Rating;

import java.util.List;

public class ratingViewModel extends AndroidViewModel {

    private final LiveData<List<Rating>> ratingList;

    private AppDatabase db;

    public ratingViewModel(@NonNull Application application) {
        super(application);

        db = AppDatabase.getInstance(this.getApplication());

        ratingList = db.ratingDao().getRatings();
    }

    public LiveData<List<Rating>> getAllRatings() {
        return ratingList;
    }
}
