/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 11 lut 2019  21:22:27
 *  Author:  RS
 */
package guru.springframework.services;

import java.util.Set;

import guru.springframework.domain.Recipe;

/**
 *<p></p><br>11 lut 2019
 * @author RS
 *
 */
public interface RecipeService {

	Set<Recipe>getRecipes();
}
