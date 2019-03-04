/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 24 lut 2019  18:37:45
 *  Author:  RS
 */
package guru.springframework.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 *<p></p><br>24 lut 2019
 * @author RS
 *
 */
public class CategoryTest {

	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception{
		Long idValue = 4L;
		category.setId(idValue);
		
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception{
		
	}
	
	
	@Test
	public void getRecipes() throws Exception{
		
	}
}
