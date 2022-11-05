package recipes.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import recipes.businesslayer.Recipe;
import recipes.businesslayer.RecipeService;
import recipes.businesslayer.User;
import recipes.controller.RecipeController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class RestRecipeController implements RecipeController {

    private final RecipeService recipeService;

    public RestRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @Override
    public Map<String, Integer> postRecipe(User user, Recipe recipe) {
        recipe.setUser(user);
        var recipeId = recipeService.createRecipe(recipe);
        return Map.of("id", recipeId);
    }

    @Override
    public Recipe getRecipe(Integer id) {
        return recipeService.readRecipe(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteRecipe(User user, Integer id) {
        var recipe = recipeService.readRecipe(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!Objects.equals(recipe.getUser().getId(), user.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipeService.deleteRecipe(id);
    }

    @Override
    public void putRecipe(User user, Integer id, Recipe recipe) {
        var savedRecipe = recipeService.readRecipe(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!Objects.equals(savedRecipe.getUser().getId(), user.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipe.setUser(user);
        recipeService.updateRecipe(id, recipe);
    }

    @Override
    public List<Recipe> searchRecipes(String category, String name) {
        if ((category == null && name == null) || (category != null && name != null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (category != null) {
            return recipeService.searchByCategory(category);
        }
        return recipeService.searchByName(name);
    }
}
