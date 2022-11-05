package recipes.businesslayer;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    Integer createRecipe(Recipe recipe);

    Optional<Recipe> readRecipe(Integer id);

    void deleteRecipe(Integer id);

    boolean isRecipeExists(Integer id);

    void updateRecipe(Integer id, Recipe recipe);

    List<Recipe> searchByCategory(String category);

    List<Recipe> searchByName(String name);
}
