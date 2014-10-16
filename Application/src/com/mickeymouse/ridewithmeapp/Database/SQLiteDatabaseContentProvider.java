package com.mickeymouse.ridewithmeapp.Database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDatabaseContentProvider
{
	private SQLiteManager mManager;
	private Context context;
	private SQLiteDatabase mDb;
	
	public SQLiteDatabaseContentProvider(Context context)
	{
		this.context = context;
		this.mManager = new SQLiteManager(context);
		mDb = mManager.getReadableDatabase();
	}
	
}
