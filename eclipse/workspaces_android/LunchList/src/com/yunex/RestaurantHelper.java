package com.yunex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class RestaurantHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "lunchlist.db";
	private static final int SCHEMA_VERSION = 3;

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
		sql += "  notes TEXT,";
		sql += "  feed TEXT,";
		sql += "  lat REAL,";
		sql += "  lon REAL ";
		sql += ");";
		
		db.execSQL(sql);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "";
		
		if (oldVersion < 2) {
			sql = "ALTER TABLE restaurants ADD COLUMN feed TEXT";
			db.execSQL(sql);
		}
		
		if (oldVersion < 3) {
			sql = "ALTER TABLE restaurants ADD COLUMN lat REAL";
			db.execSQL(sql);
			sql = "ALTER TABLE restaurants ADD COLUMN lon REAL";
			db.execSQL(sql);
		}
	}
	
	public void insert(String name, String address, String type, String notes, String feed) {
		ContentValues cv = new ContentValues();
		
		cv.put("name", name);
		cv.put("address", address);
		cv.put("type", type);
		cv.put("notes", notes);
		cv.put("feed", feed);
		
		getWritableDatabase().insert("restaurants", "name", cv);
		
	}
	
	public Cursor getAll(String orderBy) {
		String sql = "";
		
		sql += "SELECT _id, name, address, type, notes, lat, lon FROM restaurants ORDER BY " + orderBy;
		
		return getReadableDatabase().rawQuery(sql, null);
	}
	
	public Cursor getById(String id) {
		String[] args = {id};
		String sql = "";
		
		sql += "SELECT _id, name, address, type, notes, feed, lat, lon FROM restaurants WHERE _id = ?";
		
		return getReadableDatabase().rawQuery(sql, args);
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
	
	public String getFeed(Cursor c) {
		return c.getString(5);
	}
	
	public double getLatitude(Cursor c){
		return c.getDouble(6);
	}
	
	public double getLongitude(Cursor c) {
		return c.getDouble(7);
	}
	
	public void update(String id, String name, String address, String type, String notes, String feed) {
		ContentValues cv = new ContentValues();
		String[] args = {id};
		
		cv.put("name", name);
		cv.put("address", address);
		cv.put("type", type);
		cv.put("notes", notes);
		cv.put("feed", feed);
		
		getWritableDatabase().update("restaurants", cv, "_ID=?", args);
	}
	
	public void updateLocation(String id, double lat, double lon) {
		ContentValues cv = new ContentValues();
		String[] args = {id};
		
		cv.put("lat", lat);
		cv.put("lon", lon);
		
		getWritableDatabase().update("restaurants", cv, "_ID=?", args);
	}

}
