package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 *  2019-11-20 RS
 */
@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    /**
     * Rendering view
     * @param model
     * @return view's name
     */
    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        // recipe/new - jest sciezka w pasku adresu przegladarki
        // zwraca nazwe widoku - pliku html
        return "recipe/recipeform";
    }

    /**
     * PathVariable wyciaga id z Springa MVC i przekazuje do modelu
     * @param id
     * @param model
     * @return
     */
    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }


    /**
     * Adnotacja ModelAttribute laczy pola formularza z obiektem recipeCommand
     * @param recipeCommand {@link RecipeCommand}
     * @return
     */
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Delete recipe "+id);
        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }
}
