package com.divyansh.rateme.data;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateTypeConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
