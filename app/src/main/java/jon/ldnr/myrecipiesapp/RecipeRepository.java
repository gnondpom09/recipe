package jon.ldnr.myrecipiesapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class RecipeRepository {

//    private WordDao mWordDao;
    private RecipeDao mRDao;
    private StepDao mSDao;
    private UserDao mUDao;
    private TypeDao mTDao;
    private LiveData<List<Recipe>> mAllRecipes;
    private LiveData<List<User>> mAllUsers;
    private LiveData<List<Step>> mAllSteps;
    private LiveData<List<Type>> mAllTypes;

    // constructor
    RecipeRepository(Application application) {
        RecipesDatabase db = RecipesDatabase.getDatabase(application);
        mRDao = db.recipeDao();
        mSDao = db.stepDao();
        mUDao = db.userDao();
        mTDao = db.typeDao();
        mAllRecipes = mRDao.getAllRecipes();
        mAllUsers = mUDao.getAllUsers();
        mAllSteps = mSDao.getAllSteps();
        mAllTypes = mTDao.getAllTypes();
    }

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


    public void insertUser(User user) {
        new insertUserAsyncTask(mUDao).execute(user);
    }

    public void insertStep(Step step) {
        new insertStepAsyncTask(mSDao).execute(step);
    }

    public void insertType(Type type) {
        new insertTypeAsyncTask(mTDao).execute(type);
    }

    public void insertRecipe(Recipe recipe) {
        new insertRecipeAsyncTask(mRDao).execute(recipe);
    }

    private static class insertRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {
        private RecipeDao mAsyncTaskRecipeDao;
        insertRecipeAsyncTask(RecipeDao rDao) {
            mAsyncTaskRecipeDao = rDao;
        }

        @Override
        protected Void doInBackground(final Recipe... rParams) {
            mAsyncTaskRecipeDao.insertRecipe(rParams[0]);
            return null;
        }
    }

    private static class insertTypeAsyncTask extends AsyncTask<Type, Void, Void> {
        private TypeDao mAsyncTaskTypeDao;
        insertTypeAsyncTask(TypeDao tDao) {
            mAsyncTaskTypeDao = tDao;
        }

        @Override
        protected Void doInBackground(final Type... tParams) {
            mAsyncTaskTypeDao.insertType(tParams[0]);
           return null;
        }
    }

    private static class insertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mAsyncTaskUserDao;
        insertUserAsyncTask(UserDao uDao) {
            mAsyncTaskUserDao = uDao;
        }
        @Override
        protected Void doInBackground(final User... uParams) {
            mAsyncTaskUserDao.insertUser(uParams[0]);
            return null;
        }
    }

    private static class insertStepAsyncTask extends AsyncTask<Step, Void, Void> {
        private StepDao mAsyncTaskStepDao;
        insertStepAsyncTask(StepDao sDao) {
            mAsyncTaskStepDao = sDao;
        }
        @Override
        protected Void doInBackground(final Step... sParams) {
            mAsyncTaskStepDao.insertStep(sParams[0]);
            return null;
        }
    }

}


