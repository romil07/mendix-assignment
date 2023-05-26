package com.mendix;

import com.google.inject.AbstractModule;
//import com.mendix.Service.CategoryService;
//import com.mendix.Service.CategoryServiceImpl;
import com.mendix.Service.RecipeService;
import com.mendix.Service.RecipesServiceImpl;
import com.mendix.db.RecipeDao;
import com.mendix.db.RecipeDaoInMemoryImpl;
//import com.mendix.resources.CategoryResource;
import com.mendix.resources.RecipesResource;

public class RecipeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RecipesResource.class);
        //bind(CategoryResource.class);
        bind(RecipeService.class).to(RecipesServiceImpl.class);
        bind(RecipeDao.class).to(RecipeDaoInMemoryImpl.class);
        //bind(CategoryService.class).to(CategoryServiceImpl.class);
    }
}
