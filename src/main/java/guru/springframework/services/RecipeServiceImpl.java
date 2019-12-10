/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 11 lut 2019  21:22:41
 *  Author:  RS
 */
package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *<p></p><br>11 lut 2019
 * @author RS
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	
	private final RecipeRepository recipeRepository;
	private final RecipeToRecipeCommand recipeToRecipeCommand;
	private final RecipeCommandToRecipe recipeCommandToRecipe;

	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {

		this.recipeRepository = recipeRepository;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
	}

	
	@Override
	public Set<Recipe> getRecipes() {
//		log.debug("getRecipes");
		Set<Recipe> set = new HashSet<>();
		// dzialaja obydwie, z Javy 8
//		recipeRepository.findAll().iterator().forEachRemaining(recipe -> set.add(recipe));
		recipeRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}

	@Override
	public Recipe findById(Long id) {
		Optional<Recipe>optionalRecipe = recipeRepository.findById(id);
		if (!optionalRecipe.isPresent())
			throw new RuntimeException("Recipe not found");
		return optionalRecipe.get();
	}

	@Transactional
	@Override
	public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
		Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
		Recipe savedRecipe = recipeRepository.save(recipe);
		log.debug("Save recipe, new recipe id is "+savedRecipe.getId());

		return recipeToRecipeCommand.convert(savedRecipe);
	}


	@Transactional
	@Override
	public RecipeCommand findCommandById(Long id) {
		return recipeToRecipeCommand.convert(findById(id));
	}


}
