package jon.ldnr.myrecipiesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        private final TextView recipeItemView;

        private RecipeViewHolder(View itemView) {
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.title_recipe);
        }
    }

    private final LayoutInflater mInflater;
    private List<Recipe> mRecipes; // cached copy of words
//    private List<Type> mTypes; // cached copy of types

    RecipeListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        if (mRecipes != null) {
            Recipe current = mRecipes.get(position);
            holder.recipeItemView.setText(current.getTitle());
        } else {
            holder.recipeItemView.setText("_-_-_-_-_");
        }

    }

    void setRecipes(List<Recipe> recipes) {
        mRecipes = recipes;
        notifyDataSetChanged();
    }

//    void setTypes(List<Type> types) {
//        mTypes = types;
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemCount() {
        if (mRecipes != null) {
            return mRecipes.size();
        } else {
            return 0;
        }
    }
}
