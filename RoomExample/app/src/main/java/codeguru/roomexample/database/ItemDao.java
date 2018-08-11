package codeguru.roomexample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM item")
    List<Item> getItems();

    @Query("SELECT * FROM item WHERE id = :id")
    Item getItem(int id);

    @Insert
    void insertItem();

    @Update
    void updateItem();

    @Delete
    void deleteItem();
}
