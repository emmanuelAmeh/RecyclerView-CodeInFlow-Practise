package com.example.android.recyclerviewcodeinflowpractise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private ArrayList<Recipe> mRecipeList;

    public RecipeAdapter(ArrayList<Recipe> recipeList) {
        mRecipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        RecipeViewHolder recipeViewHolder = new RecipeViewHolder(v);
        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe currentRecipeItem = mRecipeList.get(position);

        holder.recipeImage.setImageResource(currentRecipeItem.getRecipeImageSrc());
        holder.recipeTitle.setText(currentRecipeItem.getRecipeTitle());
        holder.recipeDesc.setText(currentRecipeItem.getRecipeDesc());

    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        public TextView recipeTitle;
        public TextView recipeDesc;
        public ImageView recipeImage;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            recipeTitle = itemView.findViewById(R.id.textView);
            recipeDesc = itemView.findViewById(R.id.textView2);
            recipeImage = itemView.findViewById(R.id.imageView);

        }
    }
}
