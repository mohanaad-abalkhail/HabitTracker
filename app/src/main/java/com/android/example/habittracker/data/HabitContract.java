package com.android.example.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by MOHANAAD on 4/6/17.
 */

public class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_READ_PAPER = "read";
        public final static String COLUMN_WALK_5MILES = "walk";
        public final static String COLUMN_DO_SOMETHING_NEW = "Do";

        public static final int READ_PAPER = 1;
        public static final int DIDNT_READ = 0;
        public static final int WALKED_5MILES = 1;
        public static final int DIDNT_WALK = 0;
    }
}
