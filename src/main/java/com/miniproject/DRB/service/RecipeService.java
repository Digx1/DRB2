package com.miniproject.DRB.service;

import com.miniproject.DRB.entity.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    Recipe getRecipeById(Long id);
    List<Recipe> getAllRecipes();
    Recipe updateRecipe(Long id, Recipe updatedRecipe);
    void deleteRecipe(Long id);
}
