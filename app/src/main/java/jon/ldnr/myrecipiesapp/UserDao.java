package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.Dao;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE username LIKE :checkUser AND password LIKE :checkPassword")
    public LiveData<List<User>> checkUser(String checkUser, String checkPassword);

    @Query("SELECT * FROM users")
    public LiveData<List<User>> getAllUsers();

    @Insert
    void insertUser(User user);

    @Query("DELETE from users")
    void deleteUsers();

}
