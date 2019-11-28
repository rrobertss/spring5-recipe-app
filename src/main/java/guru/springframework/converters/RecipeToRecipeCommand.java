package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * <p></p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2019-11-28  20:54
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand notesConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final CategoryToCategoryCommand categoryConverter;

    public RecipeToRecipeCommand(NotesToNotesCommand notesConverter, IngredientToIngredientCommand ingredientConverter, CategoryToCategoryCommand categoryConverter) {
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null)
            return null;

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        if (source.getIngredients() != null && !source.getIngredients().isEmpty()){
          /*  for (Ingredient ingredient : source.getIngredients()){
                recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient));
            }*/
          source.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        if (source.getCategories() != null && !source.getCategories().isEmpty()){
            source.getCategories().forEach(category -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
        }

        return recipeCommand;
    }
}
