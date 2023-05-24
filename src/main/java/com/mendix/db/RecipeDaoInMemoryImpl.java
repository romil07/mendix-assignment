package com.mendix.db;

import com.mendix.Service.RecipesServiceImpl;
import com.mendix.models.Recipe;
import com.mendix.models.RecipeCategory;

import java.util.*;
import java.util.stream.Collectors;


public class RecipeDaoInMemoryImpl implements RecipeDao {

    private long lastRecipeId;
    private final List<Recipe> recipes;
    private Map<RecipeCategory, List<Recipe>> categoryToRecipe;

    public RecipeDaoInMemoryImpl() {
        this.recipes = new ArrayList<>();
        this.categoryToRecipe = new HashMap<>();
    }

    public List<Recipe> getAllRecipes() {
        return this.recipes;
    }

    public List<Recipe> getRecipesByCategory(RecipeCategory category) {
        if (!categoryToRecipe.containsKey(category)) {
            return new ArrayList<>();
        } else {
            return categoryToRecipe.get(category);
        }
    }

    @Override
    public List<Recipe> getRecipesBySearchCriteria(String searchKey) {
        return recipes.stream().filter(x -> DaoHelper.search(x, searchKey) != null).collect(Collectors.toList());
    }

    @Override
    public long addRecipe(Recipe recipe) {
        recipe.setId(++lastRecipeId);
        recipes.add(recipe);

        for (RecipeCategory category : recipe.getCategories()) {
            if (!categoryToRecipe.containsKey(category)) {
                List<Recipe> lst = new ArrayList<>();
                lst.add(recipe);
                categoryToRecipe.put(category, lst);
            } else {
                categoryToRecipe.get(category).add(recipe);
            }
        }

        return lastRecipeId;
    }

    @Override
    public Set<RecipeCategory> getAllCategories() {
        return categoryToRecipe.keySet();
    }
}
