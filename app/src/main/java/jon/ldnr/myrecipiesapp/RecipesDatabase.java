package jon.ldnr.myrecipiesapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Recipe.class, User.class, Step.class, Type.class}, version = 1, exportSchema = false)
public abstract class RecipesDatabase extends RoomDatabase {

    public abstract RecipeDao recipeDao();
    public abstract StepDao stepDao();
    public abstract TypeDao typeDao();
    public abstract UserDao userDao();
    private static RecipesDatabase INSTANCE;

    public static RecipesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecipesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RecipesDatabase.class, "recipes_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//        private final WordDao mWDao;
        private final RecipeDao mRDao;
        private final StepDao mSDao;
        private final UserDao mUDao;
        private final TypeDao mTDao;


        PopulateDbAsync(@NonNull RecipesDatabase db) {
//            mWDao = db.wordDao();
            mRDao = db.recipeDao();
            mSDao = db.stepDao();
            mUDao = db.userDao();
            mTDao = db.typeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mSDao.deleteSteps();
            Step step = new Step("Etape 1, faire blkfeazolkdeaz", "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwic4rnP4ejhAhUhA2MBHcOECeoQjRx6BAgBEAU&url=https%3A%2F%2Fwww.mr-bricolage.fr%2Fmaison%2Fcuisine-et-salle-de-bains-1%2Fma-cuisine.html&psig=AOvVaw0_RTUFjCZ2lVo5fc2JJoXK&ust=1556196434288921");
            mSDao.insertStep(step);
            step = new Step("Etape 2, dfioezjoidjze", "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiXheTx4ejhAhWkAWMBHfDGBBEQjRx6BAgBEAU&url=%2Furl%3Fsa%3Di%26source%3Dimages%26cd%3D%26ved%3D%26url%3Dhttps%253A%252F%252Fwww.plan-travail-bois-massif.com%252Funivers-cuisine%252F%26psig%3DAOvVaw0_RTUFjCZ2lVo5fc2JJoXK%26ust%3D1556196434288921&psig=AOvVaw0_RTUFjCZ2lVo5fc2JJoXK&ust=1556196434288921");
            mSDao.insertStep(step);

            mTDao.deleteTypes();
            Type type = new Type("Dessert", "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjet4Or4ujhAhV3DGMBHX9aCfoQjRx6BAgBEAU&url=http%3A%2F%2Fchefsimon.com%2Fselections%2Ffarandole-de-desserts-pour-terminer-l-annee-en-douceur&psig=AOvVaw0OnwAov_slGa5Tcx361fSp&ust=1556196622138242");
            mTDao.insertType(type);
            type = new Type("Entrées", "http://res.cloudinary.com/hv9ssmzrz/image/fetch/c_fill,f_auto,g_auto,h_256,q_auto,w_256/http://s3-eu-west-1.amazonaws.com/images-ca-1-0-1-eu/recipe_photos/large/106817/salade-roi-gradlon-3000x2008.jpg");
            mTDao.insertType(type);

            User user = new User("admin", "admin");
            User user2 = new User("toto", "test");
            mUDao.insertUser(user);
            mUDao.insertUser(user2);

            mRDao.deleteRecipes();
            Recipe recipe = new Recipe("Recette très bonne", "Ingrédients très bons", "Ustensiles de pro", "2s", "miam miam");
            mRDao.insertRecipe(recipe);
            recipe = new Recipe("Recette bof", "ingrédients : moyens", "ustensiles préhistoroqieus", "5h", "hùùfzemzem");
            mRDao.insertRecipe(recipe);

            return null;
        }
    }
}
