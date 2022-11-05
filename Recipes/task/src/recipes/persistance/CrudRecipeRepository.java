package recipes.persistance;

import org.springframework.data.repository.CrudRepository;
import recipes.businesslayer.Recipe;

import java.util.List;

public interface CrudRecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findRecipesByCategoryIgnoreCaseOrderByDateDesc(String category);

    List<Recipe> findRecipesByNameContainingIgnoreCaseOrderByDateDesc(String name);
}
