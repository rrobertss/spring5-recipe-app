/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 27 lut 2019  21:19:43
 *  Author:  RS
 */
package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 *<p></p><br>27 lut 2019
 * @author RS
 *
 */
public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;
	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;
	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository, recipeToRecipeCommand, recipeCommandToRecipe);
	}


	@Test
	public void getRecipeByIdTest() throws Exception{
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe>recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		Recipe recipeReturned = recipeService.findById(1L);
		assertNotNull("Null recipe returned", recipeReturned);
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}

	@Test
	public void getRecipeCommandByIdTest() throws Exception{
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe>optionalRecipe = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(1L);

		when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

		RecipeCommand commamdById = recipeService.findCommandById(1L);

		assertNotNull("Null recipe returned", commamdById);
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}


	/**
	 * Test method for {@link guru.springframework.services.RecipeServiceImpl#getRecipes()}.
	 */
	@Test
	public void getRecipesTest() {
		Recipe recipe = new Recipe();
		HashSet<Recipe>recipesData = new HashSet<Recipe>();
		recipesData.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipesData);
		
		Set<Recipe>recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		
		verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void testDeleteById() throws Exception{
		// given
		Long id = new Long(2L);

		// brak 'when' - gdy metoda zwraca void
		recipeService.deleteById(id);

		// then
		verify(recipeRepository, times(1)).deleteById(anyLong());

	}
}
