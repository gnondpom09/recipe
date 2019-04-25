package jon.ldnr.myrecipiesapp;

import android.app.FragmentManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Constants
    public static final int NEW_RECIPE_ACTIVITY_REQUEST_CODE = 1;

    // Properties
    private WordViewModel mWordViewModel;

    /**
     * Create view of application
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Create app and toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get elements
        RecyclerView listOfRecipes = findViewById(R.id.list_of_recipes);

        // Set view of list layout
        final WordListAdapter adapter = new WordListAdapter(this);
        listOfRecipes.setAdapter(adapter);
        listOfRecipes.setLayoutManager(new LinearLayoutManager(this));

        // Event change for elements of list
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // update cached copy of words in the adapter
                adapter.setWords(words);
            }
        });
    }

    /**
     * Create options menu
     * @param menu menu
     * @return true if options menu is created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handle action bar item clicks
     * @param item item of menu
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            // Click on login option
            case R.id.action_login:
                // Open login form
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Item activity result
     * @param requestCode request code
     * @param resultCode result code
     * @param data data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

/*        if (requestCode == NEW_RECIPE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(getApplicationContext(), R.string.empty_not_saved, Toast.LENGTH_LONG).show();
        }*/
    }

    /**
     * Event to open form for add new recipe
     * @param view view
     */
    public void btnAddNewRecipe(View view) {

        // Open form
        Intent formIntent = new Intent(this, FormAddNewRecipe.class);
        startActivityForResult(formIntent, NEW_RECIPE_ACTIVITY_REQUEST_CODE);

    }
}
