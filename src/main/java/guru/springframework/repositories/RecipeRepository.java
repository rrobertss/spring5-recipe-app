/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  16:46:13
 *  Author:  RS
 */
package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

/**
 *<p></p><br>10 lut 2019
 * @author RS
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

	
}
