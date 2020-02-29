package com.example.tp3.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface User_DAO {

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    public void	add_User (User user);

    @Query("select * from Users	where user_login = :login")
    public List<User> get_User(String login);

    @Query("select * from Users")
    public List<User> get_Users();

    @Query("select count(*) from Users")
    public List<Integer> count_Users();

    @Delete
    public void delet_user(User	user);

    @Update
    public void	update_user(User user);
}
