/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package example.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int SCHEMA_VERSION = 1;
    public static final String DB_NAME = "ContentProviderExample";
    public static final String TABLE_NAME = "example";
    public static final String ID_COL = "_id";
    public static final String WORD_COL = "name";
    private Context context = null;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA_VERSION);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME
                + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WORD_COL + "TEXT)";
        db.execSQL(createTable);

        String[] words = context.getResources().getStringArray(R.array.words);
        String insert = "INSERT INTO " + TABLE_NAME
                + "(" + WORD_COL + ") "
                + "VALUES (?)";

        for (String word : words) {
            db.execSQL(insert, new String[]{word});
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // no op
    }

    public Cursor getCursor() {
        String[] columns = {ID_COL, WORD_COL};
        return this.getReadableDatabase().query(TABLE_NAME, columns, null, null, null, null, null);
    }
}
