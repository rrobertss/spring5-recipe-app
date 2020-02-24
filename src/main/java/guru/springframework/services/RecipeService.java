/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 11 lut 2019  21:22:27
 *  Author:  RS
 */
package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 *<p></p><br>11 lut 2019
 * @author RS
 *
 */
public interface RecipeService {

	Set<Recipe>getRecipes();
	Recipe findById(Long id);
	RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
	RecipeCommand findCommandById(Long id);
	void deleteById(Long id);
}
