package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.Dao;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StepDao {

    // create with SQLite
    @Insert
    void insertStep(Step step);

    @Delete
    void deleteStep(Step step);

    @Delete
    void deleteSteps(Step... step);

    @Query("SELECT * FROM steps")
    public LiveData<List<Step>> getAllSteps();

    @Query("SELECT * FROM steps WHERE id_step LIKE :searchStepById")
    public LiveData<List<Step>> searchStepById(int searchStepById);

    @Update
    void updateStep(Step step);
}
