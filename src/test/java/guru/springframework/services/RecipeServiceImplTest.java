/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 27 lut 2019  21:19:43
 *  Author:  RS
 */
package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

/**
 *<p></p><br>27 lut 2019
 * @author RS
 *
 */
public class RecipeServiceImplTest {
	
	@Mock
	RecipeRepository recipeRepository;
	
	RecipeService recipeService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	/**
	 * Test method for {@link guru.springframework.services.RecipeServiceImpl#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		HashSet<Recipe>recipesData = new HashSet<Recipe>();
		recipesData.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipesData);
		
		Set<Recipe>recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		
		verify(recipeRepository, times(1)).findAll();
	}

}
