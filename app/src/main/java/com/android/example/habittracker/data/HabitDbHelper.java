package com.android.example.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MOHANAAD on 4/6/17.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    private final static String DB_NAME = "habits.db";
    private final static int DB_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_READ_PAPER + " INTEGER NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_DO_SOMETHING_NEW + " TEXT NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_WALK_5MILES + " INTEGER NOT NULL ); ";

        Log.v(LOG_TAG, SQL_CREATE_PETS_TABLE);

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
