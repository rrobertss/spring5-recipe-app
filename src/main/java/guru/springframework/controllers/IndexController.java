/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 30 sty 2019  22:03:34
 *  Author:  RS
 */
package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *<p></p><br>30 sty 2019
 * @author RS
 *
 */
@Controller
public class IndexController {

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String getIndexPage() {
		return "index";
	}
}
