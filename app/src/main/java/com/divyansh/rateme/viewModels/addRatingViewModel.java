package com.divyansh.rateme.viewModels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.divyansh.rateme.data.AppDatabase;
import com.divyansh.rateme.data.Rating;

public class addRatingViewModel extends AndroidViewModel {

    private AppDatabase db;

    public addRatingViewModel(@NonNull Application application) {
        super(application);

        db = AppDatabase.getInstance(this.getApplication());
    }

    public void insertRating(Rating rating) {
        new insertRatingAsyncTask(db).execute(rating);
    }

    private static class insertRatingAsyncTask extends AsyncTask<Rating, Void, Void> {

        private AppDatabase db;

        insertRatingAsyncTask(AppDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Rating... ratings) {
            db.ratingDao().addRating(ratings[0]);
            return null;
        }
    }
}
