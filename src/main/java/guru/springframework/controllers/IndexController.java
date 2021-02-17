/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 30 sty 2019  22:03:34
 *  Author:  RS
 */
package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *<p></p><br>30 sty 2019
 * @author RS
 *
 */
@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}


	@RequestMapping({"", "/", "/index", "/index.html"})
	public String getIndexPage(Model model) {
//		log.debug("get index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
}
