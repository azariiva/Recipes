package recipes.businesslayer.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import recipes.businesslayer.Recipe;
import recipes.businesslayer.RecipeService;
import recipes.persistance.CrudRecipeRepository;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class PersistentRecipeService implements RecipeService {

    private final CrudRecipeRepository recipeRepository;

    public PersistentRecipeService(CrudRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Integer createRecipe(Recipe recipe) {
        var savedRecipe = recipeRepository.save(recipe);
        return savedRecipe.getId();
    }

    @Override
    public Optional<Recipe> readRecipe(Integer id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public boolean isRecipeExists(Integer id) {
        return recipeRepository.existsById(id);
    }

    @Override
    public void updateRecipe(Integer id, Recipe recipe) {
        recipe.setId(id);
        recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> searchByCategory(String category) {
        return recipeRepository.findRecipesByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    @Override
    public List<Recipe> searchByName(String name) {
        return recipeRepository.findRecipesByNameContainingIgnoreCaseOrderByDateDesc(name);
    }
}
