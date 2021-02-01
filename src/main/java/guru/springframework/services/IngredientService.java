package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

/**
 * <p>Skladniki przepisu</p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2020-12-31  15:16
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(long recipeId, long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteIngredientById(Long recipeId, Long ingredientId);

}
