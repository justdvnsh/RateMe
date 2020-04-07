package com.divyansh.rateme.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalDateTime;
import java.util.Date;

import static com.divyansh.rateme.data.Rating.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Rating {

    public static final String TABLE_NAME = "ratings";
    public static final String DATE_FIELD = "date";

    @PrimaryKey(autoGenerate = true)
    public int id;
    private int rating;
    private String name;
    @TypeConverters(DateTypeConverter.class)
    private Date date;

    public Rating(int rating, String name, Date date) {
        this.name = name;
        this.rating = rating;
        this.date = date;
    }

//    public int getId() {
//        return id;
//    }


    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }


    public Date getDate() {
        return date;
    }


}
