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

public class DataConverterTwo {


    @TypeConverter
    public static String ListToString(List<String> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static List<String> stringToList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(json, type);
        return list;
    }

}

@Entity
@TypeConverters(DataConverterTwo.class)
class SortedAttributeTwo {

    @PrimaryKey
    private int idProduct;

    private String reference;

    private List<String> list = null;
}