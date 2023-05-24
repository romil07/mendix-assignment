package com.mendix;

import com.mendix.resources.CategoryResource;
import com.mendix.resources.RecipesResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class RecipeManagerApplication extends Application<RecipeManagerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RecipeManagerApplication().run(args);
    }

    @Override
    public String getName() {
        return "recipemanager";
    }

    @Override
    public void initialize(final Bootstrap<RecipeManagerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RecipeManagerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(RecipesResource.class);
        environment.jersey().register(CategoryResource.class);
    }

}
