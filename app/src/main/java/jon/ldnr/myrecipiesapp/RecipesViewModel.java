package jon.ldnr.myrecipiesapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class RecipesViewModel extends AndroidViewModel {

    // private reference to our word repository
    private RecipeRepository mRepository;

    // private reference to our word list to be able to cache our datas
    private LiveData<List<Recipe>> mAllRecipes;
    private LiveData<List<User>> mAllUsers;
    private LiveData<List<Type>> mAllTypes;
    private LiveData<List<Step>> mAllSteps;

    // constructor will invoke our repository and our word list
    public RecipesViewModel(Application application) {
        super(application);
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllRecipes();
        mAllUsers = mRepository.getAllUsers();
        mAllSteps = mRepository.getAllSteps();
        mAllTypes = mRepository.getAllTypes();
    }

    // getter to get our words
    // implementation is "hidden" from UI.
    LiveData<List<Recipe>> getAllRecipes() {
        return mAllRecipes;
    }

    LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    LiveData<List<Type>> getAllTypes() {
        return mAllTypes;
    }

    LiveData<List<Step>> getAllSteps() {
        return mAllSteps;
    }


    // Wrapper insert method which call insert method from our repository
    // still 'hidden' from UI

    public void insert(User user) {
        mRepository.insertUser(user);
    }

    public void insert(Step step) {
        mRepository.insertStep(step);
    }

    public void insert(Type type) {
        mRepository.insertType(type);
    }

    // dépend du insert() déclaré dans notre RecipeRepository ligne 51
    public void insert(Recipe recipe) {
         mRepository.insertRecipe(recipe);
    }

}
