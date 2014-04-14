package codeguru.checkablelistview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "checkable.db";

    public static final int SCHEMA = 0;

    private static final String CREATE = "CREATE TABLE words (_id INTEGER PRIMARY KEY AUTOINCREMENT, word TEXT)";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing
    }
}
