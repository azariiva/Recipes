package recipes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import recipes.businesslayer.Recipe;
import recipes.businesslayer.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/recipe")
public interface RecipeController {

    @PostMapping(path = "/new")
    @ResponseStatus(code = HttpStatus.OK)
    Map<String, Integer> postRecipe(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid Recipe recipe
    );

    @GetMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Recipe getRecipe(@PathVariable(name = "id") Integer id);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteRecipe(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Integer id
    );

    @PutMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void putRecipe(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Integer id,
            @RequestBody @Valid Recipe recipe
    );

    @GetMapping(path = "/search")
    @ResponseStatus(code = HttpStatus.OK)
    List<Recipe> searchRecipes(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "name", required = false) String name
    );
}
