package mainPackage.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mainPackage.Hw1Application;
import mainPackage.domain.Actor;
import mainPackage.domain.Film;

@Controller
public class ActorController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new ActorValidator());
	}
	
	@RequestMapping(value = "/actors", method=RequestMethod.GET)
	public String actors(@RequestParam("film") long id, Model model) {
		Film selectedFilm = null;
		 for (Film f : Hw1Application.films) {
            if (f.getId() == id) {
            	selectedFilm = f;            	
            }
        } 
		model.addAttribute("actors", selectedFilm.getActors());
		model.addAttribute("filmid", id);
		return "actors/list";
	}
	
	@RequestMapping(value = "/newActor", method=RequestMethod.GET)
	public String newActor(@RequestParam("film") long id, Model model) {
		model.addAttribute("actor", new Actor());
		model.addAttribute("filmid", id);
		return "actors/form";
	}
	
	@PostMapping("/addActor")
	public String addActor(@RequestParam("film") long id, @Valid @ModelAttribute Actor actor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("filmid", id);
			return "actors/form";
		}
		Film selectedFilm = null;
		 for (Film f : Hw1Application.films) {
            if (f.getId() == id) {
            	selectedFilm = f;            	
            }
        } 
		selectedFilm.getActors().add(actor);
		return "redirect:/films";
	}
	
}
