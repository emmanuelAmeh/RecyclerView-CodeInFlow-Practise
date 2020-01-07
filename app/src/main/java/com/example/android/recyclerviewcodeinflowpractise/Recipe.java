package com.example.android.recyclerviewcodeinflowpractise;

public class Recipe {
    private String mRecipeTitle;
    private String mRecipeDesc;
    private int mRecipeImageSrc;

    public Recipe(String recipeTitle, String recipeDesc, int recipeImageSrc) {
        mRecipeTitle = recipeTitle;
        mRecipeDesc = recipeDesc;
        mRecipeImageSrc = recipeImageSrc;
    }

    public String getRecipeTitle() {
        return mRecipeTitle;
    }

    public String getRecipeDesc() {
        return mRecipeDesc;
    }

    public int getRecipeImageSrc() {
        return mRecipeImageSrc;
    }
}
