package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Dao;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface RecipeDao {

    @Insert
    void insertRecipe(Recipe recipe);

    @Delete
    void deleteRecipe(Recipe recipe);

    @Update
    void updateRecipe(Recipe recipe);

    @Query("DELETE FROM recipes")
    void deleteRecipes();

    @Query("SELECT * FROM recipes")
    public LiveData<List<Recipe>> getAllRecipes();
//
//    @Query("SELECT * FROM recipes WHERE title LIKE '%' + :searchRecipeBySearch + '%'")
//    public LiveData<List<Recipe>> getRecipeBySearch(String searchRecipeBySearch);
//
//    @Query("SELECT * FROM recipes WHERE id_type LIKE :searchRecipeByType")
//    public LiveData<List<Recipe>> getRecipeByType(int searchRecipeByType);

}
