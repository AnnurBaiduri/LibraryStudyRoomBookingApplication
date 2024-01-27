package com.example.bottomnav.ui.book;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LibraryBooking.db";
    private static final int DATABASE_VERSION = 1;

    // Define the table and column names
    public static final String TABLE_BOOKINGS = "bookings";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STUDENT_ID = "student_id";
    public static final String COLUMN_START_TIME = "start_time";
    public static final String COLUMN_END_TIME = "end_time";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_PAX = "pax";

    // SQL statement to create the bookings table
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_BOOKINGS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_STUDENT_ID + " TEXT," +
                    COLUMN_START_TIME + " TEXT," +
                    COLUMN_END_TIME + " TEXT," +
                    COLUMN_DATE + " TEXT," +
                    COLUMN_PAX + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public long saveBooking(String name, String idNumber, String date, String startTime, String endTime, String pax) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_STUDENT_ID, idNumber);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_START_TIME, startTime);
        values.put(COLUMN_END_TIME, endTime);
        values.put(COLUMN_PAX, pax);

        // Insert the new row, returning the primary key value of the new row
        return db.insert(TABLE_BOOKINGS, null, values);
    }

    public void logDatabaseContent() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BOOKINGS, null);

        if (cursor.moveToFirst()) {
            do {
                // Extract data from the cursor
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String idNumber = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") String startTime = cursor.getString(cursor.getColumnIndex(COLUMN_START_TIME));
                @SuppressLint("Range") String endTime = cursor.getString(cursor.getColumnIndex(COLUMN_END_TIME));
                @SuppressLint("Range") String pax = cursor.getString(cursor.getColumnIndex(COLUMN_PAX));

                // Log the data to Logcat
                Log.d("Database Content", "ID: " + id + ", Name: " + name + ", ID Number: " + idNumber +
                        ", Date: " + date + ", Start Time: " + startTime + ", End Time: " + endTime + ", Pax: " + pax);

            } while (cursor.moveToNext());
        }

        // Close the cursor and database connection
        cursor.close();
        db.close();
    }

}
