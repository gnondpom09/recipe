package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.Dao;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TypeDao {

    // create with SQLite
    @Insert
    void insertType(Type type);

    @Delete
    void deleteType(Type type);

    @Query("DELETE FROM dishtypes")
    void deleteTypes();

    @Query("SELECT * FROM dishtypes")
    public LiveData<List<Type>> getAllTypes();

    @Query("SELECT * FROM dishtypes WHERE typename LIKE :searchType")
    public LiveData<List<Type>> searchType(String searchType);

//    @Query("SELECT typename FROM dishtypes WHERE id_type LIKE :idTypeRecipe")
//    public LiveData<List<Type>> getTypeNameById(int idTypeRecipe);

    @Update
    void updateType(Type type);


}
