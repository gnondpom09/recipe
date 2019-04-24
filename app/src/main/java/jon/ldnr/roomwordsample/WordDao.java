package jon.ldnr.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    // insert without SQL
    @Insert
    void insert(Word word);

    // using @Query to define deleteAll operation
    @Query("DELETE FROM word_table")
    void deleteAll();

    // using @Query to define getAllWords operation
    @Query("SELECT * FROM word_table ORDER by word ASC")
    LiveData<List<Word>> getAllWords();

/*    // Delete one record
    @Delete
    void delete(Word word);

    // Update one record
    void update(Word word);*/
}


