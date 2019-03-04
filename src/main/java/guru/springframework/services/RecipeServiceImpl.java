/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 11 lut 2019  21:22:41
 *  Author:  RS
 */
package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 *<p></p><br>11 lut 2019
 * @author RS
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	
	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	
	@Override
	public Set<Recipe> getRecipes() {
//		log.debug("getRecipes");
		Set<Recipe> set = new HashSet<Recipe>();
		// dzialaja obydwie, z Javy 8
//		recipeRepository.findAll().iterator().forEachRemaining(recipe -> set.add(recipe));
		recipeRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}
	
	
	
}
