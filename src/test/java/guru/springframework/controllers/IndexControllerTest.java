/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 27 lut 2019  20:55:22
 *  Author:  RS
 */
package guru.springframework.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;

/**
 *<p></p><br>27 lut 2019
 * @author RS
 *
 */
public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	@Mock
	Model model;
	
	IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController(recipeService);
	}
	
	// testowanie za pomoca Spring MockMVC
	@Test
	public void testMocMVC() throws Exception{
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}
	

	/**
	 * Test method for {@link guru.springframework.controllers.IndexController#getIndexPage(org.springframework.ui.Model)}.
	 */
	@Test
	public void testGetIndexPage() {
//		fail("Not yet implemented");
		// given
		Set<Recipe>recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setId(2L);
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		// when
		String viewName = indexController.getIndexPage(model);
				
		// then		
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe>setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
}

}
