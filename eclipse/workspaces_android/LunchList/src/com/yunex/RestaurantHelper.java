package com.yunex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class RestaurantHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "lunchlist.db";
	private static final int SCHEMA_VERSION = 1;

	public RestaurantHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "";
		
		sql += "CREATE TABLE restaurants (";
		sql += "  _id INTEGER PRIMARY KEY AUTOINCREMENT,";
		sql += "  name TEXT,";
		sql += "  address TEXT,";
		sql += "  type TEXT,";
		sql += "  notes TEXT";
		sql += ");";
		
		db.execSQL(sql);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public void insert(String name, String address, String type, String notes) {
		ContentValues cv = new ContentValues();
		
		cv.put("name", name);
		cv.put("address", address);
		cv.put("type", type);
		cv.put("notes", notes);
		
		getWritableDatabase().insert("restaurants", "name", cv);
		
	}
	
	public Cursor getAll() {
		String sql = "";
		
		sql += "SELECT _id, name, address, type, notes FROM restaurants ORDER BY name";
		
		return getReadableDatabase().rawQuery(sql, null);
	}
	
	public String getName(Cursor c) {
		return c.getString(1);
	}
	
	public String getAddress(Cursor c) {
		return c.getString(2);
	}
	
	public String getType(Cursor c) {
		return c.getString(3);
	}
	
	public String getNotes(Cursor c) {
		return c.getString(4);
	}
}
