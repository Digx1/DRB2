package com.miniproject.DRB.controller;
import com.miniproject.DRB.entity.Recipe;
import com.miniproject.DRB.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recipes")
public class ViewController {
    @Autowired
    private RecipeRepository recipeRepository;

    // Display all recipes
    @GetMapping
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeRepository.findAll();
        recipes.sort(Comparator.comparing(Recipe::getId));
        model.addAttribute("recipes", recipes);
        return "recipe-list";
    }

    // Display recipe creation form
    @GetMapping("/add")
    public String createRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe-create";
    }

    // Handle recipe creation
    @PostMapping
    public String saveRecipe(@ModelAttribute Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }

    // Display recipe edit form
    @GetMapping("/edit/{id}")
    public String editRecipeForm(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(id);
        if (recipeOpt.isPresent()) {
            model.addAttribute("recipe", recipeOpt.get());
            return "recipe-edit";
        } else {
            // If the recipe is not found, redirect to the list page with an error message
            model.addAttribute("errorMessage", "Recipe not found.");
            return "redirect:/recipes";
        }
    }

    // Handle recipe update
    @PostMapping("/update")
    public String updateRecipe(@ModelAttribute Recipe recipe) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(recipe.getId());
        if (existingRecipe.isPresent()) {
            recipeRepository.save(recipe);
        } else {
            // Handle the case where the recipe doesn't exist
            System.out.println("Attempted to update a non-existing recipe.");
        }
        return "redirect:/recipes";
    }
    // Delete a recipe
    @PostMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/recipes";
    }
}
