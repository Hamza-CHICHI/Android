package com.example.tp3.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "Users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;

    @ColumnInfo(name = "user_login")
    @NonNull
    public String login;

    @ColumnInfo(name = "user_pass")
    @NonNull
    public String pass;

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    @NonNull
    public String getPass() {
        return pass;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    public void setPass(@NonNull String pass) {
        this.pass = pass;
    }
}
