package codeguru.roomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Item.class, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    public abstract ItemDao exampleDao();
}
