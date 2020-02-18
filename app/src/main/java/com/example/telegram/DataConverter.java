package com.example.telegram;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.telegram.database.TelegramMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {


    @TypeConverter
    public static String ListToString(List<TelegramMessage> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<TelegramMessage>>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static List<TelegramMessage> stringToList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<TelegramMessage>>() {
        }.getType();
        List<TelegramMessage> list = gson.fromJson(json, type);
        return list;
    }


}
@Entity
@TypeConverters(DataConverter.class)
class SortedAttribute {

    @PrimaryKey
    private int idProduct;

    private String reference;

    private List<TelegramMessage> measurements = null;
}

