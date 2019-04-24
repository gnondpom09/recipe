package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private int userId;

    @ColumnInfo(name = "username")
    @NonNull
    private String userName;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId=id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
