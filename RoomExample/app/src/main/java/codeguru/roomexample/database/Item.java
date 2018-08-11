package codeguru.roomexample.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey
    public int id;
    public String content;
    public String details;
}