package com.mendix.db;

import com.mendix.models.Recipe;
import com.mendix.models.RecipeCategory;

import java.util.*;

public interface RecipeDao {

    //recipe APIS
    public List<Recipe> getAllRecipes();

    public List<Recipe> getRecipesByCategory(RecipeCategory category);

    public List<Recipe> getRecipesBySearchCriteria(String searchKey);

    public long addRecipe(Recipe recipe);

    //category APIs
    public Set<RecipeCategory> getAllCategories();
}
