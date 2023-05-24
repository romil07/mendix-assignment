package com.mendix.Service;

import com.mendix.db.RecipeDao;
import com.mendix.models.Recipe;
import com.mendix.models.RecipeCategory;
import com.mendix.models.request.CreateRecipeRequest;
import com.mendix.models.response.CreateRecipeResponse;
import com.mendix.models.response.GetCategoriesResponse;
import com.mendix.models.response.GetRecipeResponse;
import com.mendix.models.response.GetRecipesResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Provider
@Singleton
public class RecipesServiceImpl implements RecipeService {

    private RecipeDao recipeDao;

    @Inject
    public RecipesServiceImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
    @Override
    public GetRecipesResponse getRecipes() {
        List<Recipe> recipes = recipeDao.getAllRecipes();
        List<GetRecipeResponse> recipeResponses = recipes.stream().map(DataTransformer::toResponse).collect(Collectors.toList());
        return GetRecipesResponse.builder().recipes(recipeResponses).build();
    }

    @Override
    public GetRecipesResponse getRecipesByCategory(RecipeCategory category) {
        List<Recipe> recipes = recipeDao.getRecipesByCategory(category);
        List<GetRecipeResponse> recipeResponses = recipes.stream().map(DataTransformer::toResponse).collect(Collectors.toList());
        return GetRecipesResponse.builder().recipes(recipeResponses).build();
    }

    @Override
    public GetRecipesResponse searchRecipes(String searchKey) {
        List<Recipe> recipes = recipeDao.getRecipesBySearchCriteria(searchKey);
        List<GetRecipeResponse> recipeResponses = recipes.stream().map(DataTransformer::toResponse).collect(Collectors.toList());
        return GetRecipesResponse.builder().recipes(recipeResponses).build();
    }

    @Override
    public CreateRecipeResponse addRecipe(CreateRecipeRequest createRecipeRequest) {
        Recipe recipe = DataTransformer.toRecipe(createRecipeRequest);
        Long id = recipeDao.addRecipe(recipe);
        return DataTransformer.toResponse(createRecipeRequest, id);
    }

    @Override
    public GetCategoriesResponse getAllCategories() {
        Set<RecipeCategory> recipeCategories = recipeDao.getAllCategories();
        return GetCategoriesResponse.builder().categories(recipeCategories).build();
    }


}
