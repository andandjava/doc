package com.example.explv_webservice5;

import java.io.IOException;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBHelper extends DatabaseHelper {

	private final String TABLE_CATEGORIES= "Categories";
	
	public DBHelper(Context context) throws IOException {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void insertCategory(String id, String data)
			throws Exception {

		// deleteAllData(WHERE_TO_STAY);
		try {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues cv = new ContentValues();

			cv.put("cat_id", id);
			cv.put("response", data);

			db.insert(TABLE_CATEGORIES, null, cv);
			db.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertSlideImagesContent(String lang_id, String loc_id,
			String data) throws Exception {
	}

	public void insertDestinationCategory1(String id, String data,
			String language_id) throws Exception {
	}

	public void updateDestinationCategory(String uniqueName, String data)
			throws Exception {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues cv = new ContentValues();

		cv.put("response", data);

		db.update(TABLE_CATEGORIES, cv, "cat_id" + "=?",
				new String[] { uniqueName });
	}

	public void deleteAll(String tablename) {
		SQLiteDatabase db = this.getWritableDatabase();
		// return db.delete(tablename, null, null);

		Log.d("query", tablename);
		db.execSQL(tablename);
	}

}