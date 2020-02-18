package com.example.telegram.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database( entities = {TelegramList.class , TelegramChat.class , TelegramMessage.class} , version  = 1 , exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract Dao dao();



    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class , "my_database.db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        if (INSTANCE != null) INSTANCE.close();
        INSTANCE = null;
    }

}
