package com.fakhrunnisaa.pmob_1.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface UserDao {
    @Query("SELECT * FROM User where nim= :nim and password= :password")
    User getUser(String nim, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
