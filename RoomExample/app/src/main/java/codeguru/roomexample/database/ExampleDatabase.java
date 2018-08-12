package codeguru.roomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = Item.class, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    static ExampleDatabase instance;

    public static ExampleDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, ExampleDatabase.class, "room-example.db").build();
        }

        return instance;
    }

    ExampleDatabase() {}

    public abstract ItemDao exampleDao();
}
