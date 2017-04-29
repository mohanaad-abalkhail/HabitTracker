package com.android.example.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.example.habittracker.data.HabitContract;
import com.android.example.habittracker.data.HabitContract.HabitEntry;
import com.android.example.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);

        insertHabit();
        readHabits();
    }

    private Cursor readHabits() {
        db = mDbHelper.getReadableDatabase();

        String [] project = {
                HabitEntry._ID,
                HabitEntry.COLUMN_READ_PAPER,
                HabitEntry.COLUMN_DO_SOMETHING_NEW,
                HabitEntry.COLUMN_WALK_5MILES
        };

        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                project,
                null,
                null,
                null,
                null,
                null);
        try {

            return cursor;

        }finally {

            cursor.close();
        }
    }

    private void insertHabit(){

        db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HabitEntry.COLUMN_READ_PAPER, HabitEntry.READ_PAPER);
        values.put(HabitEntry.COLUMN_DO_SOMETHING_NEW, "Drink Green Tea");
        values.put(HabitEntry.COLUMN_WALK_5MILES, HabitEntry.DIDNT_WALK);

        long newRowId = db.insert(HabitEntry.TABLE_NAME,null,values);
    }
}
