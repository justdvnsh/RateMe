package com.divyansh.rateme.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ratingDao {

    @Query("SELECT * FROM " + Rating.TABLE_NAME)
    LiveData<List<Rating>> getRatings();

    @Insert(onConflict = REPLACE)
    void addRating(Rating rating);

    @Delete
    void delete(Rating rating);

    @Update(onConflict = REPLACE)
    void update(Rating rating);
}
