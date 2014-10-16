package com.mickeymouse.ridewithmeapp.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class SQLiteManager extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "mydatabase.sqlite3";
    private static final int DATABASE_VERSION = 1;

    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
